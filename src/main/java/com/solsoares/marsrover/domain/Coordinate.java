package com.solsoares.marsrover.domain;

import java.util.Optional;
import java.util.stream.Stream;

public enum Coordinate {
    LEFT("L"),
    RIGHT("R"),
    MOVE("M");

    private String coordinate;

    Coordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public static Optional<Coordinate> getCoordinateByString(String coordinate) {
        return Stream.of(values()).filter(c -> c.coordinate.equals(coordinate)).findFirst();
    }
}
