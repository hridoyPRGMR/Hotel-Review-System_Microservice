package com.microservice.rating.RatingService.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document("user_ratings")
public class Rating {
	
	@Id
	private String id;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
