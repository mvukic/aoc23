package day13

import lines

fun main() {
    val lines = lines("day13")
    val groups = getGroups(lines)
    var sum = 0
    for (group in groups) {
//        printLines(group.lines)
        val horizontal = getReflectionPoints(group.lines.transpose())
//        println("Horizontal: $horizontal")
        val vertical = getReflectionPoints(group.lines)
//        println("Vertical: $vertical")

//        for (h in vertical) {
//            println("Reflected vertically on $h: ${isReflected(group.lines, h.first, h.second)}")
//        }
         vertical.firstOrNull { isReflected(group.lines, it.first, it.second) }?.let {
//             println("Vertical $it")
             sum += it.second * 100
         }
//        for (h in horizontal) {
//            println("Reflected horizontally on $h: ${isReflected(group.lines.transpose(), h.first, h.second)}")
//        }

        horizontal.firstOrNull { isReflected(group.lines.transpose(), it.first, it.second) }?.let {
//            println("Horizontal $it")
            sum += it.second
        }

//        println()
    }

    println("Part 1: $sum")
}