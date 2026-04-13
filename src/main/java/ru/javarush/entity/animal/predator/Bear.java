package ru.javarush.entity.animal.predator;

import ru.javarush.dto.OrganismStats;

public class Bear extends Predator{
    public Bear(OrganismStats stats) {
        super("BEAR", stats);
    }
}
