package com.rays.autogallery.audigoldcoast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="cars")
@NamedQuery(name="find_all_cars", query="select c from Car c")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="carId")
	private long carId;
	@Column(name="mileage")
	private long mileage;
	@Column(name="name")
	private String name;
	@Column(name="make")
	private String make;
	@Column(name="model")
	private String model;
	@Column(name="type")
	private String type;
	
	public Car() {
		
	}
	
	public Car(long mileage, String name, String make, String model, String type) {
		this.mileage = mileage;
		this.name = name;
		this.make = make;
		this.model = model;
		this.type = type;
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
