package com.d20charactersheet.spellextractor

import java.io.File

open class SpellStorage {

    fun save(spellName: String, spellHtml: String): File {
        val fileName = spellName.replace("/", "_").replace("'", "_")
        val file = File("$fileName.html")
        file.writeText(spellHtml)
        return file
    }

    fun loadSpellNamesFromFile(filename: String): List<String> {
        return File(filename).readLines()
    }

}
