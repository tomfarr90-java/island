package ru.javarush.engine;

import ru.javarush.dto.OrganismStats;
import ru.javarush.entity.animal.Animal;
import ru.javarush.entity.plant.Plant;
import ru.javarush.map.Island;
import ru.javarush.map.Location;
import ru.javarush.repository.ConfigRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationEngine {
    private final Island island;
    private final ExecutorService executorService;

    public SimulationEngine(Island island) {
        this.island = island;
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void run() {
        int day = 1;
        while (day <= 10) {
            System.out.println("---День симуляции: " + day + "---");
            step();
            printStats();
            day++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
        executorService.shutdown();
    }

    private void step() {
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Location location = island.getLocation(x, y);
                executorService.submit(() -> {
                    List<Animal> animals = new ArrayList<>(location.getAnimals());
                    for (Animal animal : animals) {
                        animal.liveDay(location, island);
                    }
                    growPlants(location);
                });
            }
        }
    }

    private void growPlants(Location location) {
        OrganismStats plantStats = ConfigRepository.getStatsFor("PLANT");
        Plant newPlant = new Plant(plantStats);
        location.addOrganism(newPlant);
    }

    private void printStats() {
        int totalAnimals = 0;
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                totalAnimals += island.getLocation(x, y).getAnimals().size();
            }
        }
        System.out.println("Животных на острове: " + totalAnimals);
    }
}
