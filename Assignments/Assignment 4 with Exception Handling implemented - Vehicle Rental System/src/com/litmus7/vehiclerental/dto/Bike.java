package com.litmus7.vehiclerental.dto;

import java.util.Scanner;

public class Bike extends Vehicle {

	private boolean hasGear;
	private int engineCapacity;

	private Bike() {
		this("Suzuki", "Gixer", 600.0, false, 125);

	}

	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;

	}

	@Override
	public String toString() {
		return "Bike," + getBrand() + "," + getModel() + "," + String.valueOf(getRentalPricePerDay()) + ","
				+ String.valueOf(hasGear) + "," + String.valueOf(engineCapacity);
	}

}
