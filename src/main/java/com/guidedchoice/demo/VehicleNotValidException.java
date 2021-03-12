package com.guidedchoice.demo;

public class VehicleNotValidException extends RuntimeException{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1941555728044255488L;

    VehicleNotValidException() {
        super("Is not a valid vehicle.");
    }

}
