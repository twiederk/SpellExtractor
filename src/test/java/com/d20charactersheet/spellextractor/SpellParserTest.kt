package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpellParserTest {

    @Test
    fun parseSpell_acidSplash_spellData() {
        // arrange
        val spellName = "Acid Splash"
        val spellHtml = SpellStorage().loadSpellFromFile("src/test/resources/spells", "Acid Splash")

        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.range).isEqualTo("60 feet")
        assertThat(spell.component).isEqualTo("V, S")
    }

}