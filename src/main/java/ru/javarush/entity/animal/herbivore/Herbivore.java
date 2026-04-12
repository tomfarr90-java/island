package ru.javarush.entity.animal.herbivore;

import ru.javarush.dto.AnimalStats;
import ru.javarush.entity.animal.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(String type, AnimalStats stats) {
        super(type, stats);
    }
}
