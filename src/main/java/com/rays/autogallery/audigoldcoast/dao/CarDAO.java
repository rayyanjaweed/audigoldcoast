package com.rays.autogallery.audigoldcoast.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.autogallery.audigoldcoast.model.Car;

@Repository
public class CarDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	public Car findCarByCarId(long carId) {
		return jdbcTemplate.queryForObject("SELECT * FROM cars WHERE carId=" + carId,
				new BeanPropertyRowMapper<Car>(Car.class));
	}

	public Car findCarByCarName(String carName) {
		if (carName != null && carName.equals("audi")) {
			return new Car(1, 20000, "A7", "Audi", "2019", "Sedan");
		} else
			return new Car(2, 2000, "Aventador", "Lamborghini", "2018", "Sports");
	}

	public List<Car> findAllCars() {
		return jdbcTemplate.query("SELECT * FROM cars", new BeanPropertyRowMapper<Car>(Car.class));
	}

	public long addNewCar(Car car) {
		long id = 0;
		int n = jdbcTemplate.update("INSERT INTO cars (mileage, name, make, model, type) VALUES (?, ?, ?, ?, ?)",
				car.getMileage(), car.getName(), car.getMake(), car.getModel(), car.getType());
		if(n == 1)
			id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
		
		car.setCarId(id);
		return id;
	}

	public boolean deleteCar(long carId) {
		int n = jdbcTemplate.update("DELETE FROM cars WHERE carId=?", carId);
		return (n==1);
	}

}
