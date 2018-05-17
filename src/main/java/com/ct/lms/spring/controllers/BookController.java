package com.ct.lms.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct.lms.dao.beans.BookDetails;
import com.ct.lms.spring.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@GetMapping("/add")
	public BookDetails addBook(@RequestParam(value = "title") String title,
			@RequestParam(value = "author") String author,
			@RequestParam(value = "publisher", defaultValue = "") String publisher) {
		BookDetails bookDetails = null;
		try {
			return bookService.addBook(title, author, publisher);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return bookDetails;
	}
}
