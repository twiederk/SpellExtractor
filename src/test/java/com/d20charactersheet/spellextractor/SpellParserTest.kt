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

    @Test
    fun parseSpell_controlWeather_spellData() {
        // arrange
        val spellName = "Control Weather"

        val spellHtml =
            """<div class="bloc"><h1>Control Weather</h1><div class="trad">
            |<div><strong>Range</strong>: Self (5-mile radius)</div>
            |<div><strong>Components</strong>: V, S, M (burning incense and bits of earth and wood mixed in water)</div>
            |<div><strong>Duration</strong>: Concentration, up to 8 hours</div>
            |<div class="description ">You take control of the weather within 5 miles of you for the duration. You must be outdoors to cast this spell. Moving to a place where you don't have a clear path to the sky ends the spell early.<br />When you cast the spell, you change the current weather conditions, which are determined by the DM based on the climate and season. You can change precipitation, temperature, and wind. It takes 1d4 × 10 minutes for the new conditions to take effect. Once they do so, you can change the conditions again. When the spell ends, the weather gradually returns to normal. When you change the weather conditions, find a current condition on the following tables and change its stage by one, up or down. When changing the wind, you can change its direction.<br /><br /><strong>Precipitation</strong><br /><table><tr><th class="center">Stage</th><th>Condition</th></tr><tr><td class="center">1</td><td>Clear</td></tr><tr><td class="center">2</td><td>Light clouds</td></tr><tr><td class="center">3</td><td>Overcast or ground fog</td></tr><tr><td class="center">4</td><td>Rain, hail, or snow</td></tr><tr><td class="center">5</td><td>Torrential rain, driving hail, or blizzard</td></tr></table><br /><strong>Temperature</strong><br /><table><tr><th class="center">Stage</th><th>Condition</th></tr><tr><td class="center">1</td><td>Unbearable heat</td></tr><tr><td class="center">2</td><td>Hot</td></tr><tr><td class="center">3</td><td>Warm</td></tr><tr><td class="center">4</td><td>Cool</td></tr><tr><td class="center">5</td><td>Cold</td></tr><tr><td class="center">6</td><td>Arctic cold</td></tr></table><br /><strong>Wind</strong><br /><table><tr><th class="center">Stage</th><th>Condition</th></tr><tr><td class="center">1</td><td>Calm</td></tr><tr><td class="center">2</td><td>Moderate wind</td></tr><tr><td class="center">3</td><td>Strong wind</td></tr><tr><td class="center">4</td><td>Gale</td></tr><tr><td class="center">5</td><td>Storm</td></tr></table><br /></div>"""
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Control Weather")
        assertThat(spell.parsedSpellName).isEqualTo("Control Weather")
        assertThat(spell.components).isEqualTo("V, S, M (burning incense and bits of earth and wood mixed in water)")
        assertThat(spell.range).isEqualTo("Self (5-mile radius)")
        assertThat(spell.duration).isEqualTo("Concentration, up to 8 hours")
        assertThat(spell.description).isEqualTo(
            "You take control of the weather within 5 miles of you for the duration. You must be outdoors to cast this spell. Moving to a place where you don't have a clear path to the sky ends the spell early.<br />When you cast the spell, you change the current weather conditions, which are determined by the DM based on the climate and season. You can change precipitation, temperature, and wind. It takes 1d4 * 10 minutes for the new conditions to take effect. Once they do so, you can change the conditions again. When the spell ends, the weather gradually returns to normal. When you change the weather conditions, find a current condition on the following tables and change its stage by one, up or down. When changing the wind, you can change its direction.<br /><br /><strong>Precipitation</strong><br /><table><tr><th class='center'>Stage</th><th>Condition</th></tr><tr><td class='center'>1</td><td>Clear</td></tr><tr><td class='center'>2</td><td>Light clouds</td></tr><tr><td class='center'>3</td><td>Overcast or ground fog</td></tr><tr><td class='center'>4</td><td>Rain, hail, or snow</td></tr><tr><td class='center'>5</td><td>Torrential rain, driving hail, or blizzard</td></tr></table><br /><strong>Temperature</strong><br /><table><tr><th class='center'>Stage</th><th>Condition</th></tr><tr><td class='center'>1</td><td>Unbearable heat</td></tr><tr><td class='center'>2</td><td>Hot</td></tr><tr><td class='center'>3</td><td>Warm</td></tr><tr><td class='center'>4</td><td>Cool</td></tr><tr><td class='center'>5</td><td>Cold</td></tr><tr><td class='center'>6</td><td>Arctic cold</td></tr></table><br /><strong>Wind</strong><br /><table><tr><th class='center'>Stage</th><th>Condition</th></tr><tr><td class='center'>1</td><td>Calm</td></tr><tr><td class='center'>2</td><td>Moderate wind</td></tr><tr><td class='center'>3</td><td>Strong wind</td></tr><tr><td class='center'>4</td><td>Gale</td></tr><tr><td class='center'>5</td><td>Storm</td></tr></table><br />"
        )
    }

    @Test
    fun parseSpell_reincarnate_spellData() {
        // arrange
        val spellName = "Reincarnate"

        val spellHtml =
            """<div class="bloc"><h1>Reincarnate</h1><div class="trad">
            |<div><strong>Range</strong>: Touch</div>
            |<div><strong>Components</strong>: V, S, M (rare oils and unguents worth at least 1,000 gp, which the spell consumes)</div>
            |<div><strong>Duration</strong>: Instantaneous</div>
            |<div class="description ">You touch a dead humanoid or a piece of a dead humanoid. Provided that the creature has been dead no longer than 10 days, the spell forms a new adult body for it and then calls the soul to enter that body.<br />If the target's soul isn't free or willing to do so, the spell fails.<br />The magic fashions a new body for the creature to inhabit, which likely causes the creature's race to change. The DM rolls a d100 and consults the following table to determine what form the creature takes when restored to life, or the DM chooses a form.	<br /><table><tr><th class="center">d100</th><th>Race</th></tr><tr><td class="center">01-04</td><td>Dragonborn</td></tr><tr><td class="center">05-13</td><td>Dwarf, hill</td></tr><tr><td class="center">14-21</td><td>Dwarf, mountain</td></tr><tr><td class="center">22-25</td><td>Elf, dark</td></tr><tr><td class="center">26-34</td><td>Elf, high</td></tr><tr><td class="center">35-42</td><td>Elf, wood</td></tr><tr><td class="center">43-46</td><td>Gnome, forest</td></tr><tr><td class="center">47-52</td><td>Gnome, rock</td></tr><tr><td class="center">53-56</td><td>Half-elf</td></tr><tr><td class="center">57-60</td><td>Half-orc</td></tr><tr><td class="center">61-68</td><td>Halfling, lightfoot</td></tr><tr><td class="center">69-76</td><td>Halfling, stout</td></tr><tr><td class="center">77-96</td><td>Human</td></tr><tr><td class="center">97-00</td><td>Tiefling</td></tr></table><br />The reincarnated creature recalls its former life and experiences. It retains the capabilities it had in its original form, except it exchanges its original race for the new one and changes its racial traits accordingly.<br /></div>"""
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Reincarnate")
        assertThat(spell.parsedSpellName).isEqualTo("Reincarnate")
        assertThat(spell.components).isEqualTo("V, S, M (rare oils and unguents worth at least 1,000 gp, which the spell consumes)")
        assertThat(spell.range).isEqualTo("Touch")
        assertThat(spell.duration).isEqualTo("Instantaneous")
        assertThat(spell.description).isEqualTo(
            "You touch a dead humanoid or a piece of a dead humanoid. Provided that the creature has been dead no longer than 10 days, the spell forms a new adult body for it and then calls the soul to enter that body.<br />If the target's soul isn't free or willing to do so, the spell fails.<br />The magic fashions a new body for the creature to inhabit, which likely causes the creature's race to change. The DM rolls a d100 and consults the following table to determine what form the creature takes when restored to life, or the DM chooses a form. <br /><table><tr><th class='center'>d100</th><th>Race</th></tr><tr><td class='center'>01-04</td><td>Dragonborn</td></tr><tr><td class='center'>05-13</td><td>Dwarf, hill</td></tr><tr><td class='center'>14-21</td><td>Dwarf, mountain</td></tr><tr><td class='center'>22-25</td><td>Elf, dark</td></tr><tr><td class='center'>26-34</td><td>Elf, high</td></tr><tr><td class='center'>35-42</td><td>Elf, wood</td></tr><tr><td class='center'>43-46</td><td>Gnome, forest</td></tr><tr><td class='center'>47-52</td><td>Gnome, rock</td></tr><tr><td class='center'>53-56</td><td>Half-elf</td></tr><tr><td class='center'>57-60</td><td>Half-orc</td></tr><tr><td class='center'>61-68</td><td>Halfling, lightfoot</td></tr><tr><td class='center'>69-76</td><td>Halfling, stout</td></tr><tr><td class='center'>77-96</td><td>Human</td></tr><tr><td class='center'>97-00</td><td>Tiefling</td></tr></table><br />The reincarnated creature recalls its former life and experiences. It retains the capabilities it had in its original form, except it exchanges its original race for the new one and changes its racial traits accordingly.<br />"
        )
    }

    @Test
    fun parseSpell_scrying_spellData() {
        // arrange
        val spellName = "Scrying"

        val spellHtml =
            """<div class="bloc"><h1>Scrying</h1><div class="trad">
            |<div><strong>Range</strong>: Self</div>
            |<div><strong>Components</strong>: V, S, M (a focus worth at least 1,000 gp, such as a crystal ball, a silver mirror, or a font filled with holy water)</div>
            |<div><strong>Duration</strong>: Concentration, up to 10 minutes</div>
            |<div class="description ">You can see and hear a particular creature you choose that is on the same plane of existence as you. The target must make a Wisdom saving throw, which is modified by how well you know the target and the sort of physical connection you have to it. If a target knows you're casting this spell, it can fail the saving throw voluntarily if it wants to be observed.<br /><table><tr><th>Knowledge</th><th class="center">Save Modifier</th></tr><tr><td>Secondhand (you have heard of the target)</td><td class="center">+5</td></tr><tr><td>Firsthand (you have met the target)</td><td class="center">+0</td></tr><tr><td>Familiar (you know the target well)</td><td class="center">−5</td></tr></table><br /><table><tr><th>Connection</th><th class="center">Save Modifier</th></tr><tr><td>Likeness or picture</td><td class="center">−2</td></tr><tr><td>Possession or garment</td><td class="center">−4</td></tr><tr><td>Body part, lock of hair, bit of nail, or the like</td><td class="center">−10</td></tr></table><br />On a successful save, the target isn't affected, and you can't use this spell against it again for 24 hours. On a failed save, the spell creates an invisible sensor within 10 feet of the target. You can see and hear through the sensor as if you were there. The sensor moves with the target, remaining within 10 feet of it for the duration. A creature that can see invisible objects sees the sensor as a luminous orb about the size of your fist. Instead of targeting a creature, you can choose a location you have seen before as the target of this spell. When you do, the sensor appears at that location and doesn't move.<br /></div>"""
                .trimIndent()


        // act
        val spell = SpellParser().parseSpell(spellName, spellHtml)

        // assert
        assertThat(spell.spellName).isEqualTo("Scrying")
        assertThat(spell.parsedSpellName).isEqualTo("Scrying")
        assertThat(spell.components).isEqualTo("V, S, M (a focus worth at least 1,000 gp, such as a crystal ball, a silver mirror, or a font filled with holy water)")
        assertThat(spell.range).isEqualTo("Self")
        assertThat(spell.duration).isEqualTo("Concentration, up to 10 minutes")
        assertThat(spell.description).isEqualTo(
            "You can see and hear a particular creature you choose that is on the same plane of existence as you. The target must make a Wisdom saving throw, which is modified by how well you know the target and the sort of physical connection you have to it. If a target knows you're casting this spell, it can fail the saving throw voluntarily if it wants to be observed.<br /><table><tr><th>Knowledge</th><th class='center'>Save Modifier</th></tr><tr><td>Secondhand (you have heard of the target)</td><td class='center'>+5</td></tr><tr><td>Firsthand (you have met the target)</td><td class='center'>+0</td></tr><tr><td>Familiar (you know the target well)</td><td class='center'>-5</td></tr></table><br /><table><tr><th>Connection</th><th class='center'>Save Modifier</th></tr><tr><td>Likeness or picture</td><td class='center'>-2</td></tr><tr><td>Possession or garment</td><td class='center'>-4</td></tr><tr><td>Body part, lock of hair, bit of nail, or the like</td><td class='center'>-10</td></tr></table><br />On a successful save, the target isn't affected, and you can't use this spell against it again for 24 hours. On a failed save, the spell creates an invisible sensor within 10 feet of the target. You can see and hear through the sensor as if you were there. The sensor moves with the target, remaining within 10 feet of it for the duration. A creature that can see invisible objects sees the sensor as a luminous orb about the size of your fist. Instead of targeting a creature, you can choose a location you have seen before as the target of this spell. When you do, the sensor appears at that location and doesn't move.<br />"
        )
    }

}