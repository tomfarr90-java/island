package ru.javarush.entity.common;

import ru.javarush.entity.animal.Animal;
import ru.javarush.map.Location;

public interface Reproducible {

    Animal reproduce(Location currentLocation);
}
