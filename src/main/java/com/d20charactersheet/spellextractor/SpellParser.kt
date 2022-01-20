package com.d20charactersheet.spellextractor

class SpellParser(private val textCleaner: TextCleaner = TextCleaner()) {

    fun parseSpell(spellName: String, spellHtml: String): Spell {
        val cleanedSpellHtml = textCleaner.clean(spellHtml)

        val nameRegEx: Regex = """<h1>([A-Za-z/ ']+)</h1>""".toRegex()
        val parsedSpellName =
            nameRegEx.find(cleanedSpellHtml)?.groupValues?.get(1) ?: "error occurred while parsing name"

        val rangeRegEx: Regex = """<strong>Range</strong>: ([A-Za-z0-9()\- ]+)</div>""".toRegex()
        val range = rangeRegEx.find(cleanedSpellHtml)?.groupValues?.get(1) ?: "error occurred while parsing range"

        val componentsRegEx: Regex =
            """<div><strong>Components</strong>: ([VSM, ]+)[ (]?([A-Za-z0-9,\- ']*)[)]?</div>""".toRegex()
        val components =
            componentsRegEx.find(cleanedSpellHtml)?.groupValues?.get(1) ?: "error occurred while parsing components"
        val matcomponents =
            componentsRegEx.find(cleanedSpellHtml)?.groupValues?.get(2) ?: "error occurred while parsing matcomponents"

        val durationRegEx: Regex = """<div><strong>Duration</strong>: ([A-Za-z0-9:, ]+)</div>""".toRegex()
        val duration = durationRegEx.find(cleanedSpellHtml)?.groupValues?.get(1) ?: "error occurred while parsing duration"

        val descriptionRegEx: Regex = """<div class="description[ ]?">([A-Za-z0-9,.</>\-()+*=:? '"\n]+)</div>""".toRegex()
        val description = descriptionRegEx.find(cleanedSpellHtml)?.groupValues?.get(1) ?: "error occurred while parsing description"

        return Spell(
            spellName = spellName,
            parsedSpellName = parsedSpellName,
            components = components,
            matcomponents = matcomponents,
            range = range,
            duration = duration,
            description = textCleaner.convertHtml(description)
        )
    }

}
