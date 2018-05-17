package com.ct.lms.beans;

import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class BookDetails {

	private long id;

	private String title;
	private String author;
	private String publisher;

	private int quantity;
	private int issued;

	private Date createdOn;
	private Date updatedOn;

	public BookDetails() {
	}

	public BookDetails(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		if (Objects.nonNull(title)) {
			hashCode = title.hashCode();
		}
		if (Objects.nonNull(author)) {
			hashCode = (int) ((long) hashCode + (long) author.hashCode());
		}
		return hashCode;
	}

	@Override
	public boolean equals(Object arg0) {
		final BookDetails other = (BookDetails) arg0;
		return StringUtils.equals(this.getTitle(), other.getTitle())
				&& StringUtils.equals(this.getAuthor(), other.getAuthor());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIssued() {
		return issued;
	}

	public void setIssued(int issued) {
		this.issued = issued;
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
