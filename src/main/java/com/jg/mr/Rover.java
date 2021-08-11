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

    enum Facing {
        NORTH("N", "W", "E"),
        EAST("E", "N", "S"),
        SOUTH("S", "E", "W"),
        WEST("W", "S", "N");

        private final String value;
        private final String leftOfValue;
        private final String rightOfValue;

        Facing(String value, String leftOfValue, String rightOfValue) {
            this.value = value;
            this.leftOfValue = leftOfValue;
            this.rightOfValue = rightOfValue;
        }

        public Facing right() {
            return rotationToThe(rightOfValue);
        }

        public Facing left() {
            return rotationToThe(leftOfValue);
        }

        private Facing rotationToThe(String rotationDirection) {
            for (Facing facing : values()) {
                if (facing.value.equals(rotationDirection)) {
                    return facing;
                }
            }
            return null;
        }

        public String value() {
            return value;
        }
    }
}
