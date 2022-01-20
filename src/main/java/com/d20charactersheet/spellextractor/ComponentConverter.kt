package com.d20charactersheet.spellextractor

class ComponentConverter {

    fun convert(components: String): Any {
        var result = 0
        if (components.contains("V")) {
            result += 1
        }
        if (components.contains("S")) {
            result += 2
        }
        if (components.contains("M")) {
            result += 4
        }

        return result
    }

}
