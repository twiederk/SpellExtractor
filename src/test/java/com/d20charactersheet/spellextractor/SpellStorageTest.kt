package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpellStorageTest {

    @Test
    fun loadSpellNamesFromFile_fileWithSpellNames_listOfSpellNames() {

        // act
        val spellNames = SpellStorage().loadSpellNamesFromFile("./src/test/resources/spell_names.txt")

        // assert
        assertThat(spellNames).containsExactly(
            "Acid Splash",
            "Aid",
            "Crusader''s Mantle",
            "Enlarge/Reduce",
            "Melf''s Acid Arrow",
        )

    }
}