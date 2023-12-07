package day7

import lines

fun main() {
    val lines = lines("day7")
    val hands = lines
        .map { line -> line.split(" ").filterNot { it.isBlank() } }
        .map { (hand, bid) -> HandPart1.fromString(hand, bid) }

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


data class CardPart1(
    var label: String
) : Comparable<CardPart1> {
    override fun compareTo(other: CardPart1): Int {
        if (label == other.label) {
            return 0
        }
        if (ordersPart1.indexOf(label) > ordersPart1.indexOf(other.label)) {
            return 1
        }
        return -1
    }
}

val ordersPart1 = listOf("A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2")

data class HandPart1(
    val bid: Int,
    val cards: List<CardPart1>
) : Comparable<HandPart2> {

    override fun compareTo(other: HandPart2): Int {
        if (typeOrder() == other.typeOrder()) {
            return 0
        }
        if (typeOrder() < other.typeOrder()) {
            return 1
        }
        return -1
    }

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
        fun fromString(line: String, bid: String) = HandPart1(
            bid = bid.toInt(),
            cards = line.split("").filterNot { it.isBlank() }.map { CardPart1(it) }
        )

    }
}
