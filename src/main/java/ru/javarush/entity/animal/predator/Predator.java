package ru.javarush.entity.animal.predator;

import ru.javarush.dto.AnimalStats;
import ru.javarush.entity.animal.Animal;

public abstract class Predator extends Animal {
    public Predator(String type, AnimalStats stats) {
        super(type, stats);
    }
}
