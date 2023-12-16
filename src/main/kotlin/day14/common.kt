package day14

import lines

fun getRocks(): MutableList<MutableList<String>> {
    val lines = lines("day14")
    return lines.map { line ->
        line.split("").filter { it.isNotBlank() }.toMutableList()
    }.toMutableList()
}

fun printRocks(lines: MutableList<MutableList<String>>) {
    lines.forEach { line ->
        line.forEach { l ->
            print(l)
        }
        println()
    }
}

fun getTopmostRow(x: Int, y: Int, rocks: MutableList<MutableList<String>>): Int {
    var newY = y
    while (true) {
        if (newY == 0) {
            break
        }
        val above = newY - 1
        if (rocks[above][x] == ".") {
            newY = above
        } else {
            break
        }
    }
    return newY
}

fun getBottommostRow(x: Int, y: Int, rocks: MutableList<MutableList<String>>): Int {
    var newY = y
    while (true) {
        if (newY == rocks.size - 1) {
            break
        }
        val below = newY + 1
        if (rocks[below][x] == ".") {
            newY = below
        } else {
            break
        }
    }
    return newY
}

fun getLeftmostRow(x: Int, y: Int, rocks: MutableList<MutableList<String>>): Int {
    var newX = x
    while (true) {
        if (newX == 0) {
            break
        }
        val left = newX - 1
        if (rocks[y][left] == ".") {
            newX = left
        } else {
            break
        }
    }
    return newX
}

fun getRightmostRow(x: Int, y: Int, rocks: MutableList<MutableList<String>>): Int {
    var newX = x
    while (true) {
        if (newX == rocks[y].size - 1) {
            break
        }
        val right = newX + 1
        if (rocks[y][right] == ".") {
            newX = right
        } else {
            break
        }
    }
    return newX
}