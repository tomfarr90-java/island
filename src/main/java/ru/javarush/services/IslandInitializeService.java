package ru.javarush.services;

import ru.javarush.entity.animal.herbivore.Sheep;
import ru.javarush.entity.animal.predator.Wolf;
import ru.javarush.entity.plant.Plant;
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
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Location location = island.getLocation(x, y);
                seedAnimals(location, "WOLF");
                seedAnimals(location, "SHEEP");

                seedPlants(location);
            }
        }
    }

    private void seedAnimals(Location location, String type) {
        var stats = ConfigRepository.getStatsFor(type);

        int count = ThreadLocalRandom.current().nextInt(stats.getMaxCount() / 2);
        for (int i = 0; i < count; i++) {

            if (type.equals("WOLF")) location.addOrganism(new Wolf(stats));
            if (type.equals("SHEEP")) location.addOrganism(new Sheep(stats));
        }
    }

    private void seedPlants(Location location) {
        var stats = ConfigRepository.getStatsFor("PLANT");
        int count = ThreadLocalRandom.current().nextInt(stats.getMaxCount());
        for (int i = 0; i < count; i++) {
            location.addOrganism(new Plant(stats));
        }
    }
}