package com.litmus7.vehicle.rental.dto;

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

//	@Override
//	protected void inputDetails() {
//		System.out.println("--Enter Bike Details--");
//		super.inputDetails();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Does it have gears (true/false)? ");
//		hasGear = scanner.nextBoolean();
//		scanner.nextLine();
//		System.out.println("Enter engine capacity(cc): ");
//		engineCapacity = scanner.nextInt();
//		scanner.nextLine();
//	}
//
//	@Override
//	protected void displayDetails() {
//		System.out.println("--Displaying Bike Details--");
//		super.displayDetails();
//		System.out.println("Has Gear: " + hasGear);
//		System.out.println("Engine Capacity: " + engineCapacity + " cc");
//	}

}
