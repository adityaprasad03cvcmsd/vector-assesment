package com.vector.vehichle_registration.factory;

import com.vector.vehichle_registration.entity.Bike;
import com.vector.vehichle_registration.entity.Car;
import com.vector.vehichle_registration.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleFactory {

    List<Vehicle> vehicles = new ArrayList<>();


    private void createVehicleRegistry(String vehicleNumber, String type){

        Vehicle vehicle = new Vehicle(vehicles.size(), vehicleNumber, type);
        vehicles.add(vehicle);
    }

    private void createCarRegistry(String carNumber){
        Car car = Car.builder().id(vehicles.size()).vehicleNumber(carNumber).color("red").type("car").build();
        vehicles.add(car);
    }

    private void createBikeRegistry(String bikeNumber){
        Bike bike = Bike.builder().id(vehicles.size()).vehicleNumber(bikeNumber).color("blue").type("bike").build();
        vehicles.add(bike);
    }

    public void createRegistry(String number, String type){
        if(type.equals("car")){
            createCarRegistry(number);
        } else if(type.equals("bike")){
            createBikeRegistry(number);
        }else {
            createVehicleRegistry(number, type);
        }
    }

    public List<Vehicle> getAllVehicles(){
        return vehicles;
    }
}
