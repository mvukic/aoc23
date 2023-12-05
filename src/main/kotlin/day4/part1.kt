package day4

import lines

fun main() {
    val cards = lines("day4").map(Card::fromString)
    val points = cards.sumOf { it.points() }
    println("Part 1: $points")
}