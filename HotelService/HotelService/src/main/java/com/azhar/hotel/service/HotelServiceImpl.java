package com.azhar.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhar.hotel.entity.Hotel;
import com.azhar.hotel.exceptions.ResourceNotFoundException;
import com.azhar.hotel.repo.HotelRepo;

@Service
public class HotelServiceImpl implements HotelServices{
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Hotel with given id not found"+id) );
	}

}
