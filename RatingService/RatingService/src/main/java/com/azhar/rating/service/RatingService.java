package com.azhar.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhar.rating.entity.Rating;
import com.azhar.rating.repo.RatingRepository;

@Service
public class RatingService implements ServiceInterf{
	
	@Autowired
	private RatingRepository repository;

	@Override
	public Rating create(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return repository.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Rating> getAllByUserId(String userId) {
		return repository.findAllByUserId(userId);
	}

	@Override
	public List<Rating> getAllByHotelId(String hotelId) {
		return repository.findAllByHotelId(hotelId);
	}

}
