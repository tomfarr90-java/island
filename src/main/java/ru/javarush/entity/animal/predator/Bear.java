package ru.javarush.entity.animal.predator;

import ru.javarush.dto.AnimalStats;

public class Bear extends Predator{
    public Bear(AnimalStats stats) {
        super("Bear", stats);
    }
}
