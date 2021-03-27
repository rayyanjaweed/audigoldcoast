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

import com.rays.autogallery.audigoldcoast.model.User;
import com.rays.autogallery.audigoldcoast.service.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping(path="/users/{userId}")
	public User getUserById(@PathVariable long userId) {
		return userService.getUserById(userId);
	}
	
	@DeleteMapping(path="/users/{userId}")
	public Boolean deleteUser(@PathVariable long userId) {
		return userService.deleteUser(userId);
	}
	
	@PostMapping(path="/users")
	@ResponseStatus(HttpStatus.CREATED)
	public long addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

}
