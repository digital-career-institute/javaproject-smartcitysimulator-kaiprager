package com.smartcity.smartcity;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class SmartLighting implements Runnable {
	
	private Timer timer; 
	private Sensor lightSensor;
	
	public SmartLighting(Sensor lightSensor) {
		super();
		this.timer = new Timer();
		this.lightSensor = new Sensor("Light");
	}
	
	@Override
	public void run() {
       // Implement smart lighting logic
       // Adjust street light brightness based on time and sensor data
		
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				adjustBrightness();
			}
		}, 0, 60 * 1000);
	}
	
	private void adjustBrightness() {
		
		Calendar calendar = Calendar.getInstance();	
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		
		lightSensor.measure();
		double sensorValue = lightSensor.getCurrentValue();
		
		if(isDaytime(hour)) {
			System.out.println("\nDAY TIME: Light switched off.");
		} else {
			System.out.println("\nNIGHT TIME: Street light adjusted to current senor data: " + sensorValue);
		}
		
	}
	
	private boolean isDaytime(int hour) {
		
		return hour >= 7 && hour <= 19;
	}
}