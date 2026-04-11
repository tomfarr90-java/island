package ru.javarush.dto;

import java.util.Map;

public class AnimalStats {
    private String icon;
    private double weight;
    private int maxCount;
    private int maxMove;
    private double foodNeeded;
    private Map<String, Integer> chanceEat;

    public AnimalStats() {
    }

    public String getIcon() {
        return icon;
    }
    public double getWeight() { return weight; }
    public int getMaxCount() { return maxCount; }
    public int getMaxMove() { return maxMove; }
    public double getFoodNeeded() { return foodNeeded; }
    public Map<String, Integer> getChanceEat() { return chanceEat; }


    public void setIcon(String icon) {
        this.icon = icon;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
    public void setMaxMove(int maxMove) {
        this.maxMove = maxMove;
    }
    public void setFoodNeeded(double foodNeeded) {
        this.foodNeeded = foodNeeded;
    }
    public void setChanceEat(Map<String, Integer> chanceEat) {
        this.chanceEat = chanceEat;
    }
}

