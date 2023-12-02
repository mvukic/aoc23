package day1

import getLines

fun main() {

    val lines = getLines("day1.txt")

    val sum = lines.sumOf { line ->
        val first = line.first { it.isDigit() }
        val last = line.last { it.isDigit() }
        "$first$last".toInt()
    }
    println("Part 1: $sum")
}