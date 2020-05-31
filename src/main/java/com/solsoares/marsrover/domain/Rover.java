package com.solsoares.marsrover.domain;

import java.util.LinkedList;
import java.util.List;

public class Rover {

    private int x;
    private int y;
    private Direction direction;
    private List<Coordinate> coordinates = new LinkedList();

    public Rover(int axisX, int axisY, String direction) {
        this.x = axisX;
        this.y = axisY;
        this.direction = Direction.getDirectionByString(direction).orElse(null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirectionValue() {
        return direction.getStringDirection();
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void move(Plateau plateau) {
        for (Coordinate coordinate : coordinates) {
            switch (coordinate) {
                case LEFT -> rotateLeft();
                case RIGHT -> rotateRight();
                case MOVE -> moveForward(plateau);
            }
        }
    }

    private void rotateLeft() {
        this.direction = Direction.getDirectionByDegree(direction.getDegree() - 90);
    }

    private void rotateRight() {
        this.direction = Direction.getDirectionByDegree(direction.getDegree() + 90);
    }

    private void moveForward(Plateau plateau) {
        switch (direction) {
            case NORTH -> {
                y++;
                if (y > plateau.getY()) throw new InvalidMoveException();
            }
            case SOUTH -> {
                y--;
                if (y < 0)  throw new InvalidMoveException();
            }
            case EAST -> {
                x++;
                if (x > plateau.getX())  throw new InvalidMoveException();
            }
            case WEST -> {
                x--;
                if (this.getX() < 0)  throw new InvalidMoveException();
            }
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }
}
