package _2025

import AocUtils
import kotlin.test.Test

class Aoc2025Day06Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)

        val ls = lines.map { line ->
            line.split(" ")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
        }

        val result = (0..<ls[0].size).sumOf { c ->
            val op = ls[ls.size - 1][c]
            val longs = (0..<ls.size - 1).map { l ->
                ls[l][c].toLong()
            }
            if (op == "+") longs.sum()
            else longs.reduce { a, b -> a * b }
        }

        println("Result: $result")
    }

    @Test
    fun aoc2() {
        val lines = AocUtils.input(this::class.java)

        val ops = lines[lines.size - 1].split(" ").map { it.trim() }.filter { it.isNotEmpty() }
        val nums = (0..<lines.maxOf { it.length }).map { c ->
            var num = ""
            (0..<lines.size - 1).forEach { l ->
                if (c < lines[l].length) {
                    num += lines[l][c]
                }
            }
            num
        }.map { it.trim() }

        var j = 0
        var result = 0L
        var zResult = 0L
        nums.forEach { num ->
            if (zResult == 0L) {
                zResult = num.toLong()
            } else if (num.isEmpty()) {
                j++
                result += zResult
                zResult = 0L
            } else if (ops[j] == "+") {
                zResult += num.toLong()
            } else {
                zResult *= num.toLong()
            }
        }
        result += zResult
        println("Result: $result")
    }
}
