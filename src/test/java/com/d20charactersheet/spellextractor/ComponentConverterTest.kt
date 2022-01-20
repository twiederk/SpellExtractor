package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ComponentConverterTest {

    @Test
    fun convert_verbal_is2up0() {

        // act
        val result = ComponentConverter().convert("V ")

        // assert
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun convert_somatic_is2up1() {

        // act
        val result = ComponentConverter().convert("S ")

        // assert
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun convert_material_is2up2() {

        // act
        val result = ComponentConverter().convert("M ")

        // assert
        assertThat(result).isEqualTo(4)
    }

    @Test
    fun convert_verbalAndSomatic_is3() {

        // act
        val result = ComponentConverter().convert("V, S ")

        // assert
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun convert_verbalAndSomaticAndMaterial_is7() {

        // act
        val result = ComponentConverter().convert("V, S, M ")

        // assert
        assertThat(result).isEqualTo(7)
    }

}