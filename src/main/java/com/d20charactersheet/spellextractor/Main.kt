package com.d20charactersheet.spellextractor

fun main() {
//    SpellExtractor().downloadSpells("src/main/resources/spell_names.txt")

    val spellNames = SpellStorage().loadSpellNamesFromFile("src/main/resources/spell_names.txt")
    println("Loaded spell names: ${spellNames.size}")
    val spellExtractor = SpellExtractor()
    val spells = spellExtractor.parseSpells("src/main/resources/spells", spellNames)
    println("Parsed spells: ${spells.size}")
    println("- name errors: ${spells.count { it.spellName.startsWith("error") }}")
    println("- parsed name errors: ${spells.count { it.parsedSpellName.startsWith("error") }}")
    println("- components errors: ${spells.count { it.components.startsWith("error") }}")
    println("- range: ${spells.count { it.range.startsWith("error") }}")
    println("- duration errors: ${spells.count { it.duration.startsWith("error") }}")
    println("- description errors: ${spells.count { it.description.startsWith("error") }}")
    spellExtractor.saveSpells("src/main/resources", spells)
}