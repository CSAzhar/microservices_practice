package com.azhar.user.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.azhar.user.service.entity.User;

@Repository
public interface UserRepositiry extends CrudRepository<User, String>{
	
	//public User findByUsername();

}