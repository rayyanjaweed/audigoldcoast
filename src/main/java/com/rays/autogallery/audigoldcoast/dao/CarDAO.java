package com.rays.autogallery.audigoldcoast.dao;

import java.util.List;

import com.rays.autogallery.audigoldcoast.model.Car;

public interface CarDAO {

	public List<Car> findAllCars();
	
	public Car findById(long carId);

	public long insert(Car car);

	public boolean deleteyById(long carId);

}
