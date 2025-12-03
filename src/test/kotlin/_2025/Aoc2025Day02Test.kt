package _2025

import AocUtils
import kotlin.test.Test

class Aoc2025Day02Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)

        val result = lines[0].split(",")
            .flatMap { range ->
                val start = range.split("-")[0].toLong()
                val end = range.split("-")[1].toLong()

                (start..end)
                    .map { it.toString() }
                    .filter { it.length % 2 == 0 }
                    .filter {
                        val first = it.substring(0..<it.length / 2)
                        val second = it.substring(it.length / 2..<it.length)
                        first == second
                    }
                    .map { it.toLong() }
            }.reduce { a, b -> a + b }

        println("Result: $result")
    }

    @Test
    fun aoc2() {
        val lines = AocUtils.input(this::class.java)

        val result = lines[0].split(",")
            .flatMap { range ->
                val start = range.split("-")[0].toLong()
                val end = range.split("-")[1].toLong()

                (start..end)
                    .map { it.toString() }
                    .filter { num ->
                        (2..num.length).any { check(num, it) }
                    }
                    .map { it.toLong() }
            }
        .reduce { a, b -> a + b }

        println("Result: $result")
    }

    private fun check(can: String, prime: Int): Boolean = if (can.length % prime == 0) {
        (0..<prime)
            .map { can.substring(can.length / prime * it..<can.length / prime * (it + 1)) }
            .toSet().size == 1
    } else {
        false
    }
}