package com.guidedchoice.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger LOG = LoggerFactory.getLogger(LoadDatabase.class);
    
    @Bean
    CommandLineRunner initDatabase(VehicleRepository vehicleRepository) {
        return args -> {
            LOG.info("Preloading " + vehicleRepository.save(new Vehicle(2018, "Tesla", "VX100")));
            LOG.info("Preloading " + vehicleRepository.save(new Vehicle(2020, "Maserati", "Quattroporte")));
            LOG.info("Preloading " + vehicleRepository.save(new Vehicle(1999, "Toyota", "Corolla")));
            LOG.info("Preloading " + vehicleRepository.save(new Vehicle(1995, "Toyota", "Camry")));
            LOG.info("Preloading " + vehicleRepository.save(new Vehicle(2020, "Honda", "CV-R")));
        };
    }

}
