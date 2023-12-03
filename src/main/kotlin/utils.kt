import java.io.File

fun readInput(name: String) = File("src/main/kotlin/$name", "$name.txt").readLines()