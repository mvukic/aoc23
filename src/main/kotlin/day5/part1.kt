package day5

import lines

fun main() {
    val lines = lines("day5")
    val seeds = getSeedList(lines.first())
    val mappingGroups = listOf(
        MappingGroup.fromStrings("seed-to-soil map:", lines),
        MappingGroup.fromStrings("soil-to-fertilizer map:", lines),
        MappingGroup.fromStrings("fertilizer-to-water map:", lines),
        MappingGroup.fromStrings("water-to-light map:", lines),
        MappingGroup.fromStrings("light-to-temperature map:", lines),
        MappingGroup.fromStrings("temperature-to-humidity map:", lines),
        MappingGroup.fromStrings("humidity-to-location map:", lines)
    )
    val min = seeds.minOfOrNull {
        println("Seed: $it")
        var mappedSeed = it
        for (mappingGroup in mappingGroups) {
            mappedSeed = mapSeed(mappedSeed, mappingGroup)
        }
        println("\tMapped to $mappedSeed")
        mappedSeed
    }
    println("Part 1: $min")
}



