package com.guidedchoice.demo;

public class VehicleNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    VehicleNotFoundException(Long id) {
        super("Could not find vehicle " + id);
    }
}
