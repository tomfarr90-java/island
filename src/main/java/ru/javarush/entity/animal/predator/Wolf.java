package ru.javarush.entity.animal.predator;

import ru.javarush.dto.AnimalStats;

public class Wolf extends Predator{
    public Wolf(AnimalStats stats) {
        super("Wolf", stats);
    }
}
