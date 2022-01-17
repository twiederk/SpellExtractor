package com.d20charactersheet.spellextractor

class SpellParser {

    fun parseSpell(spellName: String, spellHtml: String): Spell {
        val nameRegEx: Regex = """<h1>([A-Za-z ]+)</h1>""".toRegex()
        val parsedSpellName = nameRegEx.find(spellHtml)?.groupValues?.get(1) ?: "error occurred while parsing name"

        val rangeRegEx: Regex = """<strong>Range</strong>: ([0-9a-z ]+)</div>""".toRegex()
        val range = rangeRegEx.find(spellHtml)?.groupValues?.get(1) ?: "error occurred while parsing name"

        val componentsRegEx: Regex = """<div><strong>Components</strong>: ([A-Z, ]+)</div>""".toRegex()
        val components = componentsRegEx.find(spellHtml)?.groupValues?.get(1) ?: "error occurred while parsing name"

        val durationRegEx: Regex = """<div><strong>Duration</strong>: ([A-Za-z0-9]+)</div>""".toRegex()
        val duration = durationRegEx.find(spellHtml)?.groupValues?.get(1) ?: "error occurred while parsing name"

        val descriptionRegEx: Regex = """<div class="description ">([A-Za-z0-9, <>()'.\n]+)</div>""".toRegex()
        val description = descriptionRegEx.find(spellHtml)?.groupValues?.get(1) ?: "error occurred while parsing name"

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
