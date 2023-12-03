package day3

import lines

fun main() {
    val schema = lines("day3").map { it.split("").drop(1).dropLast(1) }

    val numbers = mutableListOf<List<Pair<Int, Int>>>()
    val symbols = mutableListOf<Pair<Int, Int>>()
    for (row in schema.indices) {
        var currentNumber = mutableListOf<Pair<Int, Int>>()
        print("$row - ")
        for (column in schema[row].indices) {
            val char = schema[row][column]
            print(char)
            if (column == schema[row].size - 1) {
                if (char.first().isDigit()) {
                    currentNumber.add(Pair(row, column))
                }
                if (currentNumber.isNotEmpty()) {
                    numbers.add(currentNumber)
                    currentNumber = mutableListOf()
                }
            } else if (char == ".") {
                if (currentNumber.isNotEmpty()) {
                    numbers.add(currentNumber)
                    currentNumber = mutableListOf()
                }
            } else if (char.first().isDigit()) {
                currentNumber.add(Pair(row, column))
            } else {
                if (currentNumber.isNotEmpty()) {
                    numbers.add(currentNumber)
                    currentNumber = mutableListOf()
                }
                symbols.add(Pair(row, column))
            }
        }
        println()
    }

    val good = mutableListOf<List<Pair<Int, Int>>>()
    for (number in numbers) {
        var isGood = false
        println(number)
        for ((row, column) in number) {
            for ((rowSymbol, colSymbol) in symbols) {
                val adjacentRow = row == rowSymbol || row == rowSymbol + 1 || row == rowSymbol - 1
                val adjacentColumn = column == colSymbol || column == colSymbol + 1 || column == colSymbol - 1
                if (adjacentRow && adjacentColumn) {
                    isGood = true
                    break
                }
            }
        }
        if (isGood) {
            good.add(number)
            isGood = false
        }
    }

    val sum = good.sumOf { it.joinToString("") { (row, column) -> schema[row][column] }.toInt() }
    println("Part 1: $sum")
}