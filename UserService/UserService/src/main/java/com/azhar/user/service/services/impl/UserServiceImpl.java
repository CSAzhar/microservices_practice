package com.azhar.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.azhar.user.service.entity.Hotel;
import com.azhar.user.service.entity.Rating;
import com.azhar.user.service.entity.User;
import com.azhar.user.service.external.services.HotelService;
import com.azhar.user.service.repository.UserRepositiry;
import com.azhar.user.service.services.UserServices;
import com.azhar.user.service.services.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserServices{
	
	@Autowired
	private UserRepositiry userRepositiry;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepositiry.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return (List<User>) userRepositiry.findAll();
	}

	
	
	@Override
	public User getUser(String userId) {
		//get user from database
		User user =  userRepositiry.findById(userId).orElseThrow( () -> 
												new ResourceNotFoundException("User with given id is not found on server !!"+ userId) );
		//get rating from userid
		Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+userId, Rating[].class);
		logger.info("{} ", ratingOfUser);
		
		List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
		
		List<Rating> ratingList = ratings.stream().map( rating -> {
			//api call to hotel service to get the hotel
			ResponseEntity<Hotel> forEntity = 
					restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
			
					//assign hotel using Template
			//Hotel hotel = forEntity.getBody();
					
					//assign hotel to hotel object using Feign client objcet that us hotelService
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			//set hotel to ratingreturn the rating
			rating.setHotel(hotel);
			return rating;
			
		}).collect(Collectors.toList());
		
		user.setRatings(ratings);
		return user;
	}
	
	
	

}
