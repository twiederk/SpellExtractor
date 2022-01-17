package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpellParserTest {

    @Test
    fun parseSpell_acidSplash_spellData() {
        // arrange
        val spellName = "Acid Splash"
        val spellHtml =
            """<div class="bloc"><h1>Acid Splash</h1><div class="trad">
            |<div><strong>Casting Time</strong>: 1 action</div>
            |<div><strong>Range</strong>: 60 feet</div>
            |<div><strong>Components</strong>: V, S</div>
            |<div><strong>Duration</strong>: Instantaneous</div>
            |<div class="description ">You hurl a bubble of acid. Choose one creature you can see within range, or choose two creatures you can see within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.<br>This spell's damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).<br></div>""".trimMargin()
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Acid Splash")
        assertThat(spell.parsedSpellName).isEqualTo("Acid Splash")
        assertThat(spell.components).isEqualTo("V, S")
        assertThat(spell.range).isEqualTo("60 feet")
        assertThat(spell.duration).isEqualTo("Instantaneous")
        assertThat(spell.description).isEqualTo("You hurl a bubble of acid. Choose one creature you can see within range, or choose two creatures you can see within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.<br>This spell's damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).<br>")
    }

    @Test
    fun parseSpell_enlargeReduce_spellData() {
        // arrange
        val spellName = "Enlarge/Reduce"

        val spellHtml =
            """<div class="bloc"><h1>Enlarge/Reduce</h1><div class="trad">
            |<div><strong>Casting Time</strong>: 1 action</div>
            |<div><strong>Range</strong>: 30 feet</div>
            |<div><strong>Components</strong>: V, S, M (a pinch of powdered iron)</div>
            |<div><strong>Duration</strong>: Concentration, up to 1 minute</div>
            |<div class="description ">You cause a creature or an object you can see within range to grow larger or smaller for the duration. Choose either a creature or an object that is neither worn nor carried. If the target is unwilling, it can make a Constitution saving throw. On a success, the spell has no effect.<br />If the target is a creature, everything it is wearing and carrying changes size with it. Any item dropped by an affected creature returns to normal size at once.<br /><strong>Enlarge</strong>. The target's size doubles in all dimensions, and its weight is multiplied by eight. This growth increases its size by one category—from Medium to Large, for example. If there isn't enough room for the target to double its size, the creature or object attains the maximum possible size in the space available. Until the spell ends, the target also has advantage on Strength checks and Strength saving throws. The target's weapons also grow to match its new size. While these weapons are enlarged, the target's attacks with them deal 1d4 extra damage.<br /><strong>Reduce</strong>. The target's size is halved in all dimensions, and its weight is reduced to one—eighth of normal. This reduction decreases its size by one category—from Medium to Small, for example. Until the spell ends, the target also has disadvantage on Strength checks and Strength saving throws. The target's weapons also shrink to match its new size. While these weapons are reduced, the target's attacks with them deal 1d4 less damage (this can't reduce the damage below 1).<br /></div>""".trimMargin()
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Enlarge/Reduce")
        assertThat(spell.parsedSpellName).isEqualTo("Enlarge/Reduce")
        assertThat(spell.components).isEqualTo("V, S, M (a pinch of powdered iron)")
        assertThat(spell.range).isEqualTo("30 feet")
        assertThat(spell.duration).isEqualTo("Concentration, up to 1 minute")
        assertThat(spell.description).isEqualTo(
            "You cause a creature or an object you can see within range to grow larger or smaller for the duration. Choose either a creature or an object that is neither worn nor carried. If the target is unwilling, it can make a Constitution saving throw. On a success, the spell has no effect.<br />If the target is a creature, everything it is wearing and carrying changes size with it. Any item dropped by an affected creature returns to normal size at once.<br /><strong>Enlarge</strong>. The target's size doubles in all dimensions, and its weight is multiplied by eight. This growth increases its size by one category-from Medium to Large, for example. If there isn't enough room for the target to double its size, the creature or object attains the maximum possible size in the space available. Until the spell ends, the target also has advantage on Strength checks and Strength saving throws. The target's weapons also grow to match its new size. While these weapons are enlarged, the target's attacks with them deal 1d4 extra damage.<br /><strong>Reduce</strong>. The target's size is halved in all dimensions, and its weight is reduced to one-eighth of normal. This reduction decreases its size by one category-from Medium to Small, for example. Until the spell ends, the target also has disadvantage on Strength checks and Strength saving throws. The target's weapons also shrink to match its new size. While these weapons are reduced, the target's attacks with them deal 1d4 less damage (this can't reduce the damage below 1).<br />"
        )
    }

}