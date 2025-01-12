package com.microservice.user.service.UserService.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.service.UserService.entities.Rating;
import com.microservice.user.service.UserService.entities.User;
import com.microservice.user.service.UserService.exception.ResourceNotFoundException;
import com.microservice.user.service.UserService.repository.UserRep;
import com.microservice.user.service.UserService.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRep userRep;
	private RestTemplate restTemplate;
	
	UserServiceImpl(UserRep userRep,RestTemplate restTemplate){
		this.userRep = userRep;
		this.restTemplate = restTemplate;
	}
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) 
	{
		String randomUserId  = UUID.randomUUID().toString();//generate unique id
		user.setUserId(randomUserId);
		return userRep.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRep.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRep.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+userId));
		
		ArrayList<Rating> ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
		user.setRatings(ratings);
		
		return user;
	}

	@Override
	public User updateUser(User user) {
		return null;
	}

	@Override
	public boolean DeleteUser(String userId) {
		return false;
	}

}
