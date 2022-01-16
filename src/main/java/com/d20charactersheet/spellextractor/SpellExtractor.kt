package com.d20charactersheet.spellextractor

class SpellExtractor(
    private val spellStorage: SpellStorage = SpellStorage(),
    private val spellDownloader: SpellDownloader = SpellDownloader(),
    private val spellParser: SpellParser = SpellParser()
) {

    fun downloadSpells(filename: String): Int {
        val spellNames = spellStorage.loadSpellNamesFromFile(filename)
        return spellDownloader.downloadSpells(spellNames)
    }

    fun parseSpells(spellDir: String, spellNames: List<String>): List<Spell> {
        val spells = mutableListOf<Spell>()
        for (spellName in spellNames) {
            val spellHtml = spellStorage.loadSpellFromFile(spellDir, spellName)
            val spell = spellParser.parseSpell(spellName, spellHtml)
            spells.add(spell)
        }
        return spells
    }

}
