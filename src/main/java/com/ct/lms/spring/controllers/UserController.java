package com.ct.lms.spring.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct.lms.beans.UserDetails;
import com.ct.lms.spring.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PutMapping("/add")
	public UserDetails addUser(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email,
			@RequestParam(value = "contactNo") String contactNo, @RequestParam(value = "address") String address) {
		UserDetails userDetails = null;
		try {
			return userService.addUser(name, email, contactNo, address);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return userDetails;
	}
	
	@GetMapping("/search")
	public List<UserDetails> searchUser(@RequestParam(value = "name") String name) {
		List<UserDetails> userDetailsList = null;
		try {
			return userService.searchUser(name);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return userDetailsList;
	}

}
