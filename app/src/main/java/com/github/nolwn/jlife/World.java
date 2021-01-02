package com.github.nolwn.jlife;

public class World {
    public static final char DEAD = ' ';
    public static final char ALIVE = '*';

    private int width;
    private int height;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String toString() {
        String output = "";

        for(int i = 0; i < width * height; i++) {
            output += DEAD;

            if ((i + 1) % width == 0) {
                output += '\n';
            }

        }

        return output;
    }
}
