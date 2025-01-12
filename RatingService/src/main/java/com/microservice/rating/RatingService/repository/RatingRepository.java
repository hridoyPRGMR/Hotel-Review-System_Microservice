package com.microservice.rating.RatingService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.rating.RatingService.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating,String> {
	
	List<Rating>findByUserId(String userid);
	List<Rating>findByHotelId(String hotelId);
	
}
