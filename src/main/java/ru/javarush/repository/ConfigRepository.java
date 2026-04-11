package ru.javarush.repository;

import ru.javarush.dto.AnimalStats;

import java.util.HashMap;
import java.util.Map;

public class ConfigRepository {
    private static Map<String, AnimalStats> allStats = new HashMap<>();

    public static void init(Map<String,AnimalStats> stats) {
        allStats = stats;
    }

    public static AnimalStats getStatsFor(String animalType) {
        AnimalStats stats = allStats.get(animalType.toUpperCase());
        if (stats == null) {
            System.err.println("Внимание, конфиг для " + animalType + " не найден!");
        }
        return stats;
    }
}
