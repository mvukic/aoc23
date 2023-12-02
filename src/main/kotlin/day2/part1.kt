package day2

import getLines

fun main() {
    val lines = getLines("day2.txt")

    val games = lines.map { Game.fromLine(it) }
    val valid = games.filter { it.isValid() }.sumOf { it.id }
    println("Part 1: $valid")
}

