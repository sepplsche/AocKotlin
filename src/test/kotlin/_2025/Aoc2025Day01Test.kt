package _2025

import AocUtils
import kotlin.math.abs
import kotlin.test.Test

class Aoc2025Day01Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)

        var start = 50
        val counter = 100
        var result = 0
        lines.forEach {
            val left = it.startsWith("L")
            val diff = it.substring(1).toInt()

            var next = if (left) {
                start - diff
            } else {
                start + diff
            }

            if (left) {
                while (next < 0) next += counter
            } else {
                while (next >= 99) next -= counter
            }

            if (next == 0) ++result
            start = next
        }

        println("Result: $result")
    }

    @Test
    fun aoc2() {
        val lines = AocUtils.input(this::class.java)

        var start = 50
        val counter = 100
        var result = 0
        lines.forEach {
            val left = it.startsWith("L")
            val diff = it.substring(1).toInt()

            var next = if (left) {
                start - diff
            } else {
                start + diff
            }

            // print("$start -> $next, ")

            val counts = next / 100
            if (counts > 1) {
                result += counts - 1
                // println("count $counts ")
            } else if (counts < 0) {
                result += abs(counts)
                // println("count $counts ")
            }

            if ((start > 0 && next < 0)
                || (start < 0 && next > 0)
                || (start > 100 && next < 100)
                || (start < 100 && next > 100)
                || next == 0
                || next == 100
            ) {
                ++result
                // println("count")
            }

            if (left) {
                while (next < 0) {
                    next += counter
                }
            } else {
                while (next >= 99) {
                    next -= counter
                }
            }

            start = next
        }

        println("Result: $result")
    }
}