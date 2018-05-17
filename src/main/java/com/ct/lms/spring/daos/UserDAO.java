package com.ct.lms.spring.daos;

import java.util.List;

import com.ct.lms.beans.UserDetails;

public interface UserDAO {

	UserDetails add(String name, String email, String contactNo, String address);

	List<UserDetails> searchByName(String name);

}
