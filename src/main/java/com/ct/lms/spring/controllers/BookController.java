package com.ct.lms.spring.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct.lms.beans.BookDetails;
import com.ct.lms.enums.BookSearchType;
import com.ct.lms.spring.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@PostMapping("/add")
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

	@GetMapping("/search")
	public List<BookDetails> searchBook(@RequestParam(value = "text") String text,
			@RequestParam(value = "type") String type) {
		List<BookDetails> bookDetailsList = null;
		try {
			return bookService.searchBook(text, BookSearchType.getType(type));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return bookDetailsList;
	}
}
