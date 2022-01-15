package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate
import java.io.File

class ConnectTest {

    @Test
    fun loadHtml() {
        // arrange

        // act
        val html = File("src/test/resources/spells/Acid_Splash.html").readText(Charsets.UTF_8)

        // assert
        assertThat(html).isNotEmpty
//        println(html)
    }

    @Test
    fun parseRegEx() {
        // arrange
        // https://regexr.com/
        // https://rubular.com/

        // act
        val regex: Regex = """(\d)-(\d)-(\d)""".toRegex()
        val moreNumbers = "1-2-3"
        val (a, b, c) = regex.find(moreNumbers)?.destructured ?: error("error occurred")

        // assert
        assertThat(a).isEqualTo("1")
        assertThat(b).isEqualTo("2")
        assertThat(c).isEqualTo("3")
    }

//    column to fill manually: components, range, duration, description, matcomponent

    @Test
    fun parseComponent() {
        // arrange
        val html =
            """<div><strong>Casting Time</strong>: 1 action</div><div><strong>Range</strong>: 60 feet</div><div><strong>Components</strong>: V, S</div><div><strong>Duration</strong>: Instantaneous</div><div class="description ">You
             hurl a bubble of acid. Choose one creature you can see within range, or
             choose two creatures you can see within range that are within 5 feet of
             each other. A target must succeed on a Dexterity saving throw or take 
            1d6 acid damage.<br>This spell's damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).<br></div>""".trimIndent()
        val regex: Regex =
            """<strong>Range</strong>: ([0-9a-z ]+)</div><div><strong>Components</strong>: ([A-Z, ]+)</div>""".toRegex()

        // act
        val (range, component) = regex.find(html)?.destructured ?: error("error occurred")

        // assert
        println("range: $range, component: $component")
    }

    @Test
    fun parseHtml() {
        // arrange
        val html =
            """<div><strong>Casting Time</strong>: 1 action</div><div><strong>Range</strong>: 60 feet</div><div><strong>Components</strong>: V, S</div><div><strong>Duration</strong>: Instantaneous</div><div class="description ">You
             hurl a bubble of acid. Choose one creature you can see within range, or
             choose two creatures you can see within range that are within 5 feet of
             each other. A target must succeed on a Dexterity saving throw or take 
            1d6 acid damage.<br>This spell's damage increases by 1d6 when you reach 5th level (2d6), 11th level (3d6), and 17th level (4d6).<br></div>""".trimIndent()

        // act

        // assert
        println(html)

    }
}