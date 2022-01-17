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

    @Test
    fun parseSpell_melfsAcidArrow_spellData() {
        // arrange
        val spellName = "Melf''s Acid Arrow"

        val spellHtml =
            """<div class="bloc"><h1>Melf's Acid Arrow</h1><div class="trad">
            |<div><strong>Casting Time</strong>: 1 action</div>
            |<div><strong>Range</strong>: 90 feet</div>
            |<div><strong>Components</strong>: V, S, M (powdered rhubarb leaf and an adder's stomach)</div>
            |<div><strong>Duration</strong>: Instantaneous</div>
            |<div class="description ">A shimmering green arrow streaks toward a target within range and bursts in a spray of acid. Make a ranged spell attack against the target. On a hit, the target takes 4d4 acid damage immediately and 2d4 acid damage at the end of its next turn. On a miss, the arrow splashes the target with acid for half as much of the initial damage and no damage at the end of its next turn.<br /><strong><em>At Higher Levels</em></strong>. When you cast this spell using a spell slot of 3rd level or higher, the damage (both initial and later) increases by 1d4 for each slot level above 2nd.<br /></div>""".trimMargin()
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Melf''s Acid Arrow")
        assertThat(spell.parsedSpellName).isEqualTo("Melf's Acid Arrow")
        assertThat(spell.components).isEqualTo("V, S, M (powdered rhubarb leaf and an adder's stomach)")
        assertThat(spell.range).isEqualTo("90 feet")
        assertThat(spell.duration).isEqualTo("Instantaneous")
        assertThat(spell.description).isEqualTo(
            "A shimmering green arrow streaks toward a target within range and bursts in a spray of acid. Make a ranged spell attack against the target. On a hit, the target takes 4d4 acid damage immediately and 2d4 acid damage at the end of its next turn. On a miss, the arrow splashes the target with acid for half as much of the initial damage and no damage at the end of its next turn.<br /><strong><em>At Higher Levels</em></strong>. When you cast this spell using a spell slot of 3rd level or higher, the damage (both initial and later) increases by 1d4 for each slot level above 2nd.<br />"
        )
    }

    @Test
    fun parseSpell_alterSelfArrow_spellData() {
        // arrange
        val spellName = "Alter Self"

        val spellHtml =
            """<div class="bloc"><h1>Alter Self</h1><div class="trad">
            |<div><strong>Casting Time</strong>: 1 action</div>
            |<div><strong>Range</strong>: Self</div>
            |<div><strong>Components</strong>: V, S</div>
            |<div><strong>Duration</strong>: Concentration, up to 1 hour</div>
            |<div class="description ">You assume a different form. When you cast the spell, choose one of the following options, the effects of which last for the duration of the spell. While the spell lasts, you can end one option as an action to gain the benefits of a different one.<br /><strong><em>Aquatic Adaptation</em></strong>. You adapt your body to an aquatic environment, sprouting gills and growing webbing between your fingers. You can breathe underwater and gain a swimming speed equal to your walking speed.<br /><strong><em>Change Appearance</em></strong>. You transform your appearance. You decide what you look like, including your height, weight, facial features, sound of your voice, hair length, coloration, and distinguishing characteristics, if any. You can make yourself appear as a member of another race, though none of your statistics change. You also can't appear as a creature of a different size than you, and your basic shape stays the same; if you're bipedal, you can't use this spell to become quadrupedal, for instance. At any time for the duration of the spell, you can use your action to change your appearance in this way again.<br /><strong><em>Natural Weapons</em></strong>. You grow claws, fangs, spines, horns, or a different natural weapon of your choice. Your unarmed strikes deal 1d6 bludgeoning, piercing, or slashing damage, as appropriate to the natural weapon you chose, and you are proficient with your unarmed strikes. Finally, the natural weapon is magic and you have a +1 bonus to the attack and damage rolls you make using it.<br /></div>""".trimMargin()
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Alter Self")
        assertThat(spell.parsedSpellName).isEqualTo("Alter Self")
        assertThat(spell.components).isEqualTo("V, S")
        assertThat(spell.range).isEqualTo("Self")
        assertThat(spell.duration).isEqualTo("Concentration, up to 1 hour")
        assertThat(spell.description).isEqualTo(
            "You assume a different form. When you cast the spell, choose one of the following options, the effects of which last for the duration of the spell. While the spell lasts, you can end one option as an action to gain the benefits of a different one.<br /><strong><em>Aquatic Adaptation</em></strong>. You adapt your body to an aquatic environment, sprouting gills and growing webbing between your fingers. You can breathe underwater and gain a swimming speed equal to your walking speed.<br /><strong><em>Change Appearance</em></strong>. You transform your appearance. You decide what you look like, including your height, weight, facial features, sound of your voice, hair length, coloration, and distinguishing characteristics, if any. You can make yourself appear as a member of another race, though none of your statistics change. You also can't appear as a creature of a different size than you, and your basic shape stays the same, if you're bipedal, you can't use this spell to become quadrupedal, for instance. At any time for the duration of the spell, you can use your action to change your appearance in this way again.<br /><strong><em>Natural Weapons</em></strong>. You grow claws, fangs, spines, horns, or a different natural weapon of your choice. Your unarmed strikes deal 1d6 bludgeoning, piercing, or slashing damage, as appropriate to the natural weapon you chose, and you are proficient with your unarmed strikes. Finally, the natural weapon is magic and you have a +1 bonus to the attack and damage rolls you make using it.<br />"
        )
    }

}