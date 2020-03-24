package com.driverless.car.impl;

import com.driverless.car.Car;

import com.driverless.entity.*;
import com.driverless.exception.CarOutBorderlineException;

/**
 * direvless
 */
public class Driverless implements Car {

    private CarPark carPark;

    private CarState carState;

    public Driverless(CarState carState, CarPark carPark) {
        this.carState = carState;
        this.carPark = carPark;
    }
    public Driverless(){}

    @Override
    public void move(String command) {

        if("TURN".equals(command.toUpperCase())){
            turnClockWise();
        }else{
            int step = Integer.parseInt(command);
            switch(carState.getDirection()){
                case "EAST" :
                    carState.setPositionX(carState.getPositionX()+step);
                    break;
                case "WEST" :
                    carState.setPositionX(carState.getPositionX()-step);
                    break;
                case "SOUTH" :
                    carState.setPositionY(carState.getPositionY()-step);
                    break;
                case "NORTH" :
                    carState.setPositionY(carState.getPositionY()+step);
                    break;
            }

        }
        if(checkBorderline()){
            new CarOutBorderlineException();
        }
        System.out.println(this.toString());
        System.out.println("Please input \"TURN\" or integer");
    }

    /**
     * check car run out car park or not
     */
    private  boolean checkBorderline(){
        int carPositionX = carState.getPositionX();
        int carPositionY = carState.getPositionY();
        int parkWidth = carPark.getWidth();
        int parkHeight = carPark.getHeight();
        boolean carX = carPositionX > parkWidth || carPositionX < 0 ;
        boolean carY = carPositionY > parkHeight || carPositionY < 0;
        if ( carX && carY) {
            System.out.println("car x and y out of borderline");
            return true;
        }
        if(carX){
            System.out.println("car x out of borderline");
            return true;
        }
        if(carY){
            System.out.println("car y out of borderline");
            return true;
        }
        return false;
    }


    public void turnClockWise(){
        switch(carState.getDirection()){
            case "EAST":
                carState.setDirection(CarDirections.SOUTH.getDirection());
                CarDirections.SOUTH.toString();
                break;
            case "WEST":
                carState.setDirection(CarDirections.NORTH.getDirection());
                break;
            case "SOUTH":
                carState.setDirection(CarDirections.WEST.getDirection()) ;
                break;
            case "NORTH":
                carState.setDirection(CarDirections.EAST.getDirection());
                break;
        }
        System.out.println("Please input \"TURN\" or integer");
    }


    @Override
    public int getPositionX() {
        return carState.getPositionX();
    }

    @Override
    public int getPositionY() {
        return carState.getPositionY();
    }


    @Override
    public String getDirection() {
        return carState.getDirection();
    }

    public CarPark getCarPark() {
        return carPark;
    }

    public void setCarPark(CarPark carPark) {
        this.carPark = carPark;
    }

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    @Override
    public String toString() {
        return "driverless{" +
                "carParkWith is " + carPark.getWidth() +
                ",carParkHeight is " + carPark.getHeight() +
                ", driverlessX is " + carState.getPositionX() +
                ", driverlessY  is " + carState.getPositionY() +
                ", driverlessDirections is" + carState.getDirection() +
                '}';
    }


}
