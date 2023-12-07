package day7

import lines

fun main() {
    val lines = lines("day7")
    val hands = lines
        .map { line -> line.split(" ").filterNot { it.isBlank() } }
        .map { (hand, bid) -> HandPart2.fromString(hand, bid) }

    for (hand in hands) {
        if (!hand.cards.contains(CardPart2("J"))) {
            continue
        }
        var orderType = 6
        var sign = "J"
        for (cardSign in ordersPart2) {
            val copy = hand.copy(cards = hand.cards.map { it.copy() })
            copy.cards.filter { it.label == "J" }.forEach { it.label = cardSign }
            if (copy.typeOrder() < orderType) {
                orderType = copy.typeOrder()
                sign = cardSign
            }
        }
        hand.cards.filter { it.label == "J" }.forEach {
            it.label = sign
            it.wasWildcard = true
        }
    }

    val sorted = hands.sortedWith(
        compareBy({ it.typeOrder() },
            { it.cards[0] },
            { it.cards[1] },
            { it.cards[2] },
            { it.cards[3] },
            { it.cards[4] })
    )

    for (hand in sorted.reversed()) {
        print("${hand.typeOrder()} ")
        println(hand)
    }
    val result = sorted.reversed().mapIndexed { i, hand -> hand.bid * (i + 1) }.sum()
    println("Part 2: $result")
}


data class CardPart2(
    var label: String,
    var wasWildcard: Boolean = false
) : Comparable<CardPart2> {

    fun getRealCard() = if (wasWildcard) "J" else label

    override fun compareTo(other: CardPart2): Int {
        if (getRealCard() == other.getRealCard()) {
            return 0
        }
        if (ordersPart2.indexOf(getRealCard()) > ordersPart2.indexOf(other.getRealCard())) {
            return  1
        }
        return -1
    }

    override fun toString(): String {
        return " $label ($wasWildcard) "
    }
}

data class HandPart2(
    val bid: Int,
    val cards: List<CardPart2>
) {

    fun typeOrder(): Int {
        val occurrences = cards.groupingBy { it.label }.eachCount()
        return when {
            occurrences.values.contains(5) -> {
//                println("Five of kind")
                0
            }

            occurrences.values.contains(4) -> {
//                println("Four of kind")
                1
            }

            occurrences.values.contains(3) && occurrences.values.contains(2) -> {
//                println("Full house")
                2
            }

            occurrences.values.contains(3) && occurrences.values.contains(1) -> {
//                println("Three of kind")
                3
            }

            occurrences.values.contains(2) && occurrences.keys.size == 3 -> {
//                println("Two pair")
                4
            }

            occurrences.values.contains(2) && occurrences.keys.size == 4 -> {
//                println("One pair")
                5
            }

            occurrences.keys.size == 5 -> {
//                println("High card")
                6
            }

            else -> error("WTF!")
        }
    }

    companion object {
        fun fromString(line: String, bid: String) = HandPart2(
            bid = bid.toInt(),
            cards = line.split("").filterNot { it.isBlank() }.map { CardPart2(it) }
        )

    }

}

val ordersPart2 = listOf("A", "K", "Q", "T", "9", "8", "7", "6", "5", "4", "3", "2", "J")