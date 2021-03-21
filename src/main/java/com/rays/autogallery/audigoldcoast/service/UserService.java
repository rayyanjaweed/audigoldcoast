package com.rays.autogallery.audigoldcoast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.autogallery.audigoldcoast.dao.UserJdbcDAO;
import com.rays.autogallery.audigoldcoast.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserJdbcDAO userDao;

	public List<User> getAllUsers() {
		return userDao.findAllUsers();
	}

	public User getUserById(long userId) {
		return userDao.findUserByCarId(userId);
	}

	public Boolean deleteUser(long userId) {
		return userDao.deleteUser(userId);
	}

	public long addUser(User user) {
		return userDao.addUser(user);
	}

}
