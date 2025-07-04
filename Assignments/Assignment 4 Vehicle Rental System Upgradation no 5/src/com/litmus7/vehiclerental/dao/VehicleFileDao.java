package com.litmus7.vehiclerental.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import com.litmus7.vehiclerental.dto.Bike;
import com.litmus7.vehiclerental.dto.Car;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.exception.VehicleDataAccessException;

public class VehicleFileDao {

	private static String filePath = "SampleVehicles.txt";

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		VehicleFileDao.filePath = filePath;
	}

	public List<Vehicle> loadVehicles() throws VehicleDataAccessException {
		List<Vehicle> vehicles = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 6) {
					if (parts[0].equals("Car")) {
						Car vehicle = new Car(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Integer.parseInt(parts[4].trim()), Boolean.parseBoolean(parts[5].trim()));
						vehicles.add(vehicle);
					} else {
						Bike vehicle = new Bike(parts[1].trim(), parts[2].trim(), Double.parseDouble(parts[3].trim()),
								Boolean.parseBoolean(parts[4].trim()), Integer.parseInt(parts[5].trim()));
						vehicles.add(vehicle);
					}

				}
			}
			return vehicles;
		} catch (FileNotFoundException e) {
			System.out.println("Error reading Sample Vehicles file " + e.getLocalizedMessage());
			throw new VehicleDataAccessException(e.getMessage(), e);

		} catch (IOException e) {
			System.out.println("Error reading Sample Vehicles file " + e.getMessage());
			throw new VehicleDataAccessException(e.getMessage(), e);

		}
	}

	public String storeVehicles(Vehicle vehicle) throws VehicleDataAccessException {
		List<Vehicle> vehicles = loadVehicles();
		vehicles.add(vehicle);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
			writer.write(vehicle.toString());
			writer.newLine();
			return "Vehicle added successfully";

		} catch (IOException e) {
			throw new VehicleDataAccessException(e.getMessage(), e);
		}
	}
}
