package ru.javarush.entity.animal.herbivore;

import ru.javarush.dto.OrganismStats;

public class Rabbit extends Herbivore {
    public Rabbit(OrganismStats stats) {
        super("RABBIT", stats);
    }
}
