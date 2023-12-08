package day8

import lines

fun main() {
    val lines = lines("day8")

    val orientations = lines.first().toCharArray()
    val navigations = lines.drop(2).map(Navigation::fromString).associateBy { it.name }

    var orientationIndex = 0

    val paths = navigations
        .filter { it.value.name.endsWith("A") }
        .map { NavigationPath(it.value.name, 0) }

    for (path in paths) {
        while (true) {
            if (path.point.endsWith("Z")) {
                break
            }

            val navigation = navigations[path.point]!!
//            println("Navigation $navigation")

            val orientation = orientations[orientationIndex]
//            println("Orientation $orientation")
            path.point = if (orientation == 'L') navigation.left else navigation.right

            path.steps++
            orientationIndex++
            if (orientationIndex == orientations.size) {
                orientationIndex = 0
            }
        }
    }
    println(paths.map { it.steps })
    println("Part 2: 11283670395017")

}

data class NavigationPath(
    var point: String,
    var steps: Int
)
