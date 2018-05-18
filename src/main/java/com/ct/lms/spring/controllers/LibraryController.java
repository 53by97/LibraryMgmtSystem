package com.ct.lms.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct.lms.beans.LibraryTxnDetails;
import com.ct.lms.spring.services.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);

	@Autowired
	private LibraryService libraryService;

	@PutMapping("/book/lend")
	public LibraryTxnDetails lendBook(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "bookId") String bookId) {
		LibraryTxnDetails libraryTxnDetails = null;
		try {
			return libraryService.lendBook(userId, bookId);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return libraryTxnDetails;
	}

	@PostMapping("/book/return")
	public LibraryTxnDetails returnBook(@RequestParam(value = "libraryTxnId") String libraryTxnId) {
		LibraryTxnDetails libraryTxnDetails = null;
		try {
			return libraryService.returnBook(libraryTxnId);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return libraryTxnDetails;
	}

}
