package com.microservice.rating.RatingService.services;

import java.util.List;

import com.microservice.rating.RatingService.entities.Rating;

public interface RatingService {
	
	//create
	Rating createRating(Rating rating);
	
	//get all user rating
	List<Rating> getRatingByUserId(String userid);
	
	//get all rating by hotel
	List<Rating> getRatingByHotelId(String hotelId);
	
	//get all rating
	List<Rating> getAllRating();
	
}
