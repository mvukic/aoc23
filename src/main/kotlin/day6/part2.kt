package day6

import lines

fun main() {
    val lines = lines("day6")

    val time = lines[0]
        .split("Time:")[1]
        .replace(" ", "").toLong()
    val distance = lines[1]
        .split("Distance:")[1]
        .replace(" ", "").toLong()
    var counter = 0
    println("$time $distance")
    for (holdTime in (1..< time)) {
        if((time - holdTime) * holdTime > distance) {
            counter++
        }
    }
    println("\t Count: $counter")
    println("Part 2: $counter")
}