package ru.javarush.entity.animal;


import ru.javarush.dto.AnimalStats;
import ru.javarush.entity.Organism;
import ru.javarush.entity.common.*;

public abstract class Animal extends Organism implements Movable, Reproducible {
    private final AnimalStats stats;

    public Animal(String type,AnimalStats stats) {
        super(type, stats.getIcon(), stats.getWeight());
        this.stats = stats;
    }

    public AnimalStats getStats() {
        return stats;
    }
}

