package com.d20charactersheet.spellextractor

class SpellParser {

    fun parseSpell(spellName: String, spellHtml: String): Spell {
        val regex: Regex =
            """<strong>Range</strong>: ([0-9a-z ]+)</div><div><strong>Components</strong>: ([A-Z, ]+)</div>""".toRegex()

        val (range, component) = regex.find(spellHtml)?.destructured ?: error("error occurred")
        return Spell(
            component = component,
            range = range
        )
    }

}
