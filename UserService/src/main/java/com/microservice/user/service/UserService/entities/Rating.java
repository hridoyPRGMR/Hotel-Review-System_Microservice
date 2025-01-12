package com.microservice.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

	private String id;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	
}
