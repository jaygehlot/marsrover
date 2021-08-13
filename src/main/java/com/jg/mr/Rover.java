package com.jg.mr;

public class Rover {

    Facing facingDirection = Facing.NORTH;
    XYCoordinates coordinates= new XYCoordinates(0, 0);
    private RoverGrid roverGrid;

    public String execute(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                facingDirection = facingDirection.right();

            }
            if (c == 'L') {
                facingDirection = facingDirection.left();
            }
            if(c == 'M') {
                //coordinates = move();
                roverGrid = new RoverGrid();
                coordinates = roverGrid.coordinateFor(coordinates, facingDirection);
            }
        }
        return coordinates.getX() + ":" + coordinates.getY() + ":" + facingDirection.value();
    }

}
