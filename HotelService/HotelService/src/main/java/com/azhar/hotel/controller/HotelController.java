package com.azhar.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azhar.hotel.entity.Hotel;
import com.azhar.hotel.service.HotelServiceImpl;

@RestController
@RequestMapping("hotel")
public class HotelController {
	
	@Autowired
	private HotelServiceImpl serviceImpl;
	
	@PostMapping
	public Hotel save(@RequestBody Hotel hotel) {
		return serviceImpl.create(hotel);
	}
	
	@GetMapping
	public List<Hotel> getAll(){
		return serviceImpl.getAll();
	}
	
	@GetMapping("/{hotelId}")
	public Hotel getById(@PathVariable String hotelId) {
		return serviceImpl.get(hotelId);
	}

}
