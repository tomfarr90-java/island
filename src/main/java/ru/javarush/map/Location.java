package ru.javarush.map;

import ru.javarush.entity.animal.Animal;
import ru.javarush.entity.plant.Plant;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private final int x;
    private final int y;

    private final List<Animal> animals = new CopyOnWriteArrayList<>();
    private final List<Plant> plants = new CopyOnWriteArrayList<>();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
    public List<Plant> getPlants() {
        return plants;
    }

    public void addAnimal (Animal animal) {

    }
    public void removeAnimal(Animal animal){}
    public void addPlant(Plant plant) {

    }
}
