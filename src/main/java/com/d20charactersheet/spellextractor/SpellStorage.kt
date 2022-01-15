package com.d20charactersheet.spellextractor

import java.io.File

open class SpellStorage {

    fun save(spellName: String, spellHtml: String): File {
        val fileName = convertSpellNameToFileName(spellName)
        val file = File("$fileName.html")
        file.writeText(spellHtml)
        return file
    }

    private fun convertSpellNameToFileName(spellName: String) = spellName.replace("/", "_").replace("'", "_")

    fun loadSpellNamesFromFile(filename: String): List<String> {
        return File(filename).readLines()
    }

    fun loadSpellFromFile(spellDir: String, spellName: String): String {
        val fileName = convertSpellNameToFileName(spellName)
        return File("$spellDir/$fileName.html").readText(Charsets.UTF_8)
    }

}
