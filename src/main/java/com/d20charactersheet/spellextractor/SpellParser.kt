package com.d20charactersheet.spellextractor

class SpellParser {

    /*
                """<div><strong>Casting Time</strong>: 1 action</div><div><strong>Range</strong>: 60 feet</div><div><strong>Components</strong>: V, S</div><div><strong>Duration</strong>: Instantaneous</div><div class="description ">You
             hurl a bubble of acid. Choose one creature you can see within range, or
             choose two creatures you can see within range that are within 5 feet of
             each other. A target must succeed on a Dexterity saving throw or take
            1d6 acid damage.<br>This spell's damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).<br></div>""".trimIndent()

    //    column to fill manually: components, range, duration, description, matcomponent
    // https://regexr.com/
    // https://rubular.com/

     */

    fun parseSpell(spellName: String, spellHtml: String): Spell {
        val regex: Regex =
            """<strong>Range</strong>: ([0-9a-z ]+)</div><div><strong>Components</strong>: ([A-Z, ]+)</div><div><strong>Duration</strong>: ([A-Za-z0-9]+)</div>""".toRegex()

        val (range, components, duration) = regex.find(spellHtml)?.destructured ?: error("error occurred")
        return Spell(
            components = components,
            range = range,
            duration = duration
        )
    }

}
