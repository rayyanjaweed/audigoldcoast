package com.rays.autogallery.audigoldcoast.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rays.autogallery.audigoldcoast.model.Car;

@Repository
@Transactional
@Qualifier("JPA")
public class CarJpaDAO implements CarDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Car> findAllCars() {
		TypedQuery<Car> createNamedQuery = entityManager.createNamedQuery("find_all_cars", Car.class);
		return createNamedQuery.getResultList();
	}

	public Car findById(long carId) {
		return entityManager.find(Car.class, carId);
	}

	public long insert(Car car) {
		Car databaseCar;
		databaseCar = entityManager.merge(car);
		return databaseCar.getCarId();
	}

	public boolean deleteyById(long carId) {
		Car car = findById(carId);
		entityManager.remove(car);
		return true;
	}

}
