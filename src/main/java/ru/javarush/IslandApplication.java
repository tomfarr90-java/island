package ru.javarush;

import ru.javarush.config.ConfigYamlLoader;
import ru.javarush.engine.SimulationEngine;
import ru.javarush.map.Island;
import ru.javarush.services.IslandInitializeService;

public class IslandApplication {

    public void start() {
        ConfigYamlLoader.loadConfig();
        Island island = new Island(1000, 20);
        IslandInitializeService service = new IslandInitializeService(island);
        service.initialize();
        System.out.println("Остров заселен! Начинаем симуляцию...");
        SimulationEngine engine = new SimulationEngine(island);
        engine.run();
    }
}
