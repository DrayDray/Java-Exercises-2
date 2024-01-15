package org.example.inheritance.vehicle.data;

import org.example.inheritance.vehicle.Vehicle;

public class Motorcycle extends Vehicle {
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
