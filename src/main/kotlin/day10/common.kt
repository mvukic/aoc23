package day10

fun getStartCoordinate(rows: List<String>): Point {
    rows.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { columnIndex, column ->
            if (column == 'S') {
                return Point(y = rowIndex, x = columnIndex)
            }
        }
    }
    error("WTF")
}

data class Point(
    val x: Int,
    val y: Int
) {
    override fun toString() = "($x, $y)"
}