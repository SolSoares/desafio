package com.ssoares.model;

public enum Direction {
	N(0, "N"), S(180, "S"), W(270, "W"), E(90, "E");
	
	private int degree;
	private String stringDirection;
	
	private Direction(int degree, String stringDirection) {
		this.degree = degree;
		this.stringDirection = stringDirection;
	}

	public int getDegree() {
		return degree;
	}
	
	public static Direction getDirectionByString(String stringDirection) {		
		for(Direction direction : values()) {
			if (direction.stringDirection.equals(stringDirection)) {
				return direction;
			}
		}
		return null;
	}
	
	public static Direction getDirectionByDegree(int degree) {
		switch (degree) {
			case 0:
				return N;
			case 90:
				return E;
			case 180:
				return S;
			case 270:
				return W;
			case 360:
				return N;
			case -90:
				return W;
		}
		return null;
	}
}
