package com.d20charactersheet.spellextractor

data class Spell(
    val spellName: String,
    val parsedSpellName: String,
    val components: String,
    val componentsInt: Int,
    val matcomponents: String,
    val range: String,
    val duration: String,
    val description: String
)
