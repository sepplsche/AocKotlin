package _2015

import kotlin.test.Test

class Aoc2015Day11Test {

    private val letters = "abcdefghijklmnopqrstuvwxyz"

    @Test
    fun aoc1() {
        val line = "hxbxwxba"

        var next = line
        do {
            next = incString(next)
            val a = hasStraight(next)
            val b = hasNotIol(next)
            val c = hasDoubles(next)
        } while (!a || !b || !c)

        println("Result: $next")
    }

    private fun hasStraight(pw: String): Boolean {
        (0..pw.length - 3).forEach { i ->
            if (letters.indexOf(pw[i]) + 1 == letters.indexOf(pw[i + 1])
                && letters.indexOf(pw[i]) + 2 == letters.indexOf(pw[i + 2])
            )
                return true
        }
        return false
    }

    private fun hasNotIol(pw: String): Boolean {
        return !(pw.contains("i")
                || pw.contains("o")
                || pw.contains("l"))
    }

    private fun hasDoubles(pw: String): Boolean {
        var last = '0'
        val doubles = mutableListOf<String>()
        pw.toList().forEach {
            if (it == last) {
                last = '0'
                doubles.add("$last$it")
            } else {
                last = it
            }
        }
        return doubles.size > 1
    }

    private fun incString(old: String): String {
        var newString = ""
        var new = '0'
        var i = 0
        while (new == '0' || new == 'a') {
            val next = old[old.length - ++i]
            new = incLetter(next)
            newString += new
        }
        newString = old.dropLast(newString.length) + newString.reversed()
        return newString
    }

    private fun incLetter(old: Char): Char {
        var io = letters.indexOf(old) + 1
        if (io == letters.length) {
            io = 0
        }
        return letters[io]
    }

    @Test
    fun aoc2() {
        val line = "hxbxxyzz"

        var next = line
        do {
            next = incString(next)
            val a = hasStraight(next)
            val b = hasNotIol(next)
            val c = hasDoubles(next)
        } while (!a || !b || !c)

        println("Result: $next")
    }
}