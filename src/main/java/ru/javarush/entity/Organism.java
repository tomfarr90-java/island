package ru.javarush.entity;

import ru.javarush.map.Location;

public abstract class Organism {
    private final String type;
    private final String icon;
    private double currentWeight;
    private boolean isAlive = true;

    public Organism(String type, String icon, double weight) {
        this.type = type;
        this.icon = icon;
        this.currentWeight = weight;
    }

    public abstract void addTo(Location location);
    public abstract void removeFrom(Location location);
    public abstract long countIn(Location location);

    public String getType() { return type; }
    public String getIcon() { return icon; }
    public double getCurrentWeight() { return currentWeight; }
    public void setCurrentWeight(double weight) { this.currentWeight = weight; }
    public boolean isAlive() { return isAlive; }
    public void setAlive(boolean alive) { isAlive = alive; }
}
