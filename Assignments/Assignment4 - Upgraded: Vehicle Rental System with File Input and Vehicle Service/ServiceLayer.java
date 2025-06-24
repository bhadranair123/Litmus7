import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class ServiceLayer {
	List<Vehicle> vehicleList=new ArrayList<>();
	public void loadVehicles() {
	try (BufferedReader reader = new BufferedReader(new FileReader ("SampleVehicles.txt"))){
		String line;
		while ((line = reader.readLine())!=null) {
			String[] parts = line.split(",");
			if (parts.length==6) {
				if (parts[0].equals("Car")) {
					Car vehicle = new Car(parts[1].trim(),parts[2].trim(),Double.parseDouble(parts[3].trim()),Integer.parseInt(parts[4].trim()),Boolean.parseBoolean(parts[5].trim()));
					vehicleList.add(vehicle);
				}
				else {
					Bike vehicle = new Bike(parts[1].trim(),parts[2].trim(),Double.parseDouble(parts[3].trim()),Boolean.parseBoolean(parts[4].trim()),Integer.parseInt(parts[5].trim()));
					vehicleList.add(vehicle);
				}
				
			}
			}
			}catch (IOException e) {
				System.out.println("Error reading Sample Vehicles file "+e.getMessage());
			}
		}
	
	public void addNewVehicles(Vehicle vehicle) {
		vehicleList.add(vehicle);
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("SampleVehicles.txt",true))){
				writer.write(vehicle.toString());
				writer.newLine();
			
		}catch (IOException e) {
			System.out.println("Error writing into Sample Vehicles file "+e.getMessage());
		}
	}
	
	public void displayAllVehicles(){
		for (Vehicle vehicle:vehicleList) {
			System.out.println(vehicle);
		}
	}
	
	public void vehicleSearch(String name) {
		for (Vehicle vehicle:vehicleList)
		if ((vehicle.brand).equals(name) || (vehicle.model).equals(name)){
			System.out.println( vehicle);
		}
	}
	
	public double totalRentalPrice() {
		double sum =0;
		for (Vehicle vehicle:vehicleList)
			sum+=vehicle.rentalPricePerDay; 
		return sum;
	}
	
	}
