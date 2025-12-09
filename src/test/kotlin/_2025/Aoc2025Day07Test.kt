package _2025

import AocUtils
import kotlin.test.Test

class Aoc2025Day07Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)

        val maxY = lines.size
        val maxX = lines[0].length
        val beams = Array(maxY) { CharArray(maxX) }
        (0..<maxY).forEach { y ->
            var x = 0
            while (x < maxX) {
                if (y > 0 && (lines[y - 1][x] == 'S' || (beams[y - 1][x] == '|') && lines[y][x] != '^')) {
                    beams[y][x] = '|'
                } else if (lines[y][x] == '^') {
                    beams[y][x - 1] = '|'
                    beams[y][x] = lines[y][x]
                    beams[y][++x] = '|'
                } else {
                    beams[y][x] = lines[y][x]
                }
                x++
            }
        }

        // beams.forEach { println(it) }

        var counter = 0
        (0..<maxY).forEach { y ->
            (0..<maxX).forEach { x ->
                if (beams[y][x] == '^' && beams[y - 1][x] == '|') {
                    counter++
                }
            }
        }

        println(counter)
    }

    @Test
    fun aoc2() {
        val lines = AocUtils.input(this::class.java)

        val maxY = lines.size
        val maxX = lines[0].length
        val beams = Array(maxY) { IntArray(maxX) }
        beams[0][lines[0].indexOf('S')] = 1

        (0..<maxY).forEach { y ->
            var x = 0
            while (x < maxX) {
                if (y > 0 && (beams[y - 1][x] > 0) && lines[y][x] != '^') {
                    beams[y][x] = beams[y - 1][x]
                } else if (lines[y][x] == '^') {
                    beams[y][x - 1] += beams[y - 1][x] + beams[y - 1][x - 1]
                    beams[y][x] = 0
                    beams[y][++x] += beams[y - 1][x - 1] + beams[y - 1][x]
                } else if (y > 0) {
                    beams[y][x] = 0
                }
                x++
            }
        }

        beams.forEach { line -> println(line.toList().map { if (it == 0) "  " else it.toString().padStart(2) }) }
    }
}
