package ru.javarush.services;

import ru.javarush.entity.animal.herbivore.Sheep;
import ru.javarush.entity.animal.predator.Wolf;
import ru.javarush.entity.plant.Plant;
import ru.javarush.factory.EntityFactory;
import ru.javarush.map.Island;
import ru.javarush.map.Location;
import ru.javarush.repository.ConfigRepository;

import java.util.concurrent.ThreadLocalRandom;

public class IslandInitializeService {
    private final Island island;

    public IslandInitializeService(Island island) {
        this.island = island;
    }

    public void initialize() {
        var allTypes = ConfigRepository.getAllTypes();
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Location location = island.getLocation(x, y);

                for (String type : allTypes) {
                    if (type.equals("PLANT")) {
                        seedPlants(location);
                    } else {
                        seedAnimals(location, type);
                    }
                }
            }
        }
    }

    private void seedAnimals(Location location, String type) {
        var stats = ConfigRepository.getStatsFor(type);
        int maxPossible = Math.max(stats.getMaxCount() / 10, 2);
        int count = ThreadLocalRandom.current().nextInt(maxPossible);
        for (int i = 0; i < count; i++) {
            location.addOrganism(EntityFactory.createAnimal(type));
        }
    }

    private void seedPlants(Location location) {
        var stats = ConfigRepository.getStatsFor("PLANT");
        int count = ThreadLocalRandom.current().nextInt(stats.getMaxCount() / 4 + 1);
        for (int i = 0; i < count; i++) {
            location.addOrganism(EntityFactory.createPlant());
        }
    }
}
