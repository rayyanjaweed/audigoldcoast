package com.rays.autogallery.audigoldcoast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rays.autogallery.audigoldcoast.model.Car;
import com.rays.autogallery.audigoldcoast.service.CarService;

@RestController
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping(path="/cars/{carId}" )
	public Car getCar(@PathVariable String carId) {
		long id = Long.parseLong(carId);
		return carService.getCarByCarId(id);
	}
	
	@GetMapping(path="/cars" )
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path="/cars")
	@ResponseStatus(HttpStatus.CREATED)
	public long addCar(@RequestBody Car car) {
		return carService.addNewCar(car);
	}
	
	@DeleteMapping(path="/cars/{carId}")
	public Boolean deleteCar(@PathVariable String carId) {
		long id = Long.parseLong(carId);
		return carService.deleteCar(id);
	}

}
