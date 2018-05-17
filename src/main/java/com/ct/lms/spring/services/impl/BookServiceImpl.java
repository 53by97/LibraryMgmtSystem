package com.ct.lms.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ct.lms.dao.beans.BookDetails;
import com.ct.lms.dto.beans.Book;
import com.ct.lms.exceptions.ValidationException;
import com.ct.lms.spring.daos.BookDAO;
import com.ct.lms.spring.services.BookService;
import com.ct.lms.validations.InputValidation;

public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Override
	public BookDetails addBook(String title, String author, String publisher) throws ValidationException {
		InputValidation.validateBook(title, author);
		return bookDAO.add(new Book(title, author, publisher));
	}

}
