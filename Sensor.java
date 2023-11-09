package com.smartcity.smartcity;

import java.util.Random;

public class Sensor {
    private String sensorType;
    private double currentValue;

    public Sensor(String sensorType) {
        this.sensorType = sensorType;
        this.currentValue = 0.0;
    }

    public void measure() {
        // Simulate measuring data by generating random values
        Random rand = new Random();

        if ("Air Quality".equals(sensorType)) {
            currentValue = rand.nextDouble() * 100; // Random value between 0 and 100
        } else if ("Noise Level".equals(sensorType)) {
            currentValue = rand.nextDouble() * 120; // Random value between 0 and 120 (in decibels)
        } else if ("Temperature".equals(sensorType)) {
            currentValue = rand.nextDouble() * 40 - 10; // Random value between -10 and 30 degrees Celsius
        } else if ("Light".equals(sensorType)) {
        	currentValue = rand.nextDouble() * 100;
        }
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public String getSensorType() {
        return sensorType;
    }

    @Override
    public String toString() {
        return "Sensor Type: " + sensorType + " Current Value: " + currentValue;
    }
}
