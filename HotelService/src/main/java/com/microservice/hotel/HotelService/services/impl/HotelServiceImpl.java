package com.microservice.hotel.HotelService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservice.hotel.HotelService.entities.Hotel;
import com.microservice.hotel.HotelService.exception.ResourceNotFoundException;
import com.microservice.hotel.HotelService.repositoty.HotelRepository;
import com.microservice.hotel.HotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	private HotelRepository hotelRep;
	
	HotelServiceImpl(HotelRepository hotelRep){
		this.hotelRep = hotelRep;
	}
	
	@Override
	public Hotel create(Hotel hotel) {
		String generatedId = UUID.randomUUID().toString();
		hotel.setId(generatedId);
		return hotelRep.save(hotel);
	}

	@Override
	public Hotel getHotel(String id) {
		return hotelRep.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel not found with id:"+id));
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRep.findAll();
	}
	
}
