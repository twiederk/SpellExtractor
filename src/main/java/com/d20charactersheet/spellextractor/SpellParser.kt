package com.d20charactersheet.spellextractor

class SpellParser {

    fun parseSpell(spellName: String, spellHtml: String): Spell {
        val cleanedSpellHtml = spellHtml.replace("—", "-").replace(";", ",")

        val nameRegEx: Regex = """<h1>([A-Za-z/ ']+)</h1>""".toRegex()
        val parsedSpellName = nameRegEx.find(cleanedSpellHtml)?.groupValues?.get(1) ?: "error occurred while parsing name"

        val rangeRegEx: Regex = """<strong>Range</strong>: ([A-Za-z0-9 ]+)</div>""".toRegex()
        val range = rangeRegEx.find(cleanedSpellHtml)?.groupValues?.get(1) ?: "error occurred while parsing range"

        val componentsRegEx: Regex = """<div><strong>Components</strong>: ([A-Za-z,() ']+)</div>""".toRegex()
        val components = componentsRegEx.find(cleanedSpellHtml)?.groupValues?.get(1) ?: "error occurred while parsing components"

        val durationRegEx: Regex = """<div><strong>Duration</strong>: ([A-Za-z0-9:, ]+)</div>""".toRegex()
        val duration = durationRegEx.find(cleanedSpellHtml)?.groupValues?.get(1) ?: "error occurred while parsing duration"

        val descriptionRegEx: Regex = """<div class="description ">([A-Za-z0-9,.</>\-()+ '\n]+)</div>""".toRegex()
        val description = descriptionRegEx.find(cleanedSpellHtml)?.groupValues?.get(1) ?: "error occurred while parsing description"

        return Spell(
            spellName = spellName,
            parsedSpellName = parsedSpellName,
            components = components,
            range = range,
            duration = duration,
            description = description.replace("""\n""".toRegex(), "")
        )
    }

}
