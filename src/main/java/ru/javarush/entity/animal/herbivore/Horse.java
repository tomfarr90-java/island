package ru.javarush.entity.animal.herbivore;

import ru.javarush.dto.OrganismStats;

public class Horse extends Herbivore {
    public Horse(OrganismStats stats) {
        super("HORSE", stats);
    }
}
