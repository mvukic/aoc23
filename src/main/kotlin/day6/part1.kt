package day6

import lines

fun main() {
    val lines = lines("day6")

    val times = lines[0]
        .split("Time:")[1]
            .split(" ")
            .filterNot { it.isBlank() }
            .map { it.trim().toInt() }
    val distances = lines[1]
        .split("Distance:")[1]
        .split(" ")
        .filterNot { it.isBlank() }
        .map { it.trim().toInt() }
    var mainCounter = 1
    for ((time, distance) in times.zip(distances)) {
        println("$time $distance")
        var counter = 0
        for (holdTime in (1..< time)) {
            if((time - holdTime) * holdTime > distance) {
                counter++
            }
        }
        mainCounter *= counter
        println("\t Count: $counter")
    }
    println("Part 1: $mainCounter")
}
