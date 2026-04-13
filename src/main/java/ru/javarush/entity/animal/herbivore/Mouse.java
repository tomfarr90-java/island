package ru.javarush.entity.animal.herbivore;

import ru.javarush.dto.OrganismStats;

public class Mouse extends Herbivore {
    public Mouse(OrganismStats stats) {
        super("MOUSE", stats);
    }
}
