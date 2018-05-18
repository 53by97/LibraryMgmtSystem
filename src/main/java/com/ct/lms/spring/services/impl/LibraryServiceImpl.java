package com.ct.lms.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.lms.beans.LibraryTxnDetails;
import com.ct.lms.exceptions.ValidationException;
import com.ct.lms.spring.daos.LibraryDAO;
import com.ct.lms.spring.services.LibraryService;
import com.ct.lms.validations.InputValidation;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryDAO libraryDAO;

	@Override
	public LibraryTxnDetails lendBook(String userId, String bookId) throws ValidationException {
		InputValidation.validateBookLend(userId, bookId);
		return libraryDAO.lendBook(Long.parseLong(userId), Long.parseLong(bookId));
	}

	@Override
	public LibraryTxnDetails returnBook(String libraryTxnId) throws ValidationException {
		InputValidation.validateBookReturn(libraryTxnId);
		return libraryDAO.returnBook(Long.parseLong(libraryTxnId));
	}

}
