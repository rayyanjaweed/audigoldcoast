package com.rays.autogallery.audigoldcoast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.autogallery.audigoldcoast.dao.CarDAO;
import com.rays.autogallery.audigoldcoast.model.Car;

@Service
public class CarService {
	
	@Autowired
	private CarDAO carDao;
	
	public Car getCarByCarId(long carId) {
		return carDao.findCarByCarId(carId);
	}
	public Car findCarByCarName(String carName) throws Exception {
		if(carName == null || carName.equals(""))
			throw new Exception("Car Name is empty");
		return null;
	}
	public List<Car> getAllCars() {
		return carDao.findAllCars();
	}
	public long addNewCar(Car car) {
		return carDao.addNewCar(car);
	}
	public boolean deleteCar(long carId) {
		return carDao.deleteCar(carId);
	}

}
