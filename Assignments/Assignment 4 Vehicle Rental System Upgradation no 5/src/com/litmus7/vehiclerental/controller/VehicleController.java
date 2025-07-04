package com.litmus7.vehiclerental.controller;

import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.service.VehicleService;
import com.litmus7.vehiclerental.dao.VehicleFileDao;
import com.litmus7.vehiclerental.dto.Response;
import com.litmus7.vehiclerental.exception.VehicleDataAccessException;
import com.litmus7.vehiclerental.exception.VehicleServiceException;

import java.util.List;
import java.io.File;

public class VehicleController {
	private VehicleService service = new VehicleService();

	public String addNewVehicles(Vehicle vehicle) throws VehicleServiceException {
		String response = null;
		if (vehicle != null) {
			response = service.addNewVehicles(vehicle);
		}
		return response;
	}

	public Response<Object> vehicleSearch(String name) throws VehicleServiceException {
		Response response = new Response();
		if (name != null) {
			response = service.vehicleSearch(name);
		}
		return response;
	}

	public Response<Object> dataFromFile() {
		Response response = new Response();
		final int SUCCESS_STATUS_CODE = 200;
		final int ERROR_STATUS_CODE = 204;
		List<Vehicle> vehicles = null;
		try {
			vehicles = service.dataFromFile();
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setData(vehicles);
		} catch (VehicleServiceException e) {
//			handle exception
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorCode("Could not load Vehicle data");
		}
		return response;

	}

	public String totalRentalPrice() throws VehicleServiceException {
		return service.totalRentalPrice();
	}

	public List<Vehicle> displayAllVehicles() throws VehicleServiceException {
		return service.displayAllVehicles();
	}

}
