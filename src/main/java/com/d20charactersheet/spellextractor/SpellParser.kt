package com.d20charactersheet.spellextractor

class SpellParser {

    fun parseSpell(spellName: String, spellHtml: String): Spell {
        val nameRegEx : Regex = """<h1>([A-Za-z ]+)</h1>""".toRegex()
        val (parsedSpellName) = nameRegEx.find(spellHtml)?.destructured ?: error("error occurred while parsing name")

        val regex: Regex =
            """<strong>Range</strong>: ([0-9a-z ]+)</div><div><strong>Components</strong>: ([A-Z, ]+)</div><div><strong>Duration</strong>: ([A-Za-z0-9]+)</div><div class="description ">([A-Za-z0-9, <>()'.\n]+)</div>""".toRegex()
        val (range, components, duration, description) = regex.find(spellHtml)?.destructured ?: error("error occurred while parsing data")

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
