package ru.javarush.entity;

public abstract class Organism {
    private final String type;
    private final String icon;
    private final double baseWeight;
    private double currentWeight;
    private boolean isAlive = true;

    public Organism(String type, String icon, double baseWeight) {
        this.type = type;
        this.icon = icon;
        this.baseWeight = baseWeight;
        this.currentWeight = baseWeight;
    }

    public double getBaseWeight() {
        return baseWeight;
    }
    public String getType() { return type; }
    public String getIcon() { return icon; }
    public double getCurrentWeight() { return currentWeight; }
    public void setCurrentWeight(double weight) { this.currentWeight = weight; }
    public boolean isAlive() { return isAlive; }
    public void setAlive(boolean alive) { isAlive = alive; }
}
