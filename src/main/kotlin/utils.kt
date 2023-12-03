import java.io.File

fun lines(name: String) = File("src/main/kotlin/$name", "$name.txt").readLines()