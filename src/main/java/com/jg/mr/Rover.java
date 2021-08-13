package com.jg.mr;

public class Rover {

    private static final int MAXIMUM_GRID_HEIGHT = 10;
    private static final int MAXIMUM_GRID_WIDTH = 10;
    Facing facingDirection = Facing.NORTH;
    XYCoordinates coordinates= new XYCoordinates(0, 0);

    public String execute(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                facingDirection = facingDirection.right();

            }
            if (c == 'L') {
                facingDirection = facingDirection.left();
            }
            if(c == 'M') {
                coordinates = move();
            }
        }
        return coordinates.getX() + ":" + coordinates.getY() + ":" + facingDirection.value();
    }

    private XYCoordinates move() {
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
