package com.ct.lms.spring.daos.impl;

import java.util.List;

import com.ct.lms.beans.BookDetails;
import com.ct.lms.spring.daos.BookDAO;
import com.ct.lms.virtual.datatables.BookDetailsTable;

public class BookDAOImpl implements BookDAO {

	private BookDetailsTable bookDetailsTable;

	public BookDAOImpl() {
		this.bookDetailsTable = new BookDetailsTable();
	}

	@Override
	public BookDetails add(String title, String author, String publisher) {
		BookDetails bookDetails = new BookDetails(title, author, publisher);
		bookDetails = bookDetailsTable.saveOrUpdate(bookDetails);
		return bookDetails;
	}

	@Override
	public List<BookDetails> searchByTitle(String text) {
		return bookDetailsTable.searchByTitle(text);
	}

	@Override
	public List<BookDetails> searchByAuthor(String text) {
		return bookDetailsTable.searchByAuthor(text);
	}

}
