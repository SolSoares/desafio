package com.solsoares.marsrover.application;

import com.solsoares.marsrover.domain.Input;
import com.solsoares.marsrover.domain.Rover;

/**
 * @author Solange Soares
 */
public class MarsRoverApplication {

    public static void main(String[] args) {
        Input input = InputAdapter.loadInput();

        for (Rover rover: input.getRovers()) {
            rover.move(input.getPlateau());
            System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getDirectionValue());
        }
    }
}