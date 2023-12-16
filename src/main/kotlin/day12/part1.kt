package day12
//
//import lines
//
//fun main() {
//    val lines = lines("day12")
//    val records = lines.map(ConditionRecord::fromLine)
//    for (record in records) {
//        println(record)
//        println(puss(record))
//    }
//}
//
//fun puss(record: ConditionRecord): Int {
//    if (record.springs.isEmpty()) {
//        return if (record.groups.isEmpty()) {
//            1
//        } else {
//            0
//        }
//    }
//    return when (record.springs[0]) {
//        "." -> puss(
//            ConditionRecord(
//                springs = record.springs.drop(1),
//                groups = record.groups
//            )
//        )
//
//        "?" -> return puss(
//            ConditionRecord(
//                springs = listOf(".") + record.springs.drop(1),
//                groups = record.groups
//            )
//        ) + puss(
//            ConditionRecord(
//                springs = listOf("#") + record.springs.drop(1),
//                groups = record.groups
//            )
//        )
//
//        "#" -> {
//            val group = record.groups.first()
//            val items = record.springs.takeWhile { it == "#" }
//            if (items.size == group) {
//                if (record.springs.drop(group)[1] == "?") {
//                    puss(
//                        ConditionRecord(
//                            springs = listOf(".") + record.springs.drop(group + 1),
//                            groups = record.groups.drop(1)
//                        )
//                    )
//                } else {
//
//                }
//            } else {
//                0
//            }
//        }
//
//        else -> error("WTF")
//    }
//}
//
//data class ConditionRecord(
//    val springs: List<String>,
//    val groups: List<Int>
//) {
//    companion object {
//        fun fromLine(line: String): ConditionRecord {
//            val parts = line.split(" ")
//
//            return ConditionRecord(
//                springs = parts[0].split("").filter { it.isNotBlank() },
//                groups = parts[1].split(",").map { it.toInt() }
//            )
//        }
//    }
//
//}