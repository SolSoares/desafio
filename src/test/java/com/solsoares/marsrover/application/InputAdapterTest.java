package com.solsoares.marsrover.application;

import com.solsoares.marsrover.domain.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputAdapterTest {

    @Test
    void loadInput() {
        Input input = InputAdapter.loadInput();
        assertNotNull(input);
    }

}