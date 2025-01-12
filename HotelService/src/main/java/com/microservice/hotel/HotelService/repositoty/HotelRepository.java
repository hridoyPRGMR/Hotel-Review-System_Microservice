package com.microservice.hotel.HotelService.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.hotel.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
