package com.d20charactersheet.spellextractor

fun main() {
    val spellNames = listOf("Acid Splash", "Aid")
    SpellDownloader().downloadSpells(spellNames)
}