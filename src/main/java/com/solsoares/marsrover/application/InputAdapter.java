package com.solsoares.marsrover.application;

import com.solsoares.marsrover.domain.Coordinate;
import com.solsoares.marsrover.domain.Input;
import com.solsoares.marsrover.domain.Plateau;
import com.solsoares.marsrover.domain.Rover;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class InputAdapter {

    private static Plateau plateau;
    private static LinkedList<Rover> rovers = new LinkedList();
    private final static String INPUT = "src/main/resources/input/cooordinates.txt";

    public static Input loadInput() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Input(plateau, rovers);
    }

    private static void parseLine(String line) {
        String[] chars = line.split(" ");

        switch (chars.length) {
            case 2 -> plateau = new Plateau(Integer.parseInt(chars[0]), Integer.parseInt(chars[1]));
            case 3 -> rovers.add(new Rover(Integer.parseInt(chars[0]), Integer.parseInt(chars[1]), chars[2]));
            default -> parseCoordinates(chars[0]);
        }
    }

    private static void parseCoordinates(String coordinates) {
        char[] coordinateArray = coordinates.toCharArray();

        for (char coordinate:coordinateArray)
            rovers.peekLast().getCoordinates().add(Coordinate.getCoordinateByString(String.valueOf(coordinate)).orElse(null));
    }
}