package com.microservice.user.service.UserService.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.service.UserService.entities.User;
import com.microservice.user.service.UserService.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	UserController(UserService userService){
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User newUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId)
	{
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> users = userService.getAllUser();
		return ResponseEntity.ok(users);
	}
	
}
