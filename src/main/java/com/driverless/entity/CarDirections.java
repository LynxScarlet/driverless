package com.driverless.entity;

/**
 * car directions
 */

public enum CarDirections {

    EAST("EAST"),
    WEST("WEST"),
    SOUTH("SOUTH"),
    NORTH("NORTH");

    private String direction;
    CarDirections(String direction) {
        this.direction=direction;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "CarDirections{" +
                "direction='" + direction + '\'' +
                '}';
    }
}
