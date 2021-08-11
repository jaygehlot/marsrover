package com.jg.mr;

public class Rover {

    Facing facingDirection = Facing.NORTH;
    private final int x = 0;
    private final int y = 0;

    public String execute(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                facingDirection = facingDirection.right();

            }
            if (c == 'L') {
                facingDirection = facingDirection.left();
            }
        }
        return x + ":" + y + ":" + facingDirection.value();
    }
}
