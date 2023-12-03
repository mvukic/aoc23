package day2

import readInput

fun main() {
    val lines = readInput("day2")

    val games = lines.map { Game.fromLine(it) }
    val sum = games.sumOf { it.maxBlue() * it.maxGreen() * it.maxRed() }
    println("Part 2: $sum")
}