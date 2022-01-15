package com.d20charactersheet.spellextractor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpellDownloaderIT {

    @Test
    fun downloadSpell_validUrl_downloadSpell() {

        // act
        val spellHtml = SpellDownloader().downloadSpell("Acid Splash")

        // assert
        assertThat(spellHtml).contains("Acid Splash")
    }

}