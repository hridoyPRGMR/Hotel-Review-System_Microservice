package com.microservice.user.service.UserService.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.service.UserService.entities.Hotel;
import com.microservice.user.service.UserService.entities.Rating;
import com.microservice.user.service.UserService.entities.User;
import com.microservice.user.service.UserService.exception.ResourceNotFoundException;
import com.microservice.user.service.UserService.external.services.HotelService;
import com.microservice.user.service.UserService.external.services.RatingService;
import com.microservice.user.service.UserService.repository.UserRep;
import com.microservice.user.service.UserService.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRep userRep;
	private RestTemplate restTemplate;
	private HotelService hotelService;
	private RatingService ratingService;
	
	UserServiceImpl(UserRep userRep,RestTemplate restTemplate,HotelService hotelService,RatingService ratingService){
		this.userRep = userRep;
		this.restTemplate = restTemplate;
		this.hotelService = hotelService;
		this.ratingService = ratingService;
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
		
//		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
//		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		
		List<Rating>ratings = ratingService.getRatingByUserId(user.getUserId());
		
		List<Rating> ratingList = ratings.stream().map(rating->{
		
//			ResponseEntity<Hotel> response = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//			Hotel hotel = response.getBody();	
			
			//using feign client
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			
//			logger.info("{}",response);
			
			rating.setHotel(hotel);
			return rating;
		})
		.collect(Collectors.toList());
		
		user.setRatings(ratingList);
		
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
