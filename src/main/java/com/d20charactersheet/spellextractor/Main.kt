package com.d20charactersheet.spellextractor

fun main() {
//    SpellExtractor().downloadSpells("src/main/resources/spell_names.txt")

    val spellNames = SpellStorage().loadSpellNamesFromFile("src/main/resources/spell_names.txt")

    val spellExtractor = SpellExtractor()
    val spells = spellExtractor.parseSpells("src/main/resources/spells", spellNames)
    spellExtractor.saveSpells("src/main/resources", spells)
}