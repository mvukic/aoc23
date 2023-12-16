package day14

fun main() {
    val rocks = getRocks()
    printRocks(rocks)

    for (y in rocks.indices) {
        if (y == 0) continue
//        println("Y: $y Line: ${rocks[y]}")
        for (x in rocks[y].indices) {
            if (rocks[y][x] != "O") continue
            rocks[y][x] = "."
            rocks[getTopmostRow(x, y, rocks)][x] = "O"
        }
    }

//    printRocks(rocks)
    println("Part 1: ${calculateResult1(rocks)}")
}



fun calculateResult1(rocks: List<List<String>>): Int {
    return rocks
        .mapIndexed { y, line -> line.count { it == "O" } * (rocks.size - y) }
        .sum()
}