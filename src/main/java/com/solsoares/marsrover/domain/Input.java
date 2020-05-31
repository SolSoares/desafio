package com.solsoares.marsrover.domain;

import java.util.List;

public class Input {
    private Plateau plateau;
    private List<Rover> rovers;

    public Input(Plateau plateau, List<Rover> rovers) {
        this.plateau = plateau;
        this.rovers = rovers;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public List<Rover> getRovers() {
        return rovers;
    }
}
