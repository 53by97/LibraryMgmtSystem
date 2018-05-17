package com.ct.lms.beans;

import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class UserDetails {

	private long id;

	private String name;
	private String password;
	private String email;
	private String contactNo;
	private String address;

	private int issuedBooks;

	private Date createdOn;
	private Date updatedOn;

	public UserDetails() {
	}

	public UserDetails(String name, String email, String contactNo, String address) {
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
	}
	
	public UserDetails(int issuedBooks, Date updatedOn) {
		this.issuedBooks = issuedBooks;
		this.updatedOn = updatedOn;
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		if (Objects.nonNull(email)) {
			hashCode = email.hashCode();
		}
		if (Objects.nonNull(contactNo)) {
			hashCode = (int) ((long) hashCode + (long) contactNo.hashCode());
		}
		return hashCode;
	}

	@Override
	public boolean equals(Object arg0) {
		final UserDetails other = (UserDetails) arg0;
		return StringUtils.equals(email, other.getEmail()) && StringUtils.equals(contactNo, other.getContactNo());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIssuedBooks() {
		return issuedBooks;
	}

	public void setIssuedBooks(int issuedBooks) {
		this.issuedBooks = issuedBooks;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
}
