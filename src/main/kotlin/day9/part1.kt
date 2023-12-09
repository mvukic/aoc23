package day9

import lines

fun main() {
    val lines = lines("day9")
    val result = mutableListOf<Int>()
    for (line in lines) {
        var currentRow = line.split(" ").filter { it.isNotBlank() }.map { it.toInt() }
        val lastNumbers = mutableListOf(currentRow.last())
        while (true) {
            println("Current row: $currentRow")
            currentRow = getNextRow(currentRow)
            lastNumbers.add(currentRow.last())
            if (currentRow.all { it == 0 }) {
                break
            }
        }
        println("Last numbers: $lastNumbers")
        result.add(lastNumbers.sum())
        println("Next number is ${result.last()}")
        println()
    }
    println("Part 1: ${result.sum()}")
}