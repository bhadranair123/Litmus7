package com.litmus7.vehiclerental.ui;

import com.litmus7.vehiclerental.dto.Bike;
import com.litmus7.vehiclerental.dto.Car;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.exception.DataAccessException;
import com.litmus7.vehiclerental.exception.ServiceException;
import com.litmus7.vehiclerental.service.Service;
import java.util.List;
import java.util.ArrayList;

public class VehicleApp {
	public static void main(String args[]) throws ServiceException, DataAccessException {

		Service service = new Service();
		service.dataFromFile();
		Bike bike4 = new Bike("Yamaha", "FZ", 800.0, true, 150);
		System.out.println(service.addNewVehicles(bike4));
		System.out.println(service.vehicleSearch("Toyota"));
		System.out.println(service.totalRentalPrice());
		List<Vehicle> outputList = new ArrayList<>();
		outputList = service.displayAllVehicles();
		System.out.println("Loading vehicles...");
		for (Vehicle vehicle : outputList)
			System.out.println(vehicle);

	}

}
