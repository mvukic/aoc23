package day1

import lines

fun main() {

    val lines = lines("day1")


    val sum = lines.sumOf { line ->
        val first = line.first { it.isDigit() }
        val last = line.last { it.isDigit() }
        "$first$last".toInt()
    }
    println("Part 1: $sum")
}