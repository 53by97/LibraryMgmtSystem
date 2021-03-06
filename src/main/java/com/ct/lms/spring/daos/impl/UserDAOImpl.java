package com.ct.lms.spring.daos.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ct.lms.beans.UserDetails;
import com.ct.lms.spring.daos.UserDAO;
import com.ct.lms.virtual.datatables.UserDetailsTable;

@Service
public class UserDAOImpl implements UserDAO {

	private UserDetailsTable userDetailsTable;

	public UserDAOImpl() {
		this.userDetailsTable = new UserDetailsTable();
	}

	@Override
	public UserDetails add(String name, String email, String contactNo, String address) {
		UserDetails userDetails = new UserDetails(name, email, contactNo, address);
		userDetails = userDetailsTable.save(userDetails);
		return userDetails;
	}

	@Override
	public List<UserDetails> searchByName(String name) {
		return userDetailsTable.searchByName(name);
	}

}
