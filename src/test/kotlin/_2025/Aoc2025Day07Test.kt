package _2025

import AocCoordinates.Point
import AocUtils
import kotlin.test.Test

class Aoc2025Day07Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)

        val start = lines[0].indexOf('S')

        val splitters = mutableListOf<Point>()
        (0..<lines.size).forEach { l ->
            (0..<lines[l].length).forEach { c ->
                if (lines[l][c] == '^')
                    splitters.add(Point.of(l, c))
            }
        }
        println(splitters)

        var beams = setOf(Point.of(1, start))
        println(beams)

        (2..<lines.size).forEach { line ->
            val newBeams = splitters.filter { it.x == line }
                .filter { beams.contains(Point.of(it.x - 1, it.y)) }
                .flatMap {
                    listOf(Point.of(it.x, it.y - 1), Point.of(it.x, it.y + 1))
                }.toSet()

            if (newBeams.isEmpty()) {
                beams = beams.map { Point.of(it.x + 1, it.y) }.toSet()
            } else {
                beams = newBeams
            }

            println(beams)
        }

        val result = 0

        println("Result: $result")
    }

    @Test
    fun aoc2() {
        val lines = AocUtils.input(this::class.java)
        val result = lines
        println("Result: $result")
    }
}
