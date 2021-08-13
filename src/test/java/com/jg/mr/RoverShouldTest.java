package com.jg.mr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class RoverShouldTest {

    private Rover rover;

    @BeforeEach
    void initialise() {
        RoverGrid roverGrid = new RoverGrid();
        rover = new Rover(roverGrid);
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

    @Test
    void moveUpThriceOnYAxis() {
        assertThat(rover.execute("MMM"), is("0:3:N"));
    }

    @Test
    void roverWrapsAroundFromTopToBottomWhenAtTopOfGridHittingMaxHeight() {
        assertThat(rover.execute("MMMMMMMMMM"), is("0:0:N"));
    }

    @Test
    void roverWrapsAroundFromTopToBottomContinuingAfterReachingMaxHeight() {
        //so goes to end of the grid y=10 and continues another 2 steps
        assertThat(rover.execute("MMMMMMMMMMMM"), is("0:2:N"));
    }

    @Test
    void rotateRightMoveAlongOneOnXAxis() {
        assertThat(rover.execute("RM"), is("1:0:E"));
    }

    @Test
    void rotateRightMoveAlongFiveOnXAxis() {
        assertThat(rover.execute("RMMMMM"), is("5:0:E"));
    }

    @Test
    void roverWrapsAroundFromLeftToRightWhenAtEndOfGridHittingMaxLength() {
        assertThat(rover.execute("RMMMMMMMMMM"), is("0:0:E"));
    }

    @Test
    void roverWrapsAroundFromRightToLeftContinuingAfterReachingMaxWidth() {
        //so goes to end of the grid x=10 and continues another 2 steps
        assertThat(rover.execute("RMMMMMMMMMMMM"), is("2:0:E"));
    }

    @Test
    void rotateLeftMoveAlongOne() {
        assertThat(rover.execute("LM"), is("9:0:W"));
    }

    @Test
    void rotateLeftMoveAlongFive() {
        assertThat(rover.execute("LMMMMM"), is("5:0:W"));
    }

    @Test
    void rotateLeftTwiceMoveSouthOnce() {
        assertThat(rover.execute("LLM"), is("0:9:S"));
    }

    @Test
    void rotateLeftTwiceMoveSouthFiveTime() {
        assertThat(rover.execute("LLMMMMM"), is("0:5:S"));
    }

}