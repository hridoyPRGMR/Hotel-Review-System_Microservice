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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

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
	@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod="ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable String userId)
	{
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	//creating fallback method for circuitbreaker
	public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
		
		User user = User.builder()
				.email("dummy@gmail.com")
				.name("Dummy")
				.about("Dummy User created, cause some service is down.")
				.build();
		
//		logger.inf()
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> users = userService.getAllUser();
		return ResponseEntity.ok(users);
	}
	
}
