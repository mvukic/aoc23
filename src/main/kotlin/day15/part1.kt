package day15

import lines

fun main() {
    val lines = lines("day15").first().split(",")
    val currentValues = mutableListOf<Int>()
    for (line in lines) {
        println("Line: $line")
        currentValues.add(hash(line))
    }
    println("Part 1: ${currentValues.sum()}")
}