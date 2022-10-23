package com.bam.testproject

class EmailValidator(var text: String) {

    var error: String = ""

    fun check(): Boolean {

        if (!checkContainChar('@')){
            error = "not contain @"
            return false
        }
        if (!checkLength()){
            error = "length < 20"
            return false
        }
        return true
    }

    private fun checkLength(): Boolean {
        return text.length < 20
    }

    private fun checkContainChar(c: Char): Boolean {
        return text.contains(c)
    }


}