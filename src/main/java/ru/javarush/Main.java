package ru.javarush;

import ru.javarush.engine.SimulationEngine;
import ru.javarush.map.Island;
import ru.javarush.services.IslandInitializeService;

public class Main {
    public static <IslandInitializer> void main(String[] args) {

        Island island = new Island(100, 20); // 100x20 клеток

        // 2. Инициализируем конфиги (предположим, ваш YAML парсер уже загрузил данные)
        // ConfigRepository.init(loadedStats);

        IslandInitializeService service = new IslandInitializeService(island);

        System.out.println("Остров заселен!");

        SimulationEngine engine = new SimulationEngine(island);
        engine.run();
    }
}