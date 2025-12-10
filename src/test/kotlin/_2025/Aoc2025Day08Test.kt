package _2025

import AocUtils
import kotlin.math.sqrt
import kotlin.test.Test

class Aoc2025Day08Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)

        val positions = lines.map { line ->
            Point.of(line.split(",").map { it.toLong() })
        }
        val sortedDists = (0..<positions.size).flatMap { i ->
            (i + 1..<positions.size).map { j ->
                val dist = positions[i].dist(positions[j])
                Dist(positions[i], positions[j], dist)
            }
        }
            .sortedBy { it.dist }

        val boxes = mutableListOf<Box>()
        sortedDists.take(1000).forEach { dist ->
            boxes.firstOrNull { box -> box.contains(dist.p1) }?.add(dist.p2)
                ?: boxes.firstOrNull { box -> box.contains(dist.p2) }?.add(dist.p1)
                ?: boxes.add(Box.of(dist.p1, dist.p2))
        }

        val sortedBoxes = boxes.map { it.points.size }.sortedDescending()
        val result = sortedBoxes[0].toLong() * sortedBoxes[1].toLong() * sortedBoxes[2].toLong()
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

data class Point(val x: Long, val y: Long, val z: Long) {
    companion object {
        fun of(ints: List<Long>): Point {
            return Point(ints[0], ints[1], ints[2])
        }
    }

    fun dist(p: Point): Double {
        val dx = x - p.x
        val dy = y - p.y
        val dz = z - p.z
        return sqrt((dx * dx + dy * dy + dz * dz).toDouble())
    }
}

