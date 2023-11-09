package com.smartcity.smartcity;

public class SmartCitySimulation {
    public static void main(String[] args) {
        TrafficManagement trafficManagement = new TrafficManagement();
        SmartLighting smartLighting = new SmartLighting(new Sensor("Light"));
        EnvironmentalMonitoring environmentalMonitoring = new EnvironmentalMonitoring();

        // Start simulation components using multithreading
        Thread trafficThread = new Thread(trafficManagement);
        Thread lightingThread = new Thread(smartLighting);
        Thread monitoringThread = new Thread(environmentalMonitoring);

        trafficThread.start();
        lightingThread.start();
        monitoringThread.start();

        // Add exception handling for each component
        try {
            trafficThread.join();
            lightingThread.join();
            monitoringThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}