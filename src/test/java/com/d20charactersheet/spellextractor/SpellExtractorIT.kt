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
    }

    @Test
    fun saveSpells_everythingFine_saveSpells() {
        // arrange
        val spellNames = listOf(
            Spell(
                spellName = "mySpellName1",
                parsedSpellName = "myParsedSpellName1",
                components = "myComponents1",
                componentsInt = 3,
                matcomponents = "myMatcomponents1",
                range = "myRange1",
                duration = "myDuration1",
                description = "myDescription1"
            ),
            Spell(
                spellName = "mySpellName2",
                parsedSpellName = "myParsedSpellName2",
                components = "myComponents2",
                componentsInt = 5,
                matcomponents = "myMatcomponents2",
                range = "myRange2",
                duration = "myDuration2",
                description = "myDescription2"
            ),
        )

        // act
        val parsedSpellsFile = SpellExtractor().saveSpells("src/test/resources", spellNames)

        // assert
        assertThat(parsedSpellsFile).hasFileName("parsed_spells.txt")
        assertThat(parsedSpellsFile).hasContent(
            "SpellName\tParsedSpellName\tComponents\tComponentsInt\tRange\tDuration\tDescription\tmatComponents\n" + //
                    "mySpellName1\tmyParsedSpellName1\tmyComponents1\t3\tmyRange1\tmyDuration1\tmyDescription1\tmyMatcomponents1\n" + //
                    "mySpellName2\tmyParsedSpellName2\tmyComponents2\t5\tmyRange2\tmyDuration2\tmyDescription2\tmyMatcomponents2\n" //
        )

        // tear down
        parsedSpellsFile.delete()
    }

}