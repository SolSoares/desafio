package com.solsoares.marsrover.domain;

import java.util.LinkedList;
import java.util.List;

public class Rover {
	
	private int x;
	private int y;
	private Direction direction;
	private List<Coordinate> coordinates = new LinkedList<>();
	
	public Rover(int axisX, int axisY, String direction) {
		this.x = axisX;
		this.y = axisY;
		this.direction = Direction.getDirectionByString(direction);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Coordinate> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}
	
	public void move(Plateau plateau) throws Exception {
		for (Coordinate coordinate:coordinates) {
			switch (coordinate) {
			case L:
				rotateLeft();
				break;

			case R:	
				rotateRight();
				break;
			case M:
				moveForward(plateau);
				break;
			}
		}
	}
	
	private void rotateLeft() {
		this.direction = Direction.getDirectionByDegree(this.getDirection().getDegree() - 90);
	}
	
	private void rotateRight() {
		this.direction = Direction.getDirectionByDegree(this.getDirection().getDegree() + 90);
	}
	
	private void moveForward(Plateau plateau) throws Exception {
		switch (this.getDirection()) {
		case N:
			this.y++;
			if (this.getY() > plateau.getY())
				throw new Exception("Invalid move");
			break;
		case S:
			this.y--;
			if (this.getY() < 0)
				throw new Exception("Invalid move");
			break;
		case E:
			this.x++;
			if (this.getX() > plateau.getX())
				throw new Exception("Invalid move");
			break;
		case W:
			this.x--;
			if (this.getX() < 0)
				throw new Exception("Invalid move");
			break;
		}
	}
}
