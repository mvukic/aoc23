package day2

import getLines

fun main() {
    val lines = getLines("day2.txt")

    val games = lines.map { Game.fromLine(it) }
    val sum = games.sumOf { it.maxBlue() * it.maxGreen() * it.maxRed() }
    println("Part 2: $sum")
}