package com.solangesas.marsrover.application;

import com.solangesas.marsrover.domain.Coordinate;
import com.solangesas.marsrover.domain.Plateau;
import com.solangesas.marsrover.domain.Rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Solange Soares
 *
 * A squad of robotic rovers are to be landed by NASA on a plateau on Mars.
 * This plateau, which is curiously rectangular, must be navigated by the rovers
 * so that their on board cameras can get a complete view of the surrounding terrain to send back to Earth.
 * A rover's position is represented by a combination of an x and y coordinates and a letter representing one of the four cardinal compass points.
 * The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N,
 * which means the rover is in the bottom left corner and facing North.
 * In order to control a rover, NASA sends a simple string of letters.
 * The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively,
 * without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.
 * Assume that the square directly North from (x, y) is (x, y+1).
 *
 * Input:
 * The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
 * The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input.
 * The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.
 * The position is made up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the rover's orientation.
 * Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.
 *
 * Output:
 * The output for each rover should be its final co-ordinates and heading.
 *
 * Test Input:
 * 	5 5
 * 	1 2 N
 * 	LMLMLMLMM
 * 	3 3 E
 * 	MMRMMRMRRM
 *
 * Expected Output:
 * 1 3 N
 * 5 1 E
 *
 */
public class MarsRoverApplication {

    private static Plateau plateau;
    private static LinkedList<Rover> rovers = new LinkedList();

    public static void main(String[] args) throws Exception  {

        loadInput();

        for (Rover rover:rovers) {
            rover.move(plateau);
            System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getDirection());
        }

    }

    /**
     *  This method loads the input coordinates
     *  @author It is a given source code
     */
    public static void loadInput() {

        String file ="src/main/resources/input/cooordinates.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method parses each line of the input coordinates
     * @author Solange Soares
     * @param line
     */
    public static void parseLine(String line) {
        String[] chars = line.split(" ");

        switch (chars.length) {
            case 2:
                plateau = new Plateau(Integer.parseInt(chars[0]), Integer.parseInt(chars[1]));
                break;
            case 3:
                rovers.add(new Rover(Integer.parseInt(chars[0]), Integer.parseInt(chars[1]), chars[2]));
                break;
            default:
                parseCoordinates(chars[0]);
                break;
        }
    }

    /**
     * This method parses each coordinate
     * @author Solange Soares
     * @param coordinates
     */
    public static void parseCoordinates(String coordinates) {
        char[] coordinateArray = coordinates.toCharArray();

        for (char coordinate:coordinateArray) {
            rovers.peekLast().getCoordinates().add(Coordinate.getCoordinateByText(String.valueOf(coordinate)));
        }
    }
}