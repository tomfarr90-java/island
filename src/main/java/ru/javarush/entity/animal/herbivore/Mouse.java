package ru.javarush.entity.animal.herbivore;

import ru.javarush.dto.AnimalStats;

public class Mouse extends Herbivore {
    public Mouse(AnimalStats stats) {
        super("Mouse", stats);
    }
}
