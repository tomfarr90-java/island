package ru.javarush.entity.animal;


import ru.javarush.dto.OrganismStats;
import ru.javarush.entity.Organism;
import ru.javarush.entity.common.*;
import ru.javarush.entity.plant.Plant;
import ru.javarush.map.Island;
import ru.javarush.map.Location;
import ru.javarush.repository.ConfigRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism implements Movable, Reproducible {
    private final OrganismStats stats;

    public Animal(String type, OrganismStats stats) {
        super(type, stats.getIcon(), stats.getWeight());
        this.stats = stats;
    }

    public void eat(Location location) {
        Map<String,Integer> probabilities = this.getStats().getChanceEat();
        findFood(location,probabilities).ifPresent(food -> {
            int probability = probabilities.get(food.getType());
            if(ThreadLocalRandom.current().nextInt(100) < probability) {
                double weightGained = Math.min(food.getCurrentWeight(), this.getStats().getFoodNeeded());
                double newWeight = Math.min(this.getStats().getWeight(), this.getCurrentWeight() + weightGained);
                this.setCurrentWeight(newWeight);
                food.setAlive(false);
                location.removeOrganism(food);
            }
        });
    }

    private Optional<Organism> findFood(Location location, Map<String,Integer> probabilities) {
        for(Animal potentialVictim: location.getAnimals()) {
            if(probabilities.containsKey(potentialVictim.getType())) {
                return Optional.of(potentialVictim);
            }
        }
        if (probabilities.containsKey("PLANT")) {
            List<Plant> plants = location.getPlants();
            if(!plants.isEmpty()) {
                return Optional.of(plants.get(0));
            }
        }
        return Optional.empty();
    }

    @Override
    public void reproduce(Location location) {
        OrganismStats stats = this.getStats();
        long currentCount = this.countIn(location);
        if (currentCount >= 2 && currentCount < stats.getMaxCount()) {
            if (ThreadLocalRandom.current().nextBoolean()) {
                try {
                    Animal baby = this.getClass()
                            .getConstructor(OrganismStats.class)
                            .newInstance(this.getStats());
                    location.addOrganism(baby);
                } catch (Exception e) {
                    System.err.println("Ошибка рефлексии при рождении: " + e.getMessage());
                }
            }
        }
    }

    public void move(Location currentLocation, Island island) {
        int maxSteps = this.getStats().getMaxMove();
        if (maxSteps == 0) return;
        int steps = ThreadLocalRandom.current().nextInt(maxSteps) + 1;
        int newX = currentLocation.getX();
        int newY = currentLocation.getY();
        for (int i = 0; i < steps; i++) {
            int direction = ThreadLocalRandom.current().nextInt(4);
            switch (direction) {
                case 0 -> newY = Math.max(0, newY - 1);
                case 1 -> newX = Math.min(island.getWidth() - 1, newX + 1);
                case 2 -> newY = Math.min(island.getHeight() - 1, newY + 1);
                case 3 -> newX = Math.max(0, newX - 1);
            }
        }

        if (newX != currentLocation.getX() || newY != currentLocation.getY()) {
            Location targetLocation = island.getLocation(newX, newY);
            OrganismStats stats = ConfigRepository.getStatsFor(this.getType());
            if (this.countIn(targetLocation) < stats.getMaxCount()) {
                currentLocation.removeOrganism(this);
                targetLocation.addOrganism(this);
            }
        }
    }

    public void hunger() {
        double loss = this.getBaseWeight()*0.1;
        this.setCurrentWeight(this.getCurrentWeight() - loss);

        if(this.getCurrentWeight() <= 0) {
            this.setAlive(false);
        }
    }

    public void liveDay(Location currentLocation,Island island) {
        if(!this.isAlive()) return;
        this.eat(currentLocation);

        if (this.isAlive()) {
            this.reproduce(currentLocation);
        }

        if (this.isAlive()) {
            this.move(currentLocation, island);
        }

        this.hunger();

        if(!this.isAlive()) {
            currentLocation.removeOrganism(this);
        }
    }

    @Override
    public void addTo(Location location) {
        location.getAnimals().add(this);
    }

    @Override
    public void removeFrom(Location location) {
    location.getAnimals().remove(this);
    }

    @Override
    public long countIn(Location location) {
        return location.getAnimals().stream()
                .filter(a -> a.getType().equals(this.getType()))
                .count();
    }

    public OrganismStats getStats() {
        return stats;
    }
}

