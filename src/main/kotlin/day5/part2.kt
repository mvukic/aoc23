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
    var min: Long = Long.MAX_VALUE
    for ((first, second) in seeds.windowed(2, 2)) {
        println("Seed range $first, $second, ${first + second}")
        for (seed in LongRange(first, first + second)) {
//            println("\tSeed: $seed")
            var mappedSeed = seed
            for (mappingGroup in mappingGroups) {
                mappedSeed = mapSeed(mappedSeed, mappingGroup)
            }
//            println("\t\tMapped to $mappedSeed")
            if (min > mappedSeed) {
                min = mappedSeed
            }
        }
    }
    println("Part 2: $min")


}
