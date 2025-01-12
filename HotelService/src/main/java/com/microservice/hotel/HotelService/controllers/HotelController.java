package com.microservice.hotel.HotelService.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hotel.HotelService.entities.Hotel;
import com.microservice.hotel.HotelService.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	private HotelService hotelService;
	
	HotelController(HotelService hotelService){
		this.hotelService = hotelService;
	}
	
	//create
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hotelId));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		return ResponseEntity.ok(hotelService.getAllHotel());
	}
	
}
