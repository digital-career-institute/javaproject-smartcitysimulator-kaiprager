package com.smartcity.smartcity;

public class Vehicle {
    private String vehicleType;
    private String registrationNumber;
    private double currentSpeed = 0;

    public Vehicle(String vehicleType, String registrationNumber, double currentSpeed) {
       super();
       this.vehicleType = vehicleType;
       this.registrationNumber = registrationNumber;
       this.currentSpeed = currentSpeed;
    }

    public void accelerate(double speedIncrease) {
    	if(speedIncrease > 0) {
    		currentSpeed += speedIncrease;
    	}
    }

    public void brake(double speedDecrease) {
       if(speedDecrease > 0) {
    	   if(currentSpeed - speedDecrease < 0) {
    		   currentSpeed = 0;
    	   } else {
    		   currentSpeed -= speedDecrease;
    	   }
       }
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
      return "Vehicle Type: " + vehicleType + " Registration Number: " + registrationNumber
    		  + " Current Speed: " + currentSpeed;
    }
}

