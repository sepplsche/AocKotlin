package _2015

import AocUtils
import kotlin.test.Test

class Aoc2015Day12Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)
        val line = lines[0]

        val ints = '0'..'9'

        val nums = mutableListOf<Int>()
        var n = ""
        line.toList().forEach {
            if (it == '-') {
                n = "$it"
            } else if (ints.contains(it)) {
                n += "$it"
            } else if (n.isNotBlank()) {
                nums.add(n.toInt())
                n = ""
            }
        }
        val result = nums.sum()

        println("Result: $result")
    }

    @Test
    fun aoc2() {
        val lines = AocUtils.input(this::class.java)
        val line = lines[0]

        val ints = '0'..'9'

        val nums = mutableListOf<Int>()
        var n = ""
        var obacht = false
        line.toList().forEach {
            if (it == '{') {
                obacht = true
            }
            if (it == '[') {
                obacht = false
            }


            if (it == '-') {
                n = "$it"
            } else if (ints.contains(it)) {
                n += "$it"
            } else if (n.isNotBlank()) {
                nums.add(n.toInt())
                n = ""
            }
        }
        val result = nums.sum()

        println("Result: $result")
    }
}