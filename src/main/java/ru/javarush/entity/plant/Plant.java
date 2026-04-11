package ru.javarush.entity.plant;

public class Plant {
    private final String icon;
    private double weight;
    private boolean isAlive = true;

    public Plant(String icon, double weight) {
        this.icon = icon;
        this.weight = weight;
    }

    public String getIcon() {
        return icon;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
