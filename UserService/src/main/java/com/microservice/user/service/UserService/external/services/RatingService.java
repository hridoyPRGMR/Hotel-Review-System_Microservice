package com.microservice.user.service.UserService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.microservice.user.service.UserService.entities.Rating;

@FeignClient(name="RATINGSERVICE")
public interface RatingService {

	@PostMapping("/ratings")
	Rating create(Rating rating);
	
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable String ratingId,Rating rating);
	
	@DeleteMapping("/ratings/{ratingId}")
	void deleteRating(@PathVariable String ratingId);
	
	@GetMapping("ratings/users/{userId}")
	List<Rating> getRatingByUserId(@PathVariable String userId);
	
}
