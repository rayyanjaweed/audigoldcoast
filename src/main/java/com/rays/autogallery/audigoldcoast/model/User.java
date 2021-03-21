package com.rays.autogallery.audigoldcoast.model;

public class User {
	
	private long userId;
	private String lastName;
	private String firstName;
	private String email;
	private String city;
	
	public User() {
	}
	
	public User(String lastName, String firstName, String email, String city) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.city = city;
	}

	public User(long userId, String lastName, String firstName, String email, String city) {
		this.userId = userId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.city = city;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
