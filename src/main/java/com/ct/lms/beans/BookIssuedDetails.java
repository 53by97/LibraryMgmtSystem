package com.ct.lms.beans;

import java.util.Date;

public class BookIssuedDetails {

	private long id;
	private long bookId;
	private long userId;

	private Date issuedOn;
	private Date returnedOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(Date issuedOn) {
		this.issuedOn = issuedOn;
	}

	public Date getReturnedOn() {
		return returnedOn;
	}

	public void setReturnedOn(Date returnedOn) {
		this.returnedOn = returnedOn;
	}

}
