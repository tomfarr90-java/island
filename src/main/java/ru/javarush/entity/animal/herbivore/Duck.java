package ru.javarush.entity.animal.herbivore;

import ru.javarush.dto.AnimalStats;

public class Duck extends Herbivore {
    public Duck(AnimalStats stats) {
        super("Duck", stats);
    }
}
