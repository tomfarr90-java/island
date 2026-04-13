package ru.javarush.entity.animal.herbivore;


import ru.javarush.dto.OrganismStats;

public class Sheep extends Herbivore {
    public Sheep(OrganismStats stats) {
        super("SHEEP", stats);
    }
}
