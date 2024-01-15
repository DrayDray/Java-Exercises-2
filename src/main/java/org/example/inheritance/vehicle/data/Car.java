package org.example.inheritance.vehicle.data;

import org.example.inheritance.vehicle.FuelType;
import org.example.inheritance.vehicle.Vehicle;

public class Car extends Vehicle {

    public Car(){
        super();
    }

    public Car(int make, String model, int year, FuelType fuelType) {
        super(make, model, year, fuelType);
    }

    @Override
    public int calculateFuelEfficiency() {
        return 0;
    }

    @Override
    public int distanceTraveled() {
        return 0;
    }

    @Override
    public int maxSpeed() {
        return 0;
    }
}
