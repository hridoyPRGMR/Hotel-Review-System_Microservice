package com.microservice.rating.RatingService.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.rating.RatingService.entities.Rating;
import com.microservice.rating.RatingService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	private RatingService ratingService;
	
	RatingController(RatingService ratingService){
		this.ratingService = ratingService;
	}
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		return ResponseEntity.ok(ratingService.getAllRating());
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}
}
