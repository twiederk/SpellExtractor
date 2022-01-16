package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpellParserTest {

    //    column to fill manually: components, range, duration, description, matcomponent
    // https://regexr.com/
    // https://rubular.com/

    @Test
    fun parseSpell_acidSplash_spellData() {
        // arrange
        val spellName = "Acid Splash"
        val spellHtml =
            """<div><strong>Casting Time</strong>: 1 action</div><div><strong>Range</strong>: 60 feet</div><div><strong>Components</strong>: V, S</div><div><strong>Duration</strong>: Instantaneous</div><div class="description ">You
            | hurl a bubble of acid. Choose one creature you can see within range, or
            | choose two creatures you can see within range that are within 5 feet of
            | each other. A target must succeed on a Dexterity saving throw or take 
            |1d6 acid damage.<br>This spell's damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).<br></div>""".trimMargin().trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Acid Splash")
        assertThat(spell.components).isEqualTo("V, S")
        assertThat(spell.range).isEqualTo("60 feet")
        assertThat(spell.duration).isEqualTo("Instantaneous")
        assertThat(spell.description).isEqualTo("You hurl a bubble of acid. Choose one creature you can see within range, or choose two creatures you can see within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.<br>This spell's damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).<br>")
    }

}