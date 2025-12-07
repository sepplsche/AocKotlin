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

        (0..<lines.size).forEach { l ->

            splitters
                .filter { it.x == l }
                .filter { it.y == start }


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
