package com.driverless.entity;

/**
 * car park
 */
public class CarPark {

    private int height;

    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public CarPark(int width,int height) {
        this.height = height;
        this.width = width;
    }
    public CarPark(){}

    @Override
    public String toString() {
        return "CarPark{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
