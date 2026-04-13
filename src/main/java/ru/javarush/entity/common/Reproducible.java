package ru.javarush.entity.common;

import ru.javarush.map.Location;

public interface Reproducible {

    void reproduce(Location currentLocation);
}
