package com.driverless.exception;

/**
 * custom exception
 *
 */
public class CarOutBorderlineException extends RuntimeException{
    public CarOutBorderlineException(){
        System.out.println("Car Run Out Of Car Park Borderline!");
       // System.out.println("system read to exit");
       // System.exit(0);
    }
}
