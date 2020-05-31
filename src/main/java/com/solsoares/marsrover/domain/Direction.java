package com.solsoares.marsrover.domain;

import java.util.Optional;
import java.util.stream.Stream;

public enum Direction {
    NORTH(0, "N"),
    SOUTH(180, "S"),
    WEST(270, "W"),
    EAST(90, "E");

    private int degree;
    private String stringDirection;

    Direction(int degree, String stringDirection) {
        this.degree = degree;
        this.stringDirection = stringDirection;
    }

    public int getDegree() {
        return degree;
    }

    public String getStringDirection() {
        return stringDirection;
    }

    public static Optional<Direction> getDirectionByString(String stringDirection) {
        return Stream.of(values()).filter(direction -> direction.stringDirection.equals(stringDirection)).findFirst();
    }

    public static Direction getDirectionByDegree(int degree) {
        switch (degree) {
            case 0:
            case 360:
                return NORTH;
            case 90:
                return EAST;
            case 180:
                return SOUTH;
            case 270:
            case -90:
                return WEST;
        }
        return null;
    }
}
