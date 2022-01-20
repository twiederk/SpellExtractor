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
        output.appendLine("SpellName\tParsedSpellName\tComponents\tComponentsInt\tRange\tDuration\tDescription\tmatComponents")
        for (spell in spells) {
            output.appendLine("${spell.spellName}\t${spell.parsedSpellName}\t${spell.components}\t${spell.componentsInt}\t${spell.range}\t${spell.duration}\t${spell.description}\t${spell.matcomponents}")
        }

        val file = File("$dir/parsed_spells.txt")
        file.writeText(output.toString())
        return file
    }

    fun parseAndSaveSpells(baseDir: String) {
        val spellNames = SpellStorage().loadSpellNamesFromFile("$baseDir/spell_names.txt")
        println("Loaded spell names: ${spellNames.size}")

        val spellExtractor = SpellExtractor()
        val spells = spellExtractor.parseSpells("$baseDir/spells", spellNames)
        println("Parsed spells: ${spells.size}")
        println("- name errors: ${spells.count { it.spellName.startsWith("error") }}")
        println("- parsed name errors: ${spells.count { it.parsedSpellName.startsWith("error") }}")
        println("- components errors: ${spells.count { it.components.startsWith("error") }}")
        println("- range: ${spells.count { it.range.startsWith("error") }}")
        println("- duration errors: ${spells.count { it.duration.startsWith("error") }}")
        println("- description errors: ${spells.count { it.description.startsWith("error") }}")
        spellExtractor.saveSpells(baseDir, spells)
    }

}
