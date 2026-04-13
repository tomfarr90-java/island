package ru.javarush.entity.animal.predator;

import ru.javarush.dto.OrganismStats;
import ru.javarush.entity.animal.Animal;

public abstract class Predator extends Animal {
    public Predator(String type, OrganismStats stats) {
        super(type, stats);
    }
}
