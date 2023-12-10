package day10

import lines

fun main() {
    val lines = lines("day10")
    val start = getStartCoordinate(lines)
    val path = mutableListOf(
        start,
        Point(x = start.x - 1, y = start.y)
    )
    var previousDirection = 'E'
    val nextPipeLookup = mapOf(
        '|' to "NS",
        '-' to "EW",
        'L' to "NE",
        'J' to "NW",
        '7' to "SW",
        'F' to "SE",
    )
    val nextPointLookup: Map<Char, (Point) -> Point> = mapOf(
        'N' to { Point(x = it.x, y = it.y - 1) },
        'S' to { Point(x = it.x, y = it.y + 1) },
        'E' to { Point(x = it.x + 1, y = it.y) },
        'W' to { Point(x = it.x - 1, y = it.y) },
    )
    val nextDirectionLookup = mapOf(
        'N' to 'S',
        'S' to 'N',
        'E' to 'W',
        'W' to 'E'
    )
    while (true) {
//        println("Path $path")
        val currentPoint = path.last()

//        println("\tCurrent point: $currentPoint")
        val currentPointTile = lines[currentPoint.y][currentPoint.x]

//        println("\tCurrent point tile: $currentPointTile")
        val dir = nextPipeLookup[currentPointTile]!!.first { it != previousDirection }

//        println("\tNext direction: $dir")
        val nextPoint = nextPointLookup[dir]!!(currentPoint)
        if (nextPoint == start) {
            break
        }
        path.add(nextPoint)
        previousDirection = nextDirectionLookup[dir]!!
//        println("\tNew prev dir: $previousDirection")
    }
    println("Part 1: ${path.size / 2}")

}
