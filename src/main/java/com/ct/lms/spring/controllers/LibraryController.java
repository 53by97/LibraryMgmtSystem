package com.ct.lms.spring.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct.lms.beans.LibraryDetails;
import com.ct.lms.spring.services.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);

	@Autowired
	private LibraryService libraryService;

	@PostMapping("/book/lend")
	public LibraryDetails lendBook(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "bookId") String bookId) {
		LibraryDetails libraryDetails = null;
		try {
			return libraryService.lendBook(userId, bookId);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return libraryDetails;
	}

}
