package com.jg.mr;

public class Rover {

    Facing facingDirection = Facing.NORTH;
    XYCoordinates coordinates= new XYCoordinates(0, 0);

    private final RoverGrid roverGrid;

    public Rover(RoverGrid roverGrid) {
        this.roverGrid = roverGrid;
    }

    public String execute(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                facingDirection = facingDirection.right();

            }
            if (c == 'L') {
                facingDirection = facingDirection.left();
            }
            if(c == 'M') {
                coordinates = roverGrid.coordinateFor(coordinates, facingDirection);
            }
        }
        return coordinates.getX() + ":" + coordinates.getY() + ":" + facingDirection.value();
    }

}
