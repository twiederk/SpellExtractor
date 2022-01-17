package com.d20charactersheet.spellextractor

import java.io.File

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

    fun saveSpells(dir: String, spells: List<Spell>): File {
        val output = StringBuilder()
        for (spell in spells) {
            output.appendLine("${spell.spellName}\t${spell.parsedSpellName}\t${spell.components}\t${spell.range}\t${spell.duration}\t${spell.description}")
        }

        val file = File("$dir/parsed_spells.txt")
        file.writeText(output.toString())
        return file
    }

}
