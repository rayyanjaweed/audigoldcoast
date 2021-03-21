package com.rays.autogallery.audigoldcoast.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.autogallery.audigoldcoast.model.User;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<User> findAllUsers() {
		return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<User>(User.class));
	}

	public User findUserByCarId(long userId) {
		return jdbcTemplate.queryForObject("SELECT * FROM users WHERE userId=" + userId,
				new BeanPropertyRowMapper<User>(User.class));
	}

	public Boolean deleteUser(long userId) {
		int n = jdbcTemplate.update("DELETE FROM users WHERE userId=" + userId);
		return (n == 1) ? true : false;
	}

	public long addUser(User user) {
		long id = 0;
		int n = jdbcTemplate.update("INSERT INTO  users (lastName, firstName, email, city) VALUES (?, ?, ?, ?)",
				user.getLastName(), user.getFirstName(), user.getEmail(), user.getCity());

		if (n == 1)
			id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
		return id;
	}

}
