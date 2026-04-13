package ru.javarush.entity.animal.herbivore;

import ru.javarush.dto.OrganismStats;
import ru.javarush.entity.animal.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(String type, OrganismStats stats) {
        super(type, stats);
    }
}
