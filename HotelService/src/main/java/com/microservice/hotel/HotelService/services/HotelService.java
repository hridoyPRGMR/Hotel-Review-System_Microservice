package com.microservice.hotel.HotelService.services;

import java.util.List;

import com.microservice.hotel.HotelService.entities.Hotel;

public interface HotelService {

	//create
	Hotel create(Hotel hotel);
	
	//get
	Hotel getHotel(String id);
	
	//get all
	List<Hotel> getAllHotel();
}
