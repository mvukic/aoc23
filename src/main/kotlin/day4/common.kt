package day4

import kotlin.math.pow

data class Card(
    val id: Int,
    val winning: List<Int>,
    val owning: List<Int>
) {

    fun intersectSize() = winning.intersect(owning).size

    fun points(): Int {
        return if (intersectSize() == 0) 0 else 2.toDouble().pow((intersectSize() - 1)).toInt()
    }

    companion object {
        fun fromString(line: String): Card {
            val (id, w, o) = line.split("Card ", ": ", " | ").drop(1)
            return Card(
                id = id.trim().toInt(),
                winning = w.split(" ").filter { it.isNotBlank() }.map { it.trim() }.map { it.toInt() },
                owning = o.split(" ").filter { it.isNotBlank() }.map { it.trim() }.map { it.toInt() }
            )
        }
    }

}