package com.litmus7.vehiclerental.service;

import java.util.List;
import java.util.Objects;

import com.litmus7.vehiclerental.dto.Response;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.dao.VehicleFileDao;
import com.litmus7.vehiclerental.exception.VehicleServiceException;
import com.litmus7.vehiclerental.exception.VehicleDataAccessException;

public class VehicleService {
	protected List<Vehicle> vehicles;
	VehicleFileDao vehicleFileDao = new VehicleFileDao();

	public List<Vehicle> dataFromFile() throws VehicleServiceException {

		try {
			vehicles = vehicleFileDao.loadVehicles();
		} catch (VehicleDataAccessException e) {
			throw new VehicleServiceException(e.getMessage(), e);
		}
		return vehicles;
	}

	public String addNewVehicles(Vehicle vehicle) throws VehicleServiceException {
		if (!vehicles.contains(vehicle)) {
			try {
//			vehicles.add(vehicle);
				vehicleFileDao.storeVehicles(vehicle);
				return "Vehicle added successfully";
			} catch (VehicleDataAccessException e) {
				throw new VehicleServiceException("Failed to load the database " + e.getMessage());
			}
		}
		throw new VehicleServiceException("Vehicle already exists");
	}

	public List<Vehicle> displayAllVehicles() throws VehicleServiceException {
		List<Vehicle> vehicles = dataFromFile();
		return vehicles;
	}

	public Response<Object> vehicleSearch(String name) throws VehicleServiceException {
		Response response = new Response();
		List<Vehicle> vehicles = dataFromFile();
		for (Vehicle vehicle : vehicles)
			if ((vehicle.getBrand()).equals(name) || (vehicle.getModel()).equals(name)) {
				response.setData(vehicle);
			}
		response.setErrorCode("Could not load Vehicle data");
		return response;
	}

	public String totalRentalPrice() throws VehicleServiceException {
		List<Vehicle> vehicles = dataFromFile();
		double sum = 0;
		for (Vehicle vehicle : vehicles)
			sum += vehicle.getRentalPricePerDay();
		return "Total rental price: " + sum;
	}

}
