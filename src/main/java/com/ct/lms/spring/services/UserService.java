package com.ct.lms.spring.services;

import java.util.List;

import com.ct.lms.beans.UserDetails;
import com.ct.lms.exceptions.ValidationException;

public interface UserService {

	UserDetails addUser(String name, String email, String contactNo, String address) throws ValidationException;

	List<UserDetails> searchUser(String name);

}
