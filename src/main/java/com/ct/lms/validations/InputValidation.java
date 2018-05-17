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

}
