package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class SpellExtractorIT {

    @Test
    @Disabled("tear down is missing")
    fun downloadSpells_everythingFine_extractedSpells() {

        // act
        val numberOfSpells = SpellExtractor().downloadSpells("src/test/resources/spell_names_test.txt")

        // assert
        assertThat(numberOfSpells).isEqualTo(5)
    }

}