package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class SpellDownloaderTest {

    private lateinit var restTemplate: RestTemplate
    private lateinit var spellStorage: SpellStorage
    private lateinit var spellDownloader: SpellDownloader

    @BeforeEach
    fun beforeEach() {
        restTemplate = mock()
        spellStorage = mock()
        spellDownloader = SpellDownloader(restTemplate, spellStorage)
    }

    @Test
    fun downloadSpell_validUrl_downloadSpell() {

        // arrange
        val response: ResponseEntity<String> = mock()
        whenever(response.statusCode).thenReturn(HttpStatus.OK)
        whenever(response.body).thenReturn("Acid Splash")

        whenever(
            restTemplate.getForEntity(
                "https://www.aidedd.org/dnd/sorts.php?vo=acid-splash",
                String::class.java
            )
        ).thenReturn(response)

        // act
        val spellHtml = spellDownloader.downloadSpell("Acid Splash")

        // assert
        assertThat(spellHtml).contains("Acid Splash")
    }

    @Test
    fun downloadSpell_invalidUrl_throwsException() {

        // arrange
        val response: ResponseEntity<String> = mock()
        whenever(response.statusCode).thenReturn(HttpStatus.NOT_FOUND)
        whenever(
            restTemplate.getForEntity(
                "https://www.aidedd.org/dnd/sorts.php?vo=acid-splash",
                String::class.java
            )
        ).thenReturn(response)

        // act
        val thrown = Assertions.catchException { spellDownloader.downloadSpell("Acid Splash") }

        // assert
        assertThat(thrown)
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("HttpStatus is not OK, instead it is [404 NOT_FOUND]")
    }

    @Test
    fun convertToQueryParamValue_nameOfSpell_nameOfSpellAsQueryParamValue() {

        // act
        val queryParamValue = spellDownloader.convertToQueryParamValue("Acid Splash")

        // assert
        assertThat(queryParamValue).isEqualTo("acid-splash")
    }

    @Test
    fun downloadSpells_listOfSpells_downloadAndSaveSpells() {
        // arrange
        mockResponse("acid-splash")
        mockResponse("aid")

        val spellNames = listOf("Acid Splash", "Aid")

        // act
        val numberOfDownloadSpells = spellDownloader.downloadSpells(spellNames)

        // assert
        assertThat(numberOfDownloadSpells).isEqualTo(2)
    }

    private fun mockResponse(spellName: String) {
        val response: ResponseEntity<String> = mock()
        whenever(response.statusCode).thenReturn(HttpStatus.OK)
        whenever(response.body).thenReturn("$spellName response body")
        whenever(
            restTemplate.getForEntity(
                "https://www.aidedd.org/dnd/sorts.php?vo=${spellName}",
                String::class.java
            )
        ).thenReturn(response)
    }

}