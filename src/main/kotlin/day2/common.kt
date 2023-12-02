package day2


data class Game(
    val id: Int,
    val hands: List<Hand>
) {
    fun isValid() = hands.all { it.isValid() }

    fun maxGreen() = hands.maxOfOrNull { it.green } ?: 0
    fun maxBlue() = hands.maxOfOrNull { it.blue } ?: 0
    fun maxRed() = hands.maxOfOrNull { it.red } ?: 0

    companion object {
        fun fromLine(line: String): Game {
            val (first, second) = line.split(": ")
            val (_, i) = first.split(" ")
            return Game(
                id = i.toInt(),
                hands = second.split("; ").map { Hand.fromString(it) }
            )
        }
    }
}

data class Hand(
    val red: Int,
    val green: Int,
    val blue: Int
) {
    fun isValid() = red <= 12 && green <= 13 && blue <= 14

    companion object {
        fun fromString(line: String): Hand {
            var r = 0
            var g = 0
            var b = 0
            line.split(", ").forEach { ball ->
                val (count, color) = ball.split(" ")
                when (color) {
                    "red" -> r = count.toInt()
                    "green" -> g = count.toInt()
                    "blue" -> b = count.toInt()
                }
            }
            return Hand(
                red = r,
                green = g,
                blue = b
            )
        }
    }
}