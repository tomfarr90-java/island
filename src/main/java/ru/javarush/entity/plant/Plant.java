package ru.javarush.entity.plant;

import ru.javarush.entity.Organism;

public class Plant extends Organism {
    public Plant(String icon, double weight) {
        super("Plant", icon, weight);
    }
}
