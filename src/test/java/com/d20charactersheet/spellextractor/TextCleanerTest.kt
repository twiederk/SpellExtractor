package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TextCleanerTest {

    @Test
    fun clean_containsSpecialDashes_replaceWithNormalDash() {
        // arrange
        val text = "−5 and —10"

        // act
        val cleanedTest = TextCleaner().clean(text)

        // assert
        assertThat(cleanedTest).isEqualTo("-5 and -10")
    }

    @Test
    fun clean_containsSemicolon_replaceWithComma() {
        // arrange
        val text = "checks; next"

        // act
        val cleanedTest = TextCleaner().clean(text)

        // assert
        assertThat(cleanedTest).isEqualTo("checks, next")
    }

    @Test
    fun clean_containsSpecialQuote_replaceWithSingleQuote() {
        // arrange
        val text = "her name is ’Barbara’"

        // act
        val cleanedTest = TextCleaner().clean(text)

        // assert
        assertThat(cleanedTest).isEqualTo("her name is 'Barbara'")
    }

    @Test
    fun clean_containsBulletPoint_replaceWithDash() {
        // arrange
        val text = "• backpack"

        // act
        val cleanedTest = TextCleaner().clean(text)

        // assert
        assertThat(cleanedTest).isEqualTo("- backpack")
    }

    @Test
    fun clean_containsSpecialMultiplySign_replaceWithNormalMultiplySign() {
        // arrange
        val text = "1d4 × 2"

        // act
        val cleanedTest = TextCleaner().clean(text)

        // assert
        assertThat(cleanedTest).isEqualTo("1d4 * 2")
    }

    @Test
    fun clean_containsTab_replaceSpase() {
        // arrange
        val text = "Name\tBarbara"

        // act
        val cleanedTest = TextCleaner().clean(text)

        // assert
        assertThat(cleanedTest).isEqualTo("Name Barbara")
    }

}