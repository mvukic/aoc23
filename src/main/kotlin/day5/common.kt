package day5

import java.math.BigInteger

data class MappingGroup(
    val name: String,
    val mappings: List<Mapping>
) {

    fun findMapping(seed: Long): Mapping? {
        return mappings.find { it.isInRange(seed) }
    }

    companion object {
        fun fromStrings(name: String, lines: List<String>): MappingGroup {
            val index = lines.indexOf(name)
            val mappings = lines.drop(index + 1).takeWhile { it != "" }.map(Mapping::fromString)
            return MappingGroup(name, mappings)
        }
    }
}

data class Mapping(
    val destination: Long,
    val source: Long,
    val range: Long
) {


    fun isInRange(seed: Long): Boolean {
        return seed >= source && seed <= source + range
    }

    companion object {
        fun fromString(line: String): Mapping {
            val (destination, source, range) = line.split(" ").map { it.toLong() }
            return Mapping(destination, source, range)
        }
    }

}

fun mapSeed(seed: Long, mappingGroup: MappingGroup): Long {
    val mapping = mappingGroup.findMapping(seed) ?: return seed
    return seed + (mapping.destination - mapping.source)
}

fun getSeedList(line: String): List<Long> {
    return line.split(" ").drop(1).map { it.toLong() }
}