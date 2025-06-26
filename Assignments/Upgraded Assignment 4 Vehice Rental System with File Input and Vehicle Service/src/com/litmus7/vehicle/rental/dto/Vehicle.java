package com.litmus7.vehicle.rental.dto;

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

	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	@Override
	public String toString() {
		return "Vehicle," + brand + "," + model + "," + String.valueOf(rentalPricePerDay);
	}

//	protected void inputDetails() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter brand: ");
//		brand = scanner.nextLine();
//		System.out.println("Enter model: ");
//		model = scanner.nextLine();
//		System.out.println("Enter rental price per day: ");
//		rentalPricePerDay = scanner.nextDouble();
//		scanner.nextLine();
//	}
//
//	protected void displayDetails() {
//		System.out.println("Brand: " + brand);
//		System.out.println("Model: " + model);
//		System.out.println("Rental Price / Day " + rentalPricePerDay);
//	}
}