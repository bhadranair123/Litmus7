package com.litmus7.vehicle.rental.dto;

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

//	@Override
//	protected void inputDetails() {
//		System.out.println("--Enter Car Details--");
//		super.inputDetails();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter number of doors: ");
//		numberOfDoors = scanner.nextInt();
//		scanner.nextLine();
//		System.out.println("Is it automatic (true/false)? ");
//		isAutomatic = scanner.nextBoolean();
//		scanner.nextLine();
//	}
//
//	@Override
//	protected void displayDetails() {
//		System.out.println("--Displaying Car Details--");
//		super.displayDetails();
//		System.out.println("Number Of Doors: " + numberOfDoors);
//		System.out.println("Automatic: " + isAutomatic);
//	}

}
