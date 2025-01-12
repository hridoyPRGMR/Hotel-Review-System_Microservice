package com.microservice.user.service.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.user.service.UserService.entities.User;

public interface UserRep extends JpaRepository<User, String> {
	
	
	
}
