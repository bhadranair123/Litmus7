package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean isAutomatic;

	private Car() {
		this("Honda", "Civic", 1400, 4, false);

	}

	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	@Override
	public String toString() {
		return "Car," + getBrand() + "," + getModel() + "," + String.valueOf(getRentalPricePerDay()) + ","
				+ String.valueOf(numberOfDoors) + "," + String.valueOf(isAutomatic);
	}

}
