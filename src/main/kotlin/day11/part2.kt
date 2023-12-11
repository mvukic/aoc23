package day11

import lines

fun main() {
    val lines = lines("day11")
    val expanded = expand2(lines)
//    printMap(expanded)
    val points = findPoints2(expanded)
//    println(points)
    var sum = 0
    for (point1Index in points.indices) {
        for (point2Index in (point1Index..<points.size)) {
            sum += getDistance2(points[point1Index], points[point2Index])
        }
    }
    println("Part 2: $sum")
}

fun getDistance2(point1: Point1, point2: Point1): Int {
    val xDiff = kotlin.math.abs(point2.x - point1.x)
    val yDiff = kotlin.math.abs(point2.y - point1.y)
    val d = xDiff + yDiff
    return d
}

fun findPoints2(lines: List<String>): List<Point1> {
    val points = mutableListOf<Point1>()
    lines.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { columnIndex, column ->
            if (column == '#') {
                points.add(Point1(x = columnIndex, y = rowIndex))
            }
        }
    }
    return points

}

fun expand2(lines: List<String>): List<String> {
    val result = mutableListOf<String>()

    for (row in lines) {
        result.add(row)
        if (row.all { it == '.' }) {
            repeat(999999) {
                result.add(row)
            }
        }
    }

    var expandedRows = 0
    for (columnIndex in (0..<lines.first().length)) {
        val column = lines.map { it[columnIndex] }
        if (column.all { it == '.' }) {
            expandedRows++
            result.forEachIndexed { rowIndex, _ ->
                val row = result[rowIndex].split("").filterNot { it.isBlank() }.toMutableList()
                repeat(999999) {
                    row.add(columnIndex + expandedRows, ".")
                }
                result[rowIndex] = row.joinToString("")
            }
        }
    }
    return result
}

fun printMap2(lines: List<String>) {
    for (line in lines) {
        for (col in line) {
            print(col)
        }
        println()
    }
}

data class Point2(
    val x: Int,
    val y: Int
) {
    override fun toString() = "(${x}, ${y})"
}