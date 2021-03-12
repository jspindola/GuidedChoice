package com.guidedchoice.demo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

//public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {
    List<Vehicle> findByMake(@Param(value = "make") String make);
    List<Vehicle> findByModel(@Param(value = "model") String model);
    List<Vehicle> findByYear(@Param(value= "year") int year);
}
