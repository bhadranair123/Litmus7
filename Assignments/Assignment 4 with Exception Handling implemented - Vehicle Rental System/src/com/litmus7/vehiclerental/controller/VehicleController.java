package com.litmus7.vehiclerental.controller;

import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.service.Service;
import com.litmus7.vehiclerental.dao.VehicleFileDao;
import com.litmus7.vehiclerental.dto.Response;
import com.litmus7.vehiclerental.exception.DataAccessException;
import com.litmus7.vehiclerental.exception.ServiceException;

import java.util.List;
import java.io.File;

public class VehicleController {
	private Service service = new Service();

	public String addNewVehicles(Vehicle vehicle) throws ServiceException, DataAccessException {
		String response = null;
		if (vehicle != null) {
			response = service.addNewVehicles(vehicle);
		}
		return response;
	}

	public String vehicleSearch(String name) throws ServiceException {
		String response = null;
		if (name != null) {
			response = service.vehicleSearch(name);
		}
		return response;
	}

	public Response dataFromFile() {
		final int SUCCESS_STATUS_CODE = 200;
		final int ERROR_STATUS_CODE = 204;
		Response response = new Response();
		List<Vehicle> vehicles = null;
		try {
			vehicles = service.dataFromFile();
			response.setStatusCode(SUCCESS_STATUS_CODE);
			response.setVehicles(vehicles);
		} catch (ServiceException e) {
//			handle exception
			response.setStatusCode(ERROR_STATUS_CODE);
			response.setErrorCode("Could not load Vehicle data");
		}
		return response;

	}
}
