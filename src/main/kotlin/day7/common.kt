package day7

data class Card(
    val label: String
) : Comparable<Card> {
    override fun compareTo(other: Card): Int {
        if (label == other.label) {
            return 0
        }
        if (orders.indexOf(label) > orders.indexOf(other.label)) {
            return  1
        }
        return -1
    }
}

val orders = listOf("A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2")

data class Hand(
    val bid: Int,
    val cards: List<Card>
) : Comparable<Hand> {

    override fun compareTo(other: Hand): Int {
        if (typeOrder() == other.typeOrder()) {
            return 0
        }
        if (typeOrder() < other.typeOrder()) {
            return  1
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
        fun fromString(line: String, bid: String) = Hand(
            bid = bid.toInt(),
            cards = line.split("").filterNot { it.isBlank() }.map { Card(it) }
        )

    }

}