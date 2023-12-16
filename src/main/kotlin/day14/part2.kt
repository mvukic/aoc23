package day14

fun main() {
    val rocks = getRocks()
//    printRocks(rocks)

    for (cycle in (1..100000)) {
        moveNorth(rocks)
        moveWest(rocks)
        moveSouth(rocks)
        moveEast(rocks)
    }
    printRocks(rocks)
    println("Part 2: ${calculateResult1(rocks)}") // 106689
}

fun moveNorth(rocks: MutableList<MutableList<String>>) {
    for (y in rocks.indices) {
        if (y == 0) continue

        for (x in rocks[y].indices) {
            if (rocks[y][x] != "O") continue
            rocks[y][x] = "."
            rocks[getTopmostRow(x, y, rocks)][x] = "O"
        }
    }
}

fun moveSouth(rocks: MutableList<MutableList<String>>) {
    for (y in rocks.indices.reversed()) {
        if (y == rocks.size - 1) continue

        for (x in rocks[y].indices) {
            if (rocks[y][x] != "O") continue
            rocks[y][x] = "."
            rocks[getBottommostRow(x, y, rocks)][x] = "O"
        }
    }
}

fun moveWest(rocks: MutableList<MutableList<String>>) {
    for (y in rocks.indices) {
        for (x in rocks[y].indices) {
            if (rocks[y][x] != "O") continue
            rocks[y][x] = "."
            rocks[y][getLeftmostRow(x, y, rocks)] = "O"
        }
    }
}

fun moveEast(rocks: MutableList<MutableList<String>>) {
    for (y in rocks.indices) {
        for (x in rocks[y].indices.reversed()) {
            if (rocks[y][x] != "O") continue
            rocks[y][x] = "."
            rocks[y][getRightmostRow(x, y, rocks)] = "O"
        }
    }
}