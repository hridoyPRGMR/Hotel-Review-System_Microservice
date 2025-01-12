package com.microservice.user.service.UserService.services;

import java.util.List;

import com.microservice.user.service.UserService.entities.User;

public interface UserService {
	
	//create
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	//get single user
	User getUser(String userId);
	
	//update user 
	User updateUser(User user);
	
	//delete user
	boolean DeleteUser(String userId);
	
}
