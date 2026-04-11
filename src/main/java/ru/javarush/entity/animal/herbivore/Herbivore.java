package ru.javarush.entity.animal.herbivore;

import ru.javarush.entity.animal.Animal;

public class Herbivore extends Animal {
    public Herbivore(String type, String icon, double startWeight) {
        super(type, icon, startWeight);
    }

    @Override
    public void eat(Object food) {

    }


}
