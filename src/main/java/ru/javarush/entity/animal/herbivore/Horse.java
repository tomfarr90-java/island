package ru.javarush.entity.animal.herbivore;

import ru.javarush.dto.AnimalStats;
import ru.javarush.entity.animal.Animal;

public class Horse extends Herbivore {
    public Horse(AnimalStats stats) {
        super("Horse", stats);
    }
}
