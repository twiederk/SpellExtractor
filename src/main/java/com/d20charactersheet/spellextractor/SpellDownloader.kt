package com.d20charactersheet.spellextractor

import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate
import java.lang.IllegalStateException

class SpellDownloader(
    private val restTemplate: RestTemplate = RestTemplate()
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

}
