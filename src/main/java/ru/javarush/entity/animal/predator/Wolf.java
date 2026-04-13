package ru.javarush.entity.animal.predator;

import ru.javarush.dto.OrganismStats;

public class Wolf extends Predator{
    public Wolf(OrganismStats stats) {
        super("WOLF", stats);
    }
}
