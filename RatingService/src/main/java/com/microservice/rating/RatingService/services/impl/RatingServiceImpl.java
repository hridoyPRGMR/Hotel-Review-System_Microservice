package com.microservice.rating.RatingService.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.rating.RatingService.entities.Rating;
import com.microservice.rating.RatingService.repository.RatingRepository;
import com.microservice.rating.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	private RatingRepository ratingRep;
	
	RatingServiceImpl(RatingRepository ratingRep){
		this.ratingRep=ratingRep;
	}
	
	@Override
	public Rating createRating(Rating rating) {
		return ratingRep.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserId(String userid) {
		return ratingRep.findByUserId(userid);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRep.findByHotelId(hotelId);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRep.findAll();
	}

}
