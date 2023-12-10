package day10

import lines

fun main() {
    val lines = lines("day10")
    val path = getPath(lines)
    printImage(lines, path)
    val s = shoelaceArea(path)
    println("Part 2: ${s - path.size / 2 + 1}")
}

fun getPath(lines: List<String>): List<Point> {
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
        val currentPoint = path.last()
        val currentPointTile = lines[currentPoint.y][currentPoint.x]
        val dir = nextPipeLookup[currentPointTile]!!.first { it != previousDirection }
        val nextPoint = nextPointLookup[dir]!!(currentPoint)
        if (nextPoint == start) {
            break
        }
        path.add(nextPoint)
        previousDirection = nextDirectionLookup[dir]!!
    }
    return path
}

fun printImage(lines: List<String>, marked: List<Point>) {
    val asSet = marked.toSet()
    lines.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { columnIndex, column ->
            if (Point(columnIndex, rowIndex) in asSet) {
                print(column)
            } else {
                print(".")
            }
        }
        println()
    }
}

fun shoelaceArea(v: List<Point>): Double {
    val n = v.size
    var a = 0.0
    for (i in 0 until n - 1) {
        a += v[i].x * v[i + 1].y - v[i + 1].x * v[i].y
    }
    return Math.abs(a + v[n - 1].x * v[0].y - v[0].x * v[n -1].y) / 2.0
}