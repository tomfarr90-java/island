package ru.javarush.repository;

import ru.javarush.dto.OrganismStats;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConfigRepository {
    private static Map<String, OrganismStats> allStats = new HashMap<>();

    public static void init(Map<String, OrganismStats> stats) {
        allStats = stats;
    }

    public static OrganismStats getStatsFor(String animalType) {
        if (animalType == null) return null;
        OrganismStats stats = allStats.get(animalType.toUpperCase());
        if (stats == null) {
            System.err.println("Внимание, конфиг для " + animalType + " не найден!");
        }
        return stats;
    }

    public static Set<String> getAllTypes() {
        return allStats.keySet();
    }
}
