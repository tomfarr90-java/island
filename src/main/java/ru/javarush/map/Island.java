package ru.javarush.map;

public class Island {
    private final int width;
    private final int height;
    private final Location[][] locations;

    public Island (int width, int height) {
        this.width = width;
        this.height = height;
        this.locations = new Location[width][height];
        initialize();
    }

    public void initialize() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations[x][y] = new Location(x,y);
            }
        }
    }
    public Location getLocation(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return locations[x][y];
        }
        throw new IllegalArgumentException("Координаты (" + x + "," + y + ") вне границ острова");
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}

