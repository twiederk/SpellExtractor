package com.d20charactersheet.spellextractor

import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate

class SpellDownloader(
    private val restTemplate: RestTemplate = RestTemplate(),
    private val spellStorage: SpellStorage = SpellStorage()
) {

    fun downloadSpell(spellName: String): String {
        val url = "https://www.aidedd.org/dnd/sorts.php?vo=${convertToQueryParamValue(spellName)}"
        val response = restTemplate.getForEntity(url, String::class.java)

        if (response.statusCode != HttpStatus.OK) {
            throw IllegalStateException("HttpStatus is not OK, instead it is [${response.statusCode}]")
        }

        return checkNotNull(response.body)
    }

    fun convertToQueryParamValue(spellName: String): String {
        return spellName.lowercase().replace(' ', '-')
    }

    fun downloadSpells(spellNames: List<String>): Int {
        var numberOfDownloadedSpells = 0
        for (spellName in spellNames) {
            val spellHtml = downloadSpell(spellName)
            spellStorage.save(spellName, spellHtml)
            numberOfDownloadedSpells++
        }
        return numberOfDownloadedSpells
    }

}
