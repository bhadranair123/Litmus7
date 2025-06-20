
import java.util.Scanner;

public class Vehicle {

	protected String brand;
	protected String model;
	protected double rentalPricePerDay;

	protected Vehicle() {
		this.brand = "Unknown";
		this.model = "Unknown";
		this.rentalPricePerDay = 0.0;
	}

	protected Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	protected void inputDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter brand: ");
		brand = scanner.nextLine();
		System.out.println("Enter model: ");
		model = scanner.nextLine();
		System.out.println("Enter rental price per day: ");
		rentalPricePerDay = scanner.nextDouble();
		scanner.nextLine();
	}

	protected void displayDetails() {
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Rental Price / Day " + rentalPricePerDay);
	}
}
