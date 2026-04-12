package ru.javarush.entity.animal.predator;

import ru.javarush.dto.AnimalStats;

public class Eagle extends Predator{
    public Eagle(AnimalStats stats) {
        super("Eagle", stats);
    }
}
