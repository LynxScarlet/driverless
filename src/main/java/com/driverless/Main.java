package com.driverless;

import com.driverless.car.Car;
import com.driverless.car.impl.Driverless;
import com.driverless.entity.CarPark;
import com.driverless.entity.CarState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("before programe run,please set up params first ");
        CarPark carPark = new CarPark();
        CarState carState = new CarState();
        Car driverless = new Driverless(carState,carPark);
        Scanner in = new Scanner(System.in);
        initnals(in, (Driverless) driverless);
        movdByCtrl(in,(Driverless) driverless);
    }


    public static void initnals(Scanner in,Driverless driverless){
            System.out.println("please input car park width");

            while (in.hasNext()) {
                try {
                    driverless.getCarPark().setWidth(Integer.parseInt(in.next()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("illegal input");
                    System.out.println("please enter integer");
                    continue;
                }
            }

            System.out.println("please input car park height ");

            while (in.hasNext()) {
                try {
                    driverless.getCarPark().setHeight(Integer.parseInt(in.next()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("illegal input");
                    System.out.println("please enter integer");
                    continue;
                }
            }

            System.out.println("please initnals car positionX ");
            while (in.hasNext()) {
                try {
                    driverless.getCarState().setPositionX(Integer.parseInt(in.next()));
                    break;
                }catch ( IllegalArgumentException e ){
                    System.out.println("illegal input");
                    System.out.println("please enter integer");
                }
            }

            System.out.println("please initnals car positionY ");
            while (in.hasNext()) {
                try {
                    driverless.getCarState().setPositionY(Integer.parseInt(in.next()));
                    break;
                }catch ( IllegalArgumentException e ){
                    System.out.println("illegal input");
                    System.out.println("please enter integer");
                }
            }

            System.out.println("please input car of orientation");
            while (in.hasNext()) {
                try {
                    driverless.getCarState().setDirection(in.next().trim().toUpperCase());
                    break;
                }catch ( IllegalArgumentException e ){
                    System.out.println("illegal input");
                    System.out.println("please input NORTH,EAST,SOUTH or WEST.");
                }
            }
    }
    public static void movdByCtrl(Scanner in,Driverless driverless) {
        System.out.println("input \"TURN\" or integer");
        while (in.hasNext()){
            String command = in.next().trim();
            try {
                driverless.move(command);
            }catch (NumberFormatException e) {
                System.out.println("illegal command");
                System.out.println("Please input \"TURN\" or integer");
                continue;
            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                break;
            }
        }
    }

}