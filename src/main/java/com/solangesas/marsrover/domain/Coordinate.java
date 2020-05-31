package com.solangesas.marsrover.domain;

public enum Coordinate {
	L("L"), R("R"), M("M");
	
	private String coordinate;
	
	private Coordinate(String coordinate) {
		this.coordinate = coordinate;		
	}
	
	public static Coordinate getCoordinateByText(String coordinate) {
		for (Coordinate coord : values()) {			
			if (coord.coordinate.equals(coordinate)) {
				return coord;
			}
		}
		return null;
	}
}
