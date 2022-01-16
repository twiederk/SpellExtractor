package com.d20charactersheet.spellextractor

class SpellExtractor(
    private val spellStorage : SpellStorage = SpellStorage(),
    private val spellDownloader: SpellDownloader = SpellDownloader()
) {

    fun downloadSpells(filename: String): Int {
        val spellNames = spellStorage.loadSpellNamesFromFile(filename)
        return spellDownloader.downloadSpells(spellNames)
    }

}
