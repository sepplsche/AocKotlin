package _2025

import AocUtils
import kotlin.test.Test

class Aoc2025Day05Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)

        val ranges = lines
            .filter { it.contains("-") }
            .map { it.split("-") }
            .map { (it[0].toLong()..it[1].toLong()) }

        val ids = lines
            .filter { !it.contains("-") }
            .filter { !it.isEmpty() }
            .map { it.toLong() }

        val result = ids
            .filter { ranges.any { range -> range.contains(it) } }
            .size

        println("Result: $result")
    }

    @Test
    fun aoc2() {
        AocUtils.input(this::class.java)
        val result = 0
        println("Result: $result")
    }
}
