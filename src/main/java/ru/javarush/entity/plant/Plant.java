package ru.javarush.entity.plant;

import ru.javarush.dto.OrganismStats;
import ru.javarush.entity.Organism;
import ru.javarush.map.Location;

public class Plant extends Organism {
    public Plant(OrganismStats stats) {
        super("PLANT", stats.getIcon(), stats.getWeight());
    }

    @Override
    public void addTo(Location location) {
        location.getPlants().add(this);
    }

    @Override
    public void removeFrom(Location location) {
        location.getPlants().remove(this);
    }

    @Override
    public long countIn(Location location) {
        return location.getPlants().size();
    }
}
