package ru.javarush.entity.animal.predator;

import ru.javarush.dto.AnimalStats;

public class Fox extends Predator{
    public Fox(AnimalStats stats) {
        super("Fox", stats);
    }
}
