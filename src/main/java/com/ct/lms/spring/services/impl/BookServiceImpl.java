package com.ct.lms.spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.lms.beans.BookDetails;
import com.ct.lms.enums.BookSearchType;
import com.ct.lms.exceptions.ValidationException;
import com.ct.lms.spring.daos.BookDAO;
import com.ct.lms.spring.services.BookService;
import com.ct.lms.validations.InputValidation;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Override
	public BookDetails addBook(String title, String author, String publisher) throws ValidationException {
		InputValidation.validateBook(title, author);
		return bookDAO.add(title, author, publisher);
	}

	@Override
	public List<BookDetails> searchBook(String text, BookSearchType type) {
		List<BookDetails> bookDetailsList = null;
		switch (type) {
		case TITLE:
			bookDetailsList = bookDAO.searchByTitle(text);
			break;
		case AUTHOR:
			bookDetailsList = bookDAO.searchByAuthor(text);
			break;
		}
		return bookDetailsList;
	}

}
