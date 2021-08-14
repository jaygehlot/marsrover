package com.jg.mr;

import java.util.Optional;

public class Rover {

    Facing facingDirection = Facing.NORTH;
    XYCoordinates coordinates = new XYCoordinates(0, 0);

    private final RoverGrid roverGrid;

    public Rover(RoverGrid roverGrid) {
        this.roverGrid = roverGrid;
    }

    public String execute(String commands) {
        String obstacleIndicator = "";
        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                facingDirection = facingDirection.right();
            }
            if (c == 'L') {
                facingDirection = facingDirection.left();
            }
            if(c == 'M') {
                Optional<XYCoordinates> nextCoordinate = roverGrid.coordinateFor(coordinates, facingDirection);
                nextCoordinate.ifPresent(xyCoordinates -> this.coordinates = xyCoordinates);
                obstacleIndicator = nextCoordinate.isPresent() ? "" : "O:";
                if (!obstacleIndicator.isEmpty()) {
                    break;
                }
            }
        }
        return obstacleIndicator + coordinates.getX() + ":" + coordinates.getY() + ":" + facingDirection.value();
    }

}
