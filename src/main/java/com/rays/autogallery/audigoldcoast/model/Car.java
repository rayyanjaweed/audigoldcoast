package com.rays.autogallery.audigoldcoast.model;

public class Car {
	
	private long carId;
	private long mileage;
	private String name;
	private String make;
	private String model;
	private String type;
	
	public Car() {
		
	}
	public Car(long carId, long mileage, String name, String make, String model, String type) {
		this.carId = carId;
		this.mileage = mileage;
		this.name = name;
		this.make = make;
		this.model = model;
		this.type = type;
	}
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public long getMileage() {
		return mileage;
	}
	public void setMileage(long mileage) {
		this.mileage = mileage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
