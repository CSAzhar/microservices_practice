package com.azhar.rating.service;

import java.util.List;

import com.azhar.rating.entity.Rating;

public interface ServiceInterf {
	
	//create
	Rating create(Rating rating);
	
	//get all ratings
	
	List<Rating> getAll();
	
	//get all rating by userId
	List<Rating> getAllByUserId(String userId);
	
	//get all rating by hotelId
	List<Rating> getAllByHotelId(String hotelId);

}
