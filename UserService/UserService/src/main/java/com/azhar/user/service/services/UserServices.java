package com.azhar.user.service.services;

import java.util.List;

import com.azhar.user.service.entity.User;

public interface UserServices {
	
	User saveUser(User user);
	List<User> getAllUser();
	User getUser(String userId);
	

}
