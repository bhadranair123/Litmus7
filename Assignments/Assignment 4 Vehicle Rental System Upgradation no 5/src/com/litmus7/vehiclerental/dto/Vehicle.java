package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

public class Vehicle {

	private String brand;
	private String model;
	private double rentalPricePerDay;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	public void setRentalPricePerDay(double rentalPricePerDay) {
		this.rentalPricePerDay = rentalPricePerDay;
	}

	private Vehicle() {
		this.brand = "Unknown";
		this.model = "Unknown";
		this.rentalPricePerDay = 0.0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Vehicle vehicle = (Vehicle) obj;
		return model != null && model.equals(vehicle.getModel());
	}

	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	@Override
	public String toString() {
		return "Vehicle," + brand + "," + model + "," + String.valueOf(rentalPricePerDay);
	}

}