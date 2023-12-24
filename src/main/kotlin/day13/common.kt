package day13

fun getGroups(lines: List<String>): List<Group> {
    val groups = mutableListOf<Group>()
    var currentList = mutableListOf<List<String>>()
    for (index in lines.indices) {
        val line = lines[index]
        if (line.isBlank() || index == lines.size - 1) {
            groups.add(Group(currentList))
            currentList = mutableListOf()
        } else {
            currentList.add(line.split("").filter(String::isNotBlank))
        }
    }
    return groups
}


data class Group(
    val lines: List<List<String>>
)

fun <T> List<List<T>>.transpose(): List<List<T>> {
    return (this[0].indices).map { i -> (this.indices).map { j -> this[j][i] } }
}

tailrec fun isReflected(lines: List<List<String>>, up: Int, down: Int): Boolean {
    val newUpIndex = up - 1
    val newDownIndex = down + 1

    // Out of bounds
    if (newUpIndex < 0 || newDownIndex >= lines.size) return true

    // Is equal
    val newUp = lines[newUpIndex].joinToString("")
    val newDown = lines[newDownIndex].joinToString("")

    return if (newUp == newDown) {
        isReflected(lines, newUpIndex, newDownIndex)
    } else {
        false
    }
}

fun getReflectionPoints(lines: List<List<String>>): List<Pair<Int, Int>> {
    return lines
        .mapIndexed { index, strings -> index to strings }
        .windowed(2, 1)
        .filter {
            val (first, second) = it
            first.second.joinToString("") == second.second.joinToString("")
        }
        .map {
            val (first, second) = it
            first.first to second.first
        }
}

fun printLines(lines: List<List<String>>) {
    for (line in lines) {
        for (c in line) {
            print(c)
        }
        println()
    }
}