package com.azhar.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azhar.hotel.entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String>{

}
