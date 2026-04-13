package ru.javarush.repository;

import ru.javarush.dto.OrganismStats;
import ru.javarush.entity.animal.Animal;
import ru.javarush.entity.animal.herbivore.*;
import ru.javarush.entity.animal.predator.*;
import ru.javarush.entity.plant.Plant;

public class EntityFactory {

    public static Animal createAnimal(String type) {
        OrganismStats stats = ConfigRepository.getStatsFor(type);
        if (stats == null) {
            throw new RuntimeException("Статистика для типа " + type + " не найдена!");
        }
        String icon = stats.getIcon();
        double weight = stats.getWeight();
        return switch (type.toUpperCase()) {
            case "WOLF"-> new Wolf(stats);
            case "BEAR" -> new Bear(stats);
            case "BOA" -> new Boa(stats);
            case "FOX" -> new Fox(stats);
            case "EAGLE" -> new Eagle(stats);
            case "BOAR" -> new Boar(stats);
            case "BUFFALO" -> new Buffalo(stats);
            case "CATERPILLAR" -> new Caterpillar(stats);
            case "DEER" -> new Deer(stats);
            case "DUCK" -> new Duck(stats);
            case "GOAT" -> new Goat(stats);
            case "HORSE" -> new Horse(stats);
            case "MOUSE" -> new Mouse(stats);
            case "RABBIT" -> new Rabbit(stats);
            case "SHEEP" -> new Sheep(stats);
            default -> throw new IllegalArgumentException("Неизвестный тип животного: " + type);
        };
    }

    public static Plant createPlant() {
        OrganismStats stats = ConfigRepository.getStatsFor("PLANT");
        return new Plant(stats);
    }
}
