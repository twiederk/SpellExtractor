package com.d20charactersheet.spellextractor

class TextCleaner {

    fun clean(text: String): String {
        return text
            .replace("—", "-")
            .replace("−", "-")
            .replace(";", ",")
            .replace("’", "'")
            .replace("•", "-")
            .replace("×", "*")
            .replace("\t", " ")
    }

    fun convertHtml(description: String): String {
        return description
            .replace("\"", "'")
            .replace("\n", "")
    }

}