package com.solsoares.marsrover.domain;

import java.util.LinkedList;

public record Input(Plateau plateau, LinkedList<Rover>rovers) {
}
