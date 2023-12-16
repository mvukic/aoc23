package day15

fun hash(str: String): Int {
    var currentValue = 0
    val chars = str.toCharArray()
    for (c in chars) {
        val code = c.code
        println("\t$c -> $code")
        currentValue += code
        currentValue *= 17
        currentValue %= 256
    }
    println(currentValue)
    return currentValue
}