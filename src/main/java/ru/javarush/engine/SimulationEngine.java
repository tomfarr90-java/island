package ru.javarush.engine;

import ru.javarush.dto.OrganismStats;
import ru.javarush.entity.animal.Animal;
import ru.javarush.map.Island;
import ru.javarush.map.Location;
import ru.javarush.repository.ConfigRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class SimulationEngine {
    private final Island island;
    private final ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(3);

    public SimulationEngine(Island island) {
        this.island = island;
    }

    public void run() {
        mainPool.scheduleWithFixedDelay(() -> {
            try {
                resetAllAnimals();
                step();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.SECONDS);

        mainPool.scheduleWithFixedDelay(this::growPlantsGlobal, 0, 1, TimeUnit.SECONDS);
        mainPool.scheduleWithFixedDelay(this::printStats, 500, 1000, TimeUnit.MILLISECONDS);
    }

    private void step() {
        List<Location> allLocations = new ArrayList<>();
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                allLocations.add(island.getLocation(x, y));
            }
        }

        allLocations.parallelStream().forEach(location -> {
            List<Animal> animals = new ArrayList<>(location.getAnimals());
            for (Animal animal : animals) {
                animal.liveDay(location, island);
            }
        });
    }

    private void printStats() {
        Map<String, Integer> statsMap = new ConcurrentHashMap<>();
        int totalAnimals = 0;
        int totalPlants = 0;

        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Location location = island.getLocation(x, y);

                for (Animal animal : location.getAnimals()) {
                    statsMap.merge(animal.getIcon(), 1, Integer::sum);
                    totalAnimals++;
                }

                int plantCount = location.getPlants().size();
                if (plantCount > 0) {

                    String plantIcon = ConfigRepository.getStatsFor("PLANT").getIcon();
                    statsMap.merge(plantIcon, plantCount, Integer::sum);
                    totalPlants += plantCount;
                }
            }
        }


        System.out.println("\n======= СТАТИСТИКА ОСТРОВА =======");
        statsMap.forEach((icon, count) -> {
            System.out.print(icon + ": " + count + "   ");
        });
        System.out.println("\n----------------------------------");
        System.out.printf("Всего животных: %d | Всего растений: %d%n", totalAnimals, totalPlants);
        System.out.println("==================================\n");
    }

    private void resetAllAnimals() {
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Location location = island.getLocation(x, y);
                location.getAnimals().forEach(Animal::resetMoved);
            }
        }
    }

    private void growPlantsGlobal() {
        OrganismStats plantStats = ConfigRepository.getStatsFor("PLANT");
        int maxPlants = plantStats.getMaxCount();

        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Location location = island.getLocation(x, y);
                int currentPlants = location.getPlants().size();


                if (currentPlants < maxPlants) {
                    int growth = (maxPlants - currentPlants) / 10 + 1;
                    for (int i = 0; i < growth; i++) {
                        location.addOrganism(ru.javarush.factory.EntityFactory.createPlant());
                    }
                }
            }
        }
    }
}
