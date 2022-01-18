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

    @Test
    fun parseSpell_animalMessenger_spellData() {
        // arrange
        val spellName = "Animal Messenger"

        val spellHtml =
            """<div class="bloc"><h1>Animal Messenger</h1><div class="trad">
            |<div><strong>Range</strong>: 30 feet</div><div>
            |<div><strong>Components</strong>: V, S, M (a morsel of food)</div>
            |<div><strong>Duration</strong>: 24 hours</div>
            |<div class="description ">By means of this spell, you use an animal to deliver a message. Choose a Tiny beast you can see within range, such as a squirrel, a blue jay, or a bat. You specify a location, which you must have visited, and a recipient who matches a general description, such as "a man or woman dressed in the uniform of the town guard" or "a red-haired dwarf wearing a pointed hat." You also speak a message of up to twenty-five words. The target beast travels for the duration of the spell toward the specified location, covering about 50 miles per 24 hours for a flying messenger, or 25 miles for other animals.<br />When the messenger arrives, it delivers your message to the creature that you described, replicating the sound of your voice. The messenger speaks only to a creature matching the description you gave. If the messenger doesn't reach its destination before the spell ends, the message is lost, and the beast makes its way back to where you cast this spell.<br /><strong><em>At Higher Levels</em></strong>. If you cast this spell using a spell slot of 3nd level or higher, the duration of the spell increases by 48 hours for each slot level above 2nd.<br /></div>""".trimMargin()
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Animal Messenger")
        assertThat(spell.parsedSpellName).isEqualTo("Animal Messenger")
        assertThat(spell.components).isEqualTo("V, S, M (a morsel of food)")
        assertThat(spell.range).isEqualTo("30 feet")
        assertThat(spell.duration).isEqualTo("24 hours")
        assertThat(spell.description).isEqualTo(
            "By means of this spell, you use an animal to deliver a message. Choose a Tiny beast you can see within range, such as a squirrel, a blue jay, or a bat. You specify a location, which you must have visited, and a recipient who matches a general description, such as 'a man or woman dressed in the uniform of the town guard' or 'a red-haired dwarf wearing a pointed hat.' You also speak a message of up to twenty-five words. The target beast travels for the duration of the spell toward the specified location, covering about 50 miles per 24 hours for a flying messenger, or 25 miles for other animals.<br />When the messenger arrives, it delivers your message to the creature that you described, replicating the sound of your voice. The messenger speaks only to a creature matching the description you gave. If the messenger doesn't reach its destination before the spell ends, the message is lost, and the beast makes its way back to where you cast this spell.<br /><strong><em>At Higher Levels</em></strong>. If you cast this spell using a spell slot of 3nd level or higher, the duration of the spell increases by 48 hours for each slot level above 2nd.<br />"
        )
    }

    @Test
    fun parseSpell_antiLifeShell_spellData() {
        // arrange
        val spellName = "Antilife Shell"

        val spellHtml =
            """<div class="bloc"><h1>Antilife Shell</h1><div class="trad">
            |<div><strong>Range</strong>: Self (10-foot radius)</div>
            |<div><strong>Components</strong>: V, S</div>
            |<div><strong>Duration</strong>: Concentration, up to 1 hour</div>
            |<div class="description ">A shimmering barrier extends out from you in a 10-foot radius and moves with you, remaining centered on you and hedging out creatures other than undead and constructs. The barrier lasts for the duration.<br />The barrier prevents an affected creature from passing or reaching through. An affected creature can cast spells or make attacks with ranged or reach weapons through the barrier.<br />If you move so that an affected creature is forced to pass through the barrier, the spell ends.<br /></div>""".trimMargin()
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Antilife Shell")
        assertThat(spell.parsedSpellName).isEqualTo("Antilife Shell")
        assertThat(spell.components).isEqualTo("V, S")
        assertThat(spell.range).isEqualTo("Self (10-foot radius)")
        assertThat(spell.duration).isEqualTo("Concentration, up to 1 hour")
        assertThat(spell.description).isEqualTo(
            "A shimmering barrier extends out from you in a 10-foot radius and moves with you, remaining centered on you and hedging out creatures other than undead and constructs. The barrier lasts for the duration.<br />The barrier prevents an affected creature from passing or reaching through. An affected creature can cast spells or make attacks with ranged or reach weapons through the barrier.<br />If you move so that an affected creature is forced to pass through the barrier, the spell ends.<br />"
        )
    }

    @Test
    fun parseSpell_arcaneLock_spellData() {
        // arrange
        val spellName = "Arcane Lock"

        val spellHtml =
            """<div class="bloc"><h1>Arcane Lock</h1><div class="trad">
            |<div><strong>Range</strong>: Touch</div>
            |<div><strong>Components</strong>: V, S, M (gold dust worth at least 25 gp, which the spell consumes)</div>
            |<div><strong>Duration</strong>: Until dispelled</div>
            |<div class="description ">You touch a closed door, window, gate, chest, or other entryway, and it becomes locked for the duration. You and the creatures you designate when you cast this spell can open the object normally. You can also set a password that, when spoken within 5 feet of the object, suppresses this spell for 1 minute. Otherwise, it is impassable until it is broken or the spell is dispelled or suppressed. Casting <em><a href="https://www.aidedd.org/dnd/sorts.php?vo=knock">knock</a></em> on the object suppresses <em><a href="https://www.aidedd.org/dnd/sorts.php?vo=arcane-lock">arcane lock</a></em> for 10 minutes.<br />While affected by this spell, the object is more difficult to break or force open; the DC to break it or pick any locks on it increases by 10.<br /></div>"""
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Arcane Lock")
        assertThat(spell.parsedSpellName).isEqualTo("Arcane Lock")
        assertThat(spell.components).isEqualTo("V, S, M (gold dust worth at least 25 gp, which the spell consumes)")
        assertThat(spell.range).isEqualTo("Touch")
        assertThat(spell.duration).isEqualTo("Until dispelled")
        assertThat(spell.description).isEqualTo(
            "You touch a closed door, window, gate, chest, or other entryway, and it becomes locked for the duration. You and the creatures you designate when you cast this spell can open the object normally. You can also set a password that, when spoken within 5 feet of the object, suppresses this spell for 1 minute. Otherwise, it is impassable until it is broken or the spell is dispelled or suppressed. Casting <em><a href='https://www.aidedd.org/dnd/sorts.php?vo=knock'>knock</a></em> on the object suppresses <em><a href='https://www.aidedd.org/dnd/sorts.php?vo=arcane-lock'>arcane lock</a></em> for 10 minutes.<br />While affected by this spell, the object is more difficult to break or force open, the DC to break it or pick any locks on it increases by 10.<br />"
        )
    }

    @Test
    fun parseSpell_clone_spellData() {
        // arrange
        val spellName = "Clone"

        val spellHtml =
            """<div class="bloc"><h1>Clone</h1><div class="trad">
            |<div><strong>Range</strong>: Touch</div>
            |<div><strong>Components</strong>: V, S, M (a diamond worth at least 1,000 gp and at least 1 cubic inch of flesh of the creature that is to be cloned, which the spell consumes, and a vessel worth at least 2,000 gp that has a sealable lid and is large enough to hold the creature being cloned, such as a huge urn, coffin, mud-filled cyst in the ground, or crystal container filled with salt water)</div>
            |<div><strong>Duration</strong>: Instantaneous</div>
            |<div class="description ">This spell grows an inert duplicate of a living creature as a safeguard against death. This clone forms inside the vessel used in the spell’s casting and grows to full size and maturity after 120 days; you can also choose to have the clone be a younger version of the same creature. It remains inert and endures indefinitely, as long as its vessel remains undisturbed.<br />At any time after the clone matures, if the original creature dies, its soul transfers to the clone, provided that the soul is free and willing to return.<br />The clone is physically identical to the original and has the same personality, memories, and abilities, but none of the original's equipment. The original creature's physical remains, if they still exist, become inert and can't thereafter be restored to life, since the creature's soul is elsewhere.<br /></div>"""
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Clone")
        assertThat(spell.parsedSpellName).isEqualTo("Clone")
        assertThat(spell.components).isEqualTo("V, S, M (a diamond worth at least 1,000 gp and at least 1 cubic inch of flesh of the creature that is to be cloned, which the spell consumes, and a vessel worth at least 2,000 gp that has a sealable lid and is large enough to hold the creature being cloned, such as a huge urn, coffin, mud-filled cyst in the ground, or crystal container filled with salt water)")
        assertThat(spell.range).isEqualTo("Touch")
        assertThat(spell.duration).isEqualTo("Instantaneous")
        assertThat(spell.description).isEqualTo(
            "This spell grows an inert duplicate of a living creature as a safeguard against death. This clone forms inside the vessel used in the spell's casting and grows to full size and maturity after 120 days, you can also choose to have the clone be a younger version of the same creature. It remains inert and endures indefinitely, as long as its vessel remains undisturbed.<br />At any time after the clone matures, if the original creature dies, its soul transfers to the clone, provided that the soul is free and willing to return.<br />The clone is physically identical to the original and has the same personality, memories, and abilities, but none of the original's equipment. The original creature's physical remains, if they still exist, become inert and can't thereafter be restored to life, since the creature's soul is elsewhere.<br />"
        )
    }

    @Test
    fun parseSpell_arcaneGate_spellData() {
        // arrange
        val spellName = "Arcane Gate"

        val spellHtml =
            """<div class="bloc"><h1>Arcane Gate</h1><div class="trad">
            |<div><strong>Range</strong>: 500 feet</div>
            |<div><strong>Components</strong>: V, S</div>
            |<div><strong>Duration</strong>: Concentration, up to 10 minutes</div>
            |<div class="description">Create 2 portals (max 500 ft between them) and allow teleport from one to the other.</div>"""
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Arcane Gate")
        assertThat(spell.parsedSpellName).isEqualTo("Arcane Gate")
        assertThat(spell.components).isEqualTo("V, S")
        assertThat(spell.range).isEqualTo("500 feet")
        assertThat(spell.duration).isEqualTo("Concentration, up to 10 minutes")
        assertThat(spell.description).isEqualTo(
            "Create 2 portals (max 500 ft between them) and allow teleport from one to the other."
        )
    }

    @Test
    fun parseSpell_augury_spellData() {
        // arrange
        val spellName = "Augury"

        val spellHtml =
            """<div class="bloc"><h1>Augury</h1><div class="trad">
            |<div><strong>Range</strong>: Self</div>
            |<div><strong>Components</strong>: V, S, M (specially marked sticks, bones, or similar tokens worth at least 25 gp)</div>
            |<div><strong>Duration</strong>: Instantaneous</div>
            |<div class="description ">By casting gem-inlaid sticks, rolling dragon bones, laying out ornate cards, or employing some other divining tool, you receive an omen from an otherworldly entity about the results of a specific course of action that you plan to take within the next 30 minutes. The DM chooses from the following possible omens:<br />• Weal, for good results<br />• Woe, for bad results<br />• Weal and woe, for both good and bad results<br />• Nothing, for results that aren't especially good or bad<br />The spell doesn't take into account any possible circumstances that might change the outcome, such as the casting of additional spells or the loss or gain of a companion.<br />If you cast the spell two or more times before completing your next long rest, there is a cumulative 25 percent chance for each casting after the first that you get a random reading. The DM makes this roll in secret.<br /></div>"""
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Augury")
        assertThat(spell.parsedSpellName).isEqualTo("Augury")
        assertThat(spell.components).isEqualTo("V, S, M (specially marked sticks, bones, or similar tokens worth at least 25 gp)")
        assertThat(spell.range).isEqualTo("Self")
        assertThat(spell.duration).isEqualTo("Instantaneous")
        assertThat(spell.description).isEqualTo(
            "By casting gem-inlaid sticks, rolling dragon bones, laying out ornate cards, or employing some other divining tool, you receive an omen from an otherworldly entity about the results of a specific course of action that you plan to take within the next 30 minutes. The DM chooses from the following possible omens:<br />- Weal, for good results<br />- Woe, for bad results<br />- Weal and woe, for both good and bad results<br />- Nothing, for results that aren't especially good or bad<br />The spell doesn't take into account any possible circumstances that might change the outcome, such as the casting of additional spells or the loss or gain of a companion.<br />If you cast the spell two or more times before completing your next long rest, there is a cumulative 25 percent chance for each casting after the first that you get a random reading. The DM makes this roll in secret.<br />"
        )
    }

}