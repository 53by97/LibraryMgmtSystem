package com.ct.lms.validations;

import org.apache.commons.lang3.StringUtils;

import com.ct.lms.exceptions.ValidationException;

public class InputValidation {

	public static void validateBook(String title, String author) throws ValidationException {
		if (StringUtils.isBlank(title) || StringUtils.isBlank(author)) {
			throw new ValidationException(String.format(
					"Mandatory field validation failed for add book request with title: '%s', author: '%s'", title,
					author));
		}
	}

	public static void validateUser(String name, String email, String contactNo) throws ValidationException {
		if (StringUtils.isBlank(name) || StringUtils.isBlank(email) || StringUtils.isBlank(contactNo)) {
			throw new ValidationException(String.format(
					"Mandatory field validation failed for add user request with name: '%s', email: '%s', contactNo: '%s'",
					name, email, contactNo));
		}
	}

	public static void validateBookLend(String userId, String bookId) throws ValidationException {
		if (StringUtils.isBlank(userId) || StringUtils.isBlank(bookId)) {
			throw new ValidationException(String.format(
					"Mandatory field validation failed for lend book request with userId: '%s', bookId: '%s'", userId,
					bookId));
		}
		try {
			Long.parseLong(userId);
		} catch (NumberFormatException e) {
			throw new ValidationException(String
					.format("Validation failed for lend book, Number type expected for field userId: '%s'", userId));
		}
		try {
			Long.parseLong(bookId);
		} catch (NumberFormatException e) {
			throw new ValidationException(String
					.format("Validation failed for lend book, Number type expected for field bookId: '%s'", bookId));
		}
	}

	public static void validateBookReturn(String libraryTxnId) throws ValidationException {
		if (StringUtils.isBlank(libraryTxnId)) {
			throw new ValidationException(String.format(
					"Mandatory field validation failed for return book request with libraryTxnId: '%s'", libraryTxnId));
		}
		try {
			Long.parseLong(libraryTxnId);
		} catch (NumberFormatException e) {
			throw new ValidationException(String.format(
					"Validation failed for return book, Number type expected for field libraryTxnId: '%s'",
					libraryTxnId));
		}
	}

}
