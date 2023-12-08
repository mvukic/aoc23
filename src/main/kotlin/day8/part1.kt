package day8

import lines

fun main() {
    val lines = lines("day8")

    val orientations = lines.first().toCharArray()
    val navigations = lines.drop(2).map(Navigation::fromString).associateBy { it.name }

    var orientationIndex = 0
    var point = "AAA"
    var steps = 0
    while (true) {
        if (point == "ZZZ") {
            println("Part 1: $steps")
            break
        }
        val navigation = navigations[point]!!
        println("Navigation $navigation")

        val orientation = orientations[orientationIndex]
        println("Orientation $orientation")
        point = if (orientation == 'L') navigation.left else navigation.right

        steps++
        orientationIndex++
        if (orientationIndex == orientations.size) {
            orientationIndex = 0
        }
    }

}