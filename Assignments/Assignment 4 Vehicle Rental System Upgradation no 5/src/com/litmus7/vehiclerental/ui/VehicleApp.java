package com.litmus7.vehiclerental.ui;

import com.litmus7.vehiclerental.dto.Bike;
import com.litmus7.vehiclerental.dto.Car;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.exception.VehicleDataAccessException;
import com.litmus7.vehiclerental.exception.VehicleServiceException;
import com.litmus7.vehiclerental.controller.VehicleController;
import java.util.List;
import java.util.ArrayList;
import com.litmus7.vehiclerental.dto.Response;

public class VehicleApp {
	public static void main(String args[]) throws VehicleServiceException, VehicleDataAccessException {

		VehicleController controller = new VehicleController();
		controller.dataFromFile();
		Bike bike4 = new Bike("Yamaha", "FZ", 800.0, true, 150);
		System.out.println(controller.addNewVehicles(bike4));
		Response<Object> response = controller.vehicleSearch("Toyota");
		if ((response.getData()) != (null)) {
			System.out.println(response.getData());
		} else {
			System.out.println("No such vehicle exists");
		}

		System.out.println(controller.totalRentalPrice());
		List<Vehicle> outputList = new ArrayList<>();
		outputList = controller.displayAllVehicles();
		System.out.println("Loading vehicles...");
		for (Vehicle vehicle : outputList)
			System.out.println(vehicle);

	}

}
