package com.ct.lms.spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ct.lms.beans.UserDetails;
import com.ct.lms.exceptions.ValidationException;
import com.ct.lms.spring.daos.UserDAO;
import com.ct.lms.spring.services.UserService;
import com.ct.lms.validations.InputValidation;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails addUser(String name, String email, String contactNo, String address) throws ValidationException {
		InputValidation.validateUser(name, email, contactNo);
		return userDAO.add(name, email, contactNo, address);
	}

	@Override
	public List<UserDetails> searchUser(String name) {
		return userDAO.searchByName(name);
	}

}
