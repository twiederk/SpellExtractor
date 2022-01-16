package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class SpellExtractorIT {

    @Test
    @Disabled("tear down is missing")
    fun downloadSpells_everythingFine_downloadedSpells() {

        // act
        val numberOfSpells = SpellExtractor().downloadSpells("src/test/resources/spell_names_test.txt")

        // assert
        assertThat(numberOfSpells).isEqualTo(5)
    }

    @Test
    fun parseSpells_everythingFine_parsedSpells() {
        // arrange
        val spellNames = listOf("Acid Splash", "Enlarge/Reduce", "Melf''s Acid Arrow")

        // act
        val spells = SpellExtractor().parseSpells("src/test/resources/spells", spellNames)

        // assert
        assertThat(spells).hasSize(3)
        println(spells)
    }

}