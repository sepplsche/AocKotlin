package _2025

import AocUtils
import kotlin.test.Test

class Aoc2025Day03Test {

    @Test
    fun aoc1() {
        val lines = AocUtils.input(this::class.java)
        val result = lines.sumOf { line ->
            val b1 = line.substring(0, line.length - 1).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            val b2 = line.substring(line.indexOf(b1) + 1, line.length).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()

            "$b1$b2".toInt()
        }

        println("Result: $result")
    }

    @Test
    fun aoc2() {
        val lines = AocUtils.input(this::class.java)

        val result = lines.sumOf { line ->
            val b1 = line.substring(0, line.length - 11).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            var line1 = line.substring(line.indexOf(b1) + 1)
            val b2 = line1.substring(0, line1.length - 10).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            line1 = line1.substring(line1.indexOf(b2) + 1)
            val b3 = line1.substring(0, line1.length - 9).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            line1 = line1.substring(line1.indexOf(b3) + 1)
            val b4 = line1.substring(0, line1.length - 8).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            line1 = line1.substring(line1.indexOf(b4) + 1)
            val b5 = line1.substring(0, line1.length - 7).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            line1 = line1.substring(line1.indexOf(b5) + 1)
            val b6 = line1.substring(0, line1.length - 6).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            line1 = line1.substring(line1.indexOf(b6) + 1)
            val b7 = line1.substring(0, line1.length - 5).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            line1 = line1.substring(line1.indexOf(b7) + 1)
            val b8 = line1.substring(0, line1.length - 4).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            line1 = line1.substring(line1.indexOf(b8) + 1)
            val b9 = line1.substring(0, line1.length - 3).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            line1 = line1.substring(line1.indexOf(b9) + 1)
            val b10 = line1.substring(0, line1.length - 2).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            line1 = line1.substring(line1.indexOf(b10) + 1)
            val b11 = line1.substring(0, line1.length - 1).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()
            line1 = line1.substring(line1.indexOf(b11) + 1)
            val b12 = line1.substring(0, line1.length).toCharArray()
                .sortedByDescending { c -> "$c".toInt() }[0].toString()

            // println("$b1$b2$b3$b4$b5$b6$b7$b8$b9$b10$b11$b12")

            "$b1$b2$b3$b4$b5$b6$b7$b8$b9$b10$b11$b12".toLong()
        }

        println("Result: $result")
    }
}