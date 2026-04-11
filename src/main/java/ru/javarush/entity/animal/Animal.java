package ru.javarush.entity.animal;

import ru.javarush.entity.common.Movable;
import ru.javarush.entity.common.Reproducible;
import ru.javarush.map.Location;

public abstract class Animal implements Movable, Reproducible {
    private final String type;
    private final String icon;
    private double currentWeight;
    private boolean isAlive = true;

    public Animal(String type, String icon, double startWeight) {
        this.type = type;
        this.icon = icon;
        this.currentWeight = startWeight;
    }

    public abstract void eat(Object food);

    @Override
    public void move(Location currentLocation) {

    }

    @Override
    public Animal reproduce(Location currentLocation) {
        return null;
    }

    public String getType() {
        return type;
    }
    public String getIcon() {
        return icon;
    }
    public double getCurrentWeight() {
        return currentWeight;
    }
    public boolean isAlive() {
        return isAlive;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}

