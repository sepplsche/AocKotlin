package _2025

import AocUtils
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.test.Test

class Aoc2025Day08Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)

        val boxes = mutableListOf<Box>()
        val positions = lines.map { line ->
            Point.of(line.split(",").map { it.toInt() })
        }
        (0..<positions.size).flatMap { i ->
            (i + 1..<positions.size).map { j ->
                val dist = positions[i].dist(positions[j])
                Dist(positions[i], positions[j], dist)
            }
        }
            .sortedBy { it.dist }
            .forEach { dist ->
                boxes.forEach { box ->
                    if (box.contains(dist.p1)) {
                        box.add(dist.p1)
                    } else if (box.contains(dist.p2)) {
                        box.add(dist.p2)
                    } else {
                        boxes.add(Box.of(dist.p1, dist.p2))
                    }
                }
            }

        val sortedBoxes = boxes.map { it.points.size }.sorted()
        val result = sortedBoxes[0] * sortedBoxes[1] * sortedBoxes[2]
        println("Result = $result")
    }

    @Test
    fun aoc2() {
        val lines = AocUtils.input(this::class.java)

        println(lines)
    }
}

data class Box(val points: MutableSet<Point>) {
    fun contains(point: Point): Boolean {
        return points.contains(point)
    }

    fun add(point: Point) {
        points.add(point)
    }

    companion object {
        fun of(p1: Point, p2: Point): Box {
            val points = mutableSetOf<Point>()
            points.add(p1)
            points.add(p2)
            return Box(points)
        }
    }
}

data class Dist(val p1: Point, val p2: Point, val dist: Double)

data class Point(val x: Int, val y: Int, val z: Int) {
    companion object {
        fun of(ints: List<Int>): Point {
            return Point(ints[0], ints[1], ints[2])
        }
    }

    fun dist(p: Point) = sqrt((x - p.x).toDouble().pow(2) + (y - p.y).toDouble().pow(2) + (z - p.z).toDouble().pow(2))
}

