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

    /**
     *  This method loads the input coordinates
     *  @author It is a given source code
     */
    public static Input loadInput() {

        String file ="src/main/resources/input/cooordinates.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Input(plateau, rovers);
    }

    /**
     * This method parses each line of the input coordinates
     * @author Solange Soares
     * @param line
     */
    public static void parseLine(String line) {
        String[] chars = line.split(" ");

        switch (chars.length) {
            case 2 -> plateau = new Plateau(Integer.parseInt(chars[0]), Integer.parseInt(chars[1]));
            case 3 -> rovers.add(new Rover(Integer.parseInt(chars[0]), Integer.parseInt(chars[1]), chars[2]));
            default -> parseCoordinates(chars[0]);
        }
    }

    /**
     * This method parses each coordinate
     * @author Solange Soares
     * @param coordinates
     */
    public static void parseCoordinates(String coordinates) {
        char[] coordinateArray = coordinates.toCharArray();

        for (char coordinate:coordinateArray)
            rovers.peekLast().getCoordinates().add(Coordinate.getCoordinateByString(String.valueOf(coordinate)).orElse(null));
    }
}
