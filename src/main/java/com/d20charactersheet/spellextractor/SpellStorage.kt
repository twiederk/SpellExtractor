package com.d20charactersheet.spellextractor

import java.io.File

open class SpellStorage {

    fun save(spellName: String, spellHtml: String) {
        File("$spellName.html").writeText(spellHtml)
    }

    fun loadSpellNamesFromFile(filename: String) : List<String> {
        return File(filename).readLines()
    }

}
