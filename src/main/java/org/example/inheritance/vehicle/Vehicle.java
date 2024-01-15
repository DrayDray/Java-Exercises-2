package org.example.inheritance.vehicle;

public abstract class Vehicle {

    private int make;
    private String model;
    private int year;
    private FuelType fuelType;

    public abstract int calculateFuelEfficiency();
    public abstract int distanceTraveled();
    public abstract int maxSpeed();

    public Vehicle(){

    }
    public Vehicle(int make, String model, int year, FuelType fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    public int getMake() {
        return make;
    }

    public void setMake(int make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
}
