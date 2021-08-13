package com.jg.mr;

import java.util.Collections;
import java.util.List;

public class RoverGrid {
    private static final int MAXIMUM_GRID_HEIGHT = 10;
    private static final int MAXIMUM_GRID_WIDTH = 10;

    private List<XYCoordinates> obstacles = Collections.emptyList();

    RoverGrid() {
    }

    public <T> RoverGrid(List<XYCoordinates> asList) {

    }

    public XYCoordinates coordinateFor(XYCoordinates coordinates, Facing facingDirection) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (facingDirection == Facing.NORTH) {
            y = (y + 1) % MAXIMUM_GRID_HEIGHT;
        }
        if (facingDirection == Facing.EAST) {
            x = (x + 1) % MAXIMUM_GRID_WIDTH;
        }

        if (facingDirection == Facing.WEST) {
            x = (x > 0) ? x - 1 : MAXIMUM_GRID_WIDTH - 1;
        }

        if (facingDirection == Facing.SOUTH) {
            y = (y > 0) ? y - 1 : MAXIMUM_GRID_HEIGHT - 1;
        }
        return new XYCoordinates(x, y);
    }
}
