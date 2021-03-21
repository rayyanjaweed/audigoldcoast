package com.rays.autogallery.audigoldcoast.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rays.autogallery.audigoldcoast.model.Car;

public class CarJdbcDAOTest {
	
	CarJdbcDAO cdao;
	Car audi;
	
	@Before
	public void intialize() {
		cdao = new CarJdbcDAO();
//		audi = cdao.findCarByCarName("audi");
	}
	

	@Test
	public void findCarByCarNameTest() {
		Car expected = new Car(1,20000,"A7","Audi","2019","Sedan");
		assertNotEquals(audi, expected);
		assertEquals(expected.getCarId(), audi.getCarId());
		assertEquals(expected.getMake(), audi.getMake());
		assertEquals(expected.getMileage(), audi.getMileage());
		assertEquals(expected.getModel(), audi.getModel());
		assertEquals(expected.getName(), audi.getName());
		assertEquals(expected.getType(), audi.getType());
	}
	
	public void deleteCarTest() {
		assertFalse(cdao.deleteyById(1));
	}

}