package ru.javarush.entity.animal.predator;

import ru.javarush.entity.animal.Animal;

public class Predator extends Animal {

    public Predator(String type, String icon, double startWeight) {
        super(type, icon, startWeight);
    }

    @Override
    public void eat(Object food) {

    }
}
