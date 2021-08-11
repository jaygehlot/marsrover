package com.jg.mr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class RoverShouldTest {

    private Rover rover;

    @BeforeEach
    void initialise() {
        rover = new Rover();
    }

    @Test
    void rotateRight() {
        assertThat(rover.execute("R"), is("0:0:E"));
    }

    @Test
    void rotateRightTwice() {
        assertThat(rover.execute("RR"), is("0:0:S"));
    }

    @Test
    void rotateRightThrice() {
        assertThat(rover.execute("RRR"), is("0:0:W"));
    }

    @Test
    void fullRotationRight() {
        assertThat(rover.execute("RRRR"), is("0:0:N"));
    }

    @Test
    void rotateLeft() {
        assertThat(rover.execute("L"), is("0:0:W"));
    }

    @Test
    void rotateLeftTwice() {
        assertThat(rover.execute("LL"), is("0:0:S"));
    }

    @Test
    void rotateLeftThrice() {
        assertThat(rover.execute("LLL"), is("0:0:E"));
    }

    @Test
    void fullRotationLeft() {
        assertThat(rover.execute("LLLL"), is("0:0:N"));
    }

    @Test
    void moveUpOneOnYAxis() {
        assertThat(rover.execute("M"), is("0:1:N"));
    }


}