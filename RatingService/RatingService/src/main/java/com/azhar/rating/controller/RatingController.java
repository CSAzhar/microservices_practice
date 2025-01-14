package com.azhar.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azhar.rating.entity.Rating;
import com.azhar.rating.service.RatingService;

@RestController
@RequestMapping("rating")
public class RatingController {
	
	@Autowired
	private RatingService service;
	
	@PostMapping
	public ResponseEntity<Rating> save(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getAllByUserId(@PathVariable String userId){
		return ResponseEntity.ok(service.getAllByUserId(userId));
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getAllByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(service.getAllByHotelId(hotelId));
	}
	

}
