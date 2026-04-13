package ru.javarush.entity.animal.herbivore;

import ru.javarush.dto.OrganismStats;

public class Duck extends Herbivore {
    public Duck(OrganismStats stats) {
        super("DUCK", stats);
    }
}
