package com.ct.lms.dao.beans;

import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.ct.lms.dto.beans.Book;

public class BookDetails {

	private long id;

	private Book book;

	private int quantity;
	private int issued;

	private Date createdOn;
	private Date updatedOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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

	@Override
	public int hashCode() {
		int hashCode = 0;
		if (Objects.nonNull(book)) {
			hashCode = book.getTitle().hashCode() + book.getAuthor().hashCode();
		}
		return hashCode;
	}

	@Override
	public boolean equals(Object arg0) {
		final Book book2 = ((BookDetails) arg0).getBook();
		if (Objects.isNull(book)) {
			return super.equals(book2);
		} else {
			return StringUtils.equals(book.getTitle(), book2.getTitle())
					&& StringUtils.equals(book.getAuthor(), book2.getAuthor());
		}
	}
}
