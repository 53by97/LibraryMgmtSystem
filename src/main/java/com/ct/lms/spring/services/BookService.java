package com.ct.lms.spring.services;

import java.util.List;

import com.ct.lms.beans.BookDetails;
import com.ct.lms.enums.BookSearchType;
import com.ct.lms.exceptions.ValidationException;

public interface BookService {

	BookDetails addBook(String title, String author, String publisher) throws ValidationException;

	List<BookDetails> searchBook(String text, BookSearchType type);

}
