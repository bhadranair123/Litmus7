package com.litmus7.vehicle.rental;

import com.litmus7.vehicle.rental.dto.Vehicle;
import com.litmus7.vehicle.rental.dto.Car;
import com.litmus7.vehicle.rental.dto.Bike;
import com.litmus7.vehicle.rental.service.Service;

public class VehicleApp {
	public static void main(String args[]) {
//		Car car1 = new Car();
//		car1.inputDetails();
//
//		Car car2 = new Car();
//
//		Car car3 = new Car("Toyota", "Corolla", 1200.0, 4, true);
//
//		Bike bike1 = new Bike();
//		bike1.inputDetails();
//
//		Bike bike2 = new Bike();
//
//		Bike bike3 = new Bike("Yamaha", "FZ", 800.0, true, 150);
//
//		car1.displayDetails();
//		car2.displayDetails();
//		car3.displayDetails();
//		bike1.displayDetails();
//		bike2.displayDetails();
//		bike3.displayDetails();

		Service service = new Service();
		service.loadVehicles();
		Bike bike4 = new Bike("Yamaha", "FZ", 800.0, true, 150);
		service.addNewVehicles(bike4);
		service.displayAllVehicles();
		service.vehicleSearch("Toyota");
		System.out.println(service.totalRentalPrice());
	}

}
