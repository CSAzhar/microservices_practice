package com.azhar.hotel.service;

import java.util.List;

import com.azhar.hotel.entity.Hotel;

public interface HotelServices {
	
	
	Hotel create(Hotel hotel);
	List<Hotel> getAll();
	Hotel get(String id);
	
	

}
