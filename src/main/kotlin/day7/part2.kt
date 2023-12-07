package day7

import lines

fun main() {
    val lines = lines("day7")
    val hands = lines
        .map { line -> line.split(" ").filterNot { it.isBlank() } }
        .map { (hand, bid) -> Hand.fromString(hand, bid) }

    val sorted = hands.sortedWith(
        compareBy({ it.typeOrder() },
            { it.cards[0] },
            { it.cards[1] },
            { it.cards[2] },
            { it.cards[3] },
            { it.cards[4] })
    )

    for (hand in sorted.reversed()) {
        println(hand)
    }
    val result = sorted.reversed().mapIndexed { i, hand -> hand.bid * (i + 1) }.sum()
    println("Part 1: $result")
}