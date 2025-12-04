package _2025

import AocCoordinates.Point
import AocUtils
import kotlin.test.Test

class Aoc2025Day04Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)

        val rolls = (0..<lines.size)
            .flatMap { y ->
                (0..<lines[y].length)
                    .filter { x -> lines[y][x] == '@' }
                    .map { x -> Point.of(x, y) }
            }
        val liftables = rolls.filter { it.nachbars(rolls.toSet()).size < 4 }
        println("Result: ${liftables.size}")
    }

    @Test
    fun aoc2() {
        val lines = AocUtils.input(this::class.java)

        var rolls = (0..<lines.size)
            .flatMap { y ->
                (0..<lines[y].length)
                    .filter { x -> lines[y][x] == '@' }
                    .map { x -> Point.of(x, y) }
            }
        var result = 0
        var liftables = rolls.filter { it.nachbars(rolls.toSet()).size < 4 }
        result += liftables.size
        while(!liftables.isEmpty()) {
            rolls = rolls.filter { !liftables.contains(it) }
            liftables = rolls.filter { it.nachbars(rolls.toSet()).size < 4 }
            result += liftables.size
        }

        println("Result: $result")
    }
}
