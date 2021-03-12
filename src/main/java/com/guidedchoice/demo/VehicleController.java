package com.guidedchoice.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
    private final VehicleRepository vehicleRepository;
    
    VehicleController(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    
    @GetMapping("/vehicles")
    List<Vehicle> all() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }
    
    @GetMapping("/vehicles/{id}")
    Vehicle one(@PathVariable Long id) {
        return vehicleRepository.findById(id)
            .orElseThrow(() -> new VehicleNotFoundException(id));
    }
    
    @PostMapping("/vehicles")
    @ResponseStatus(HttpStatus.CREATED)
    Vehicle newVehicle(@RequestBody Vehicle newVehicle) {
        if(ValidationServices.validateVehicle(newVehicle)) {
            return vehicleRepository.save(newVehicle);
        }
        throw new VehicleNotValidException();
    }
    
    @PutMapping("/vehicles/{id}")
    Vehicle replaceVehicle(@RequestBody Vehicle newVehicle, @PathVariable Long id) {
        return vehicleRepository.findById(id)
            .map(vehicle -> {
                vehicle.setMake(newVehicle.getMake());
                vehicle.setModel(newVehicle.getModel());
                vehicle.setYear(newVehicle.getYear());
                return vehicleRepository.save(vehicle);
            })
            .orElseGet( () -> {
                newVehicle.setId(id);
                return vehicleRepository.save(newVehicle);
            });
    }
    
    @DeleteMapping("/vehicles/{id}")
    void deleteVehicle(@PathVariable Long id) {
        vehicleRepository.deleteById(id);
    }
}
