package com.ct.lms.spring.services;

import com.ct.lms.dao.beans.BookDetails;
import com.ct.lms.exceptions.ValidationException;

public interface BookService {

	BookDetails addBook(String title, String author, String publisher) throws ValidationException;

}
