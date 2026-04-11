package ru.javarush.repository;

import ru.javarush.dto.AnimalStats;
import ru.javarush.entity.animal.Animal;
import ru.javarush.entity.animal.herbivore.*;
import ru.javarush.entity.animal.predator.*;
import ru.javarush.entity.plant.Plant;

public class EntityFactory {

    public static Animal createAnimal(String type) {
        AnimalStats stats = ConfigRepository.getStatsFor(type);
        if (stats == null) {
            throw new RuntimeException("Статистика для типа " + type + " не найдена!");
        }
        String icon = stats.getIcon();
        double weight = stats.getWeight();
        return switch (type.toUpperCase()) {
            case "WOLF"-> new Wolf(icon,weight);
            case "BEAR" -> new Bear(icon, weight);
            case "BOA" -> new Boa(icon,weight);
            case "FOX" -> new Fox(icon,weight);
            case "EAGLE" -> new Eagle(icon,weight);
            case "BOAR" -> new Boar(icon,weight);
            case "BUFFALO" -> new Buffalo(icon,weight);
            case "CATERPILLAR" -> new Caterpillar(icon,weight);
            case "DEER" -> new Deer(icon,weight);
            case "DUCK" -> new Duck(icon,weight);
            case "GOAT" -> new Goat(icon,weight);
            case "HORSE" -> new Horse(icon,weight);
            case "MOUSE" -> new Mouse(icon,weight);
            case "RABBIT" -> new Rabbit(icon,weight);
            case "SHEEP" -> new Sheep(icon,weight);
            default -> throw new IllegalArgumentException("Неизвестный тип животного: " + type);
        };
    }

    public static Plant createPlant() {
        AnimalStats stats = ConfigRepository.getStatsFor("PLANT");
        return new Plant(stats.getIcon(),stats.getWeight());
    }
}
