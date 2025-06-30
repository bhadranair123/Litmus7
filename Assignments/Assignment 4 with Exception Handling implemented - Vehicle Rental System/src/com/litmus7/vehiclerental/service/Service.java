package com.litmus7.vehiclerental.service;

import java.util.List;
import java.util.Objects;

import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.dao.VehicleFileDao;
import com.litmus7.vehiclerental.exception.ServiceException;
import com.litmus7.vehiclerental.exception.DataAccessException;

public class Service {
	protected List<Vehicle> vehicles;

	public List<Vehicle> dataFromFile() throws ServiceException {
		try {
			vehicles = VehicleFileDao.loadVehicles();
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return vehicles;
	}

	public String addNewVehicles(Vehicle vehicle) throws ServiceException, DataAccessException {
		if (!vehicles.contains(vehicle)) {
//			vehicles.add(vehicle);
			VehicleFileDao.storeVehicles(vehicle);
			return "Vehicle added successfully";
		}
		throw new ServiceException("Vehicle already exists");
	}

	public List<Vehicle> displayAllVehicles() throws ServiceException {
		List<Vehicle> vehicles = dataFromFile();
		return vehicles;
	}

	public String vehicleSearch(String name) throws ServiceException {
		List<Vehicle> vehicles = dataFromFile();
		for (Vehicle vehicle : vehicles)
			if ((vehicle.getBrand()).equals(name) || (vehicle.getModel()).equals(name)) {
				System.out.println("Vehicle found: " + vehicle);
				return vehicle.toString();
			}
		return "Vehicle not found";

	}

	public String totalRentalPrice() throws ServiceException {
		List<Vehicle> vehicles = dataFromFile();
		double sum = 0;
		for (Vehicle vehicle : vehicles)
			sum += vehicle.getRentalPricePerDay();
		return "Total rental price: " + sum;
	}

}
