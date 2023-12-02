package day1

import getLines

fun main() {

    val lines = getLines("day1.txt")
    val m = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
        "0" to 0,
        "1" to 1,
        "2" to 2,
        "3" to 3,
        "4" to 4,
        "5" to 5,
        "6" to 6,
        "7" to 7,
        "8" to 8,
        "9" to 9,
    )
    val regex = Regex("(?=(one|two|three|four|five|six|seven|eight|nine|1|2|3|4|5|6|7|8|9))")
    val sum = lines
        .map {
            val r = regex.findAll(it).toList()
                .map { r -> r.groupValues }
                .flatten()
                .filterNot { v ->  v.isEmpty() }
            r
        }
        .sumOf { numbers ->
            val digits = numbers.map { m[it]!! }
            "${digits.first()}${digits.last()}".toInt()
        }
    println("Part 2: $sum")
}