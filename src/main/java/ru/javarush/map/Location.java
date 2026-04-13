package ru.javarush.map;

import ru.javarush.dto.OrganismStats;
import ru.javarush.entity.Organism;
import ru.javarush.entity.animal.Animal;
import ru.javarush.entity.plant.Plant;
import ru.javarush.repository.ConfigRepository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private final int x;
    private final int y;

    private final List<Animal> animals = new CopyOnWriteArrayList<>();
    private final List<Plant> plants = new CopyOnWriteArrayList<>();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized void addOrganism(Organism organism) {
        OrganismStats organismStats = ConfigRepository.getStatsFor(organism.getType());
        if (organism.countIn(this) < organismStats.getMaxCount()) {
            organism.addTo(this);
        }
    }

    public synchronized void removeOrganism(Organism organism) {
        organism.removeFrom(this);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public List<Animal> getAnimals() {
        return animals;
    }
    public List<Plant> getPlants() {
        return plants;
    }

    }

