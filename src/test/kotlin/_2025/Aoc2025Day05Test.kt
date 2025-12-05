package _2025

import AocUtils
import kotlin.math.max
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
        val lines = AocUtils.input(this::class.java)

        val ranges = lines
            .filter { it.contains("-") }
            .map { it.split("-") }
            .map { (it[0].toLong()..it[1].toLong()) }
            .sortedBy { it.first }
            .sortedWith { o1, o2 ->
                if (o1.first != o2.first)
                    o1.first.compareTo(o2.first)
                else
                    o1.last.compareTo(o2.last)
            }

        val mergedRanges = mutableListOf<LongRange>()
        var lastRange = ranges[0]
        for (i in 1..<ranges.size) {
            val range = ranges[i]
            if (lastRange.last < range.first) {
                mergedRanges.add(lastRange)
                lastRange = range
                continue
            }
            lastRange = (lastRange.first..max(lastRange.last, range.last))
        }
        mergedRanges.add(lastRange)

        val result = mergedRanges.sumOf { it.last - it.first + 1 }
        println("Result: $result")
    }
}
