package com.guidedchoice.demo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VehicleNotValidAdvice {

    @ResponseBody
    @ExceptionHandler(VehicleNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String vehicleNotValidHandler(VehicleNotValidException ex ) {
        return ex.getMessage();
    }
}
