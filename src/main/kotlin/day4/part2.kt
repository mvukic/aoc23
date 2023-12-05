package day4

import lines

fun main() {
    val cards = lines("day4").map(Card::fromString)
    val counter = buildMap {
        cards.forEach {
            this[it.id] = 1
        }
    }.toMutableMap()

    for (index in cards.indices) {
        val card = cards[index]
        println("Card ${card.id}")
        var intersectSize = card.intersectSize()
        if (intersectSize == 0) {
            println("\tNo intersect")
            continue
        }
        println("\tIntersect size $intersectSize")
        val nextCards = cards.drop(index + 1).take(intersectSize)
        println("\tNext card ${nextCards.map { it.id }}")
        nextCards.forEach { nextCard ->
            counter[nextCard.id] = counter[nextCard.id]!! + counter[index + 1]!!
        }
        counter.forEach { t, u -> println("\t\t$t -> $u") }
    }

    val sum = counter.values.sum()
    println("Part 2: $sum")
}