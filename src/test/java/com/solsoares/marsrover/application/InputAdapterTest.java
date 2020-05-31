package com.solsoares.marsrover.application;

import com.solsoares.marsrover.domain.Input;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputAdapterTest {

    @Test
    public void loadInput() {
        Input input = InputAdapter.loadInput();
        assertNotNull(input);
    }
}