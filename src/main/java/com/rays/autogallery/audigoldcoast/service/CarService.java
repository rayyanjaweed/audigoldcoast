package com.rays.autogallery.audigoldcoast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rays.autogallery.audigoldcoast.dao.CarDAO;
import com.rays.autogallery.audigoldcoast.model.Car;

@Service
public class CarService {
	
	@Autowired
	@Qualifier("JPA")
	private CarDAO carDao;
	
	public Car getCarByCarId(long carId) {
		return carDao.findById(carId);
	}
	
	public List<Car> getAllCars() {
		return carDao.findAllCars();
	}
	
	public long addNewCar(Car car) {
		return carDao.insert(car);
	}
	
	public boolean deleteCar(long carId) {
		return carDao.deleteyById(carId);
	}

}
