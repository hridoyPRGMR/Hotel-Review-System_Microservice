package com.microservice.hotel.HotelService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="hotels")
public class Hotel {
	
	@Id
	@Column(name="ID", nullable=false)
	private String id;
	
	@Column(name="NAME",nullable=false)
	private String name;
	
	@Column(name="LOCATION",nullable=false)
	private String location;
	
	@Column(name="ABOUT",length=500)
	private String about;
	
}
