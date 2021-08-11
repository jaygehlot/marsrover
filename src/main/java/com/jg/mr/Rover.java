package com.jg.mr;

public class Rover {

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
        int y=0;
        if (facingDirection == Facing.NORTH) {
            y += 1;
        }
        return new XYCoordinates(coordinates.getX(), y);
    }


}
