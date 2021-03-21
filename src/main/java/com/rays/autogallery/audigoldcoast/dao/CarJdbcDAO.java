package com.rays.autogallery.audigoldcoast.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.autogallery.audigoldcoast.model.Car;

@Repository
@Qualifier("JDBC")
public class CarJdbcDAO implements CarDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Car> findAllCars() {
		return jdbcTemplate.query("SELECT * FROM cars", new BeanPropertyRowMapper<Car>(Car.class));
	}

	public Car findById(long carId) {
		return jdbcTemplate.queryForObject("SELECT * FROM cars WHERE carId=" + carId,
				new BeanPropertyRowMapper<Car>(Car.class));
	}

	public long insert(Car car) {
		long id = 0;
		int n = jdbcTemplate.update("INSERT INTO cars (mileage, name, make, model, type) VALUES (?, ?, ?, ?, ?)",
				car.getMileage(), car.getName(), car.getMake(), car.getModel(), car.getType());
		if(n == 1)
			id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
		
		car.setCarId(id);
		return id;
	}

	public boolean deleteyById(long carId) {
		int n = jdbcTemplate.update("DELETE FROM cars WHERE carId=?", carId);
		return (n==1);
	}

}
