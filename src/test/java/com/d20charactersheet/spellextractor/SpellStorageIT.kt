package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class SpellStorageIT {

    @Test
    fun save_simpleSpellName_savedToFile() {
        // arrange

        // act
        val file = SpellStorage().save("Acid Splash", "html content")

        // assert
        assertThat(file).hasFileName("Acid Splash.html")
        assertThat(file).hasContent("html content")

        // tear down
        file.delete()
    }

    @Test
    fun save_spellNameWithSlash_savedToFile() {
        // arrange

        // act
        val file = SpellStorage().save("Enlarge/Reduce", "html content")

        // assert
        assertThat(file).hasFileName("Enlarge_Reduce.html")
        assertThat(file).hasContent("html content")

        // tear down
        file.delete()
    }

    @Test
    fun save_spellNameWithSingleQuote_savedToFile() {
        // arrange

        // act
        val file = SpellStorage().save("Melf''s Acid Arrow", "html content")

        // assert
        assertThat(file).hasFileName("Melf__s Acid Arrow.html")
        assertThat(file).hasContent("html content")

        // tear down
        file.delete()
//        Melf''s Acid Arrow

    }

    @Test
    fun loadSpellNamesFromFile_fileWithSpellNames_listOfSpellNames() {

        // act
        val spellNames = SpellStorage().loadSpellNamesFromFile("./src/test/resources/spell_names_test.txt")

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