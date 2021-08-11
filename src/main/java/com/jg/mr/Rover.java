package com.jg.mr;

public class Rover {

    Facing facingDirection = Facing.NORTH;

    public String execute(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                facingDirection = facingDirection.right();

            }
            if (c == 'L') {
                facingDirection = facingDirection.left();
            }
        }
        return "0:0:" + facingDirection.value();
    }
}
