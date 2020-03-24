package com.driverless.car;

/**
 * car interface
 */
public interface Car {

    void move(String command);

    int getPositionX();

    int getPositionY();

    String getDirection();


}
