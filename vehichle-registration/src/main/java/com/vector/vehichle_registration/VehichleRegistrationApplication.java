package com.vector.vehichle_registration;

import com.vector.vehichle_registration.factory.VehicleFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehichleRegistrationApplication {

	public static void main(String[] args) {
//		SpringApplication.run(VehichleRegistrationApplication.class, args);

		VehicleFactory vehicleFactory = new VehicleFactory();
		vehicleFactory.createRegistry("car123456", "car");
		vehicleFactory.createRegistry("bike123456", "bike");
		vehicleFactory.createRegistry("truck123456", "truck");

		System.out.println(vehicleFactory.getAllVehicles());
	}

}
