package _2025

import AocUtils
import kotlin.test.Test

class Aoc2025Day01Test {

    @Test
    fun aoc11() {
        val lines = AocUtils.input(this::class.java)

        var start = 50
        val counter = 100
        var result = 0
        lines.forEach {
            val left = it.startsWith("L")
            val diff = it.substring(1).toInt()

            var next = next(start, diff, left, counter)

            if (left) {
                if (next < 0) ++result
                while (next < 0) next += counter
            } else {
                if (next > 99) ++result
                while (next >= 99) next -= counter
            }

            if (next == 0) ++result
            start = next
        }

        println("Result: $result")
    }

    fun next(start: Int, diff: Int, left: Boolean, counter: Int): Int = if (left) {
        start - diff
    } else {
        start + diff
    }
}