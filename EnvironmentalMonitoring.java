package com.smartcity.smartcity;

public class EnvironmentalMonitoring implements Runnable {

	private Sensor sensorAir = new Sensor("Air Quality");
	private Sensor sensorNoise = new Sensor("Noise Level");
	private Sensor sensorTemperature = new Sensor("Temperature");

	public void run() {
		// Implement environmental monitoring logic
		System.out.println(sensorAir.getSensorType());
		System.out.println(sensorAir.getCurrentValue() + "\n");

		System.out.println(sensorNoise.getSensorType());
		System.out.println(sensorNoise.getCurrentValue() + "\n");

		System.out.println(sensorTemperature.getSensorType());
		System.out.println(sensorTemperature.getCurrentValue());

		// Monitor air quality, noise levels, temperature, etc.
	}
}