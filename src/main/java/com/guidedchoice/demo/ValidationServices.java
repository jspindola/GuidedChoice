package com.guidedchoice.demo;

public class ValidationServices {
    public static final int MIN_YEAR = 1950;
    public static final int MAX_YEAR = 2050;
    
    public static boolean validateVehicle(Vehicle vehicle) {
        if (validateMake(vehicle.getMake()) && validateModel(vehicle.getModel()) && validateYear(vehicle.getYear())) {
            return true;
        }
        return false;
    }
    
    public static boolean validateMake(String make) {
        if ((make != null) && (make.length() > 0)) {
            return true;
        }
        return false;
    }
    
    public static boolean validateModel(String model) {
        if ((model != null) && (model.length() > 0)) {
            return true;
        }
        return false;
    }
    
    public static boolean validateYear(int year) {
        if ((year < MIN_YEAR) || (year > MAX_YEAR) ) {
            return false;
        }
        return true;
        }

}
