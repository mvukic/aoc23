package day8

data class Navigation(
    val name: String,
    val left: String,
    val right: String
) {

    companion object {
        fun fromString(line: String): Navigation {
            val parts = line.split(" = ", "(", ", ", ")")
            return Navigation(
                name = parts.first(),
                left = parts[2].trim(),
                right = parts[3].trim()
            )
        }
    }

}