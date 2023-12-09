package day9

fun getNextRow(numbers: List<Int>): List<Int> {
    return numbers.windowed(2, 1).map { it[1] - it[0] }
}