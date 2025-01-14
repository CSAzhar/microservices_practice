package com.azhar.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azhar.user.service.entity.User;
import com.azhar.user.service.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userServices.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		User user1 = userServices.getUser(userId);
		return ResponseEntity.ok(user1);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> allUsers = userServices.getAllUser();
		return ResponseEntity.ok(allUsers);
	}
	

}
