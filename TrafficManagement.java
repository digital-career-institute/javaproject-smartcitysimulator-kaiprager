package com.smartcity.smartcity;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

enum TrafficLight {

	RED, YELLOW, GREEN;

}

public class TrafficManagement implements Runnable {

	private List<Vehicle> vehicles = new ArrayList<>(List.of(new Vehicle("Car", "B-VB-2345", 0),
			new Vehicle("Bus", "B-VC-5623", 0), new Vehicle("Truck", "B-MN-1534", 0)));

	private static String pathName = "src/main/resources/";
	private String fileName = "traffic_data.csv";

	public void run() {

		try {

			// Read traffic data from CSV
			fileWriterAllVehicles(vehicles, fileName);

			fileReaderVehicle(vehicles, fileName);

			// Implement traffic management logic using collections
			moveVehicle(vehicles, "B-VC-5623", "Green");
			moveVehicle(vehicles, "B-MN-1534", "Red");
			moveVehicle(vehicles, "B-VB-2345", "Green");

			Thread.sleep(3000);

			moveVehicle(vehicles, "B-VC-5623", "Red");
			moveVehicle(vehicles, "B-MN-1534", "Green");
			moveVehicle(vehicles, "B-VB-2345", "Red");

		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Handle exceptions for I/O operations
	}

	public void moveVehicle(List<Vehicle> vehicles, String registrationNaumber, String trafficLight)
			throws IOException {
		Vehicle v = null;
		for (Vehicle veh : vehicles) {
			if (registrationNaumber.equalsIgnoreCase(veh.getRegistrationNumber())) {
				v = veh;
			}
		}

		if (v != null) {

			if (trafficLight.equalsIgnoreCase(TrafficLight.RED.toString())) {
				System.out.println(v.getRegistrationNumber() + " braking....");
				v.brake(50);
				System.out.println("Vehicle stopped at the traffic lights...");

			} else if (trafficLight.equalsIgnoreCase(TrafficLight.GREEN.toString())) {
				System.out.println(v.getRegistrationNumber() + " accelerating....");
				v.accelerate(50);
				System.out.println("Vehicle leaving the traffic lights...");
			}

			fileWriterVehicle(v, fileName);

		} else {
			System.out.println("Vehicle not found!");
		}
	}

	public void fileWriterVehicle(Vehicle vehicle, String fileName) throws IOException {
		File file = new File(fileName);

		FileWriter outputFile = new FileWriter(pathName + file, true);

		CSVWriter writer = new CSVWriter(outputFile);

		String[] data = { vehicle.getVehicleType(), vehicle.getRegistrationNumber(),
				String.valueOf(vehicle.getCurrentSpeed()) };
		writer.writeNext(data);

		writer.close();
	}

	public List<Vehicle> fileReaderVehicle(List<Vehicle> vehicles, String fileName)
			throws IOException, CsvValidationException {
		vehicles = new ArrayList<Vehicle>();

		FileReader inputFile = new FileReader(pathName + fileName);

		CSVReader reader = new CSVReader(inputFile);
		String[] nextLine;

		while ((nextLine = reader.readNext()) != null) {
			Vehicle vehicle = new Vehicle(nextLine[0], nextLine[1], Double.parseDouble(nextLine[2]));
			vehicles.add(vehicle);

		}

		reader.close();

		return vehicles;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	// Updates the file overwriting all data in the file
	public void fileWriterAllVehicles(List<Vehicle> arrVehicles, String fileName) throws IOException {
		List<String[]> arr = new ArrayList<String[]>();
		File file = new File(fileName);

		FileWriter outputFile = new FileWriter(pathName + file, true);

		CSVWriter writer = new CSVWriter(outputFile);

		for (Vehicle vehicle : arrVehicles) {
			String[] data = { vehicle.getVehicleType(), vehicle.getRegistrationNumber(),
					String.valueOf(vehicle.getCurrentSpeed()) };
			arr.add(data);
		}
		writer.writeAll(arr);

		writer.close();
	}

}