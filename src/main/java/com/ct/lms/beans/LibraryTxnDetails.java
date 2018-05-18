package com.ct.lms.beans;

import java.util.Date;
import java.util.Objects;

public class LibraryTxnDetails {

	private long id;
	private long userId;
	private long bookId;

	private Date issuedOn;
	private Date returnedOn;

	public LibraryTxnDetails() {
	}

	public LibraryTxnDetails(long userId, long bookId) {
		this.userId = userId;
		this.bookId = bookId;
	}

	public LibraryTxnDetails(Date returnedOn) {
		this.returnedOn = returnedOn;
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		if (Objects.nonNull(userId)) {
			hashCode = String.valueOf(userId).hashCode();
		}
		if (Objects.nonNull(bookId)) {
			hashCode = (int) ((long) hashCode + (long) String.valueOf(bookId).hashCode());
		}
		return hashCode;
	}

	@Override
	public boolean equals(Object arg0) {
		final LibraryTxnDetails other = (LibraryTxnDetails) arg0;
		return Objects.equals(userId, other.getUserId()) && Objects.equals(bookId, other.getBookId());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
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
