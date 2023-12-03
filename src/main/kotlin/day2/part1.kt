package day2

import readInput

fun main() {
    val lines = readInput("day2")

    val games = lines.map { Game.fromLine(it) }
    val valid = games.filter { it.isValid() }.sumOf { it.id }
    println("Part 1: $valid")
}

