package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TextCleanerTest {

    @Test
    fun clean_containsSpecialDashes_replaceWithNormalDash() {

        // act
        val cleanedTest = TextCleaner().clean("−5 and —10")

        // assert
        assertThat(cleanedTest).isEqualTo("-5 and -10")
    }

    @Test
    fun clean_containsSemicolon_replaceWithComma() {

        // act
        val cleanedTest = TextCleaner().clean("checks; next")

        // assert
        assertThat(cleanedTest).isEqualTo("checks, next")
    }

    @Test
    fun clean_containsSpecialQuote_replaceWithSingleQuote() {

        // act
        val cleanedTest = TextCleaner().clean("her name is ’Barbara’")

        // assert
        assertThat(cleanedTest).isEqualTo("her name is 'Barbara'")
    }

    @Test
    fun clean_containsBulletPoint_replaceWithDash() {

        // act
        val cleanedTest = TextCleaner().clean("• backpack")

        // assert
        assertThat(cleanedTest).isEqualTo("- backpack")
    }

    @Test
    fun clean_containsSpecialMultiplySign_replaceWithNormalMultiplySign() {

        // act
        val cleanedTest = TextCleaner().clean("1d4 × 2")

        // assert
        assertThat(cleanedTest).isEqualTo("1d4 * 2")
    }

    @Test
    fun clean_containsTab_replaceWithSpace() {

        // act
        val cleanedTest = TextCleaner().clean("Name\tBarbara")

        // assert
        assertThat(cleanedTest).isEqualTo("Name Barbara")
    }

    @Test
    fun convertHtml_containsDoubleQuote_replaceWithSingleQuote() {

        // act
        val convertedHtml = TextCleaner().convertHtml("""<th class="center">""")

        // assert
        assertThat(convertedHtml).isEqualTo("<th class='center'>")
    }

    @Test
    fun convertHtml_containsNewLine_removeFromText() {

        // act
        val cleanedDescription = TextCleaner().convertHtml("that is all.\n Start new")

        // assert
        assertThat(cleanedDescription).isEqualTo("that is all. Start new")
    }

}