package com.microservice.hotel.HotelService.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> notFoundHanlder(ResourceNotFoundException exception){
		Map map=new HashMap<>();
		map.put("message",exception.getMessage());
		map.put("status",false);
		map.put("status",HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
}
