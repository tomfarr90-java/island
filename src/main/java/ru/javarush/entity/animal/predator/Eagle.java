package ru.javarush.entity.animal.predator;

import ru.javarush.dto.OrganismStats;

public class Eagle extends Predator{
    public Eagle(OrganismStats stats) {
        super("EAGLE", stats);
    }
}
