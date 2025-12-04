package _2015

import AocUtils
import kotlin.test.Test

class Aoc2015Day10Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)
        var line = lines[0]

        (1..40).forEach { line = nLine(line) }

        println("Result: ${line.length}")
    }

    private fun nLine(line: String): String {
        var l = ""
        var c = 0
        var nLine = ""
        line.toList().forEach {
            if (l != "" && l != "$it") {
                nLine = "$nLine$c$l"
                c = 0
            }
            c++
            l = "$it"
        }
        return "$nLine$c$l"
    }

    @Test
    fun aoc2() {
        val lines = AocUtils.input(this::class.java)
        var line = lines[0]

        (1..50).forEach { line = nLine(line) }

        println("Result: ${line.length}")
    }
}