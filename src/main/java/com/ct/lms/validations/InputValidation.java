package com.ct.lms.validations;

import org.apache.commons.lang3.StringUtils;

import com.ct.lms.exceptions.ValidationException;

public class InputValidation {

	public static void validateBook(String title, String author) throws ValidationException {
		if (StringUtils.isEmpty(title) || StringUtils.isEmpty(author)) {
			throw new ValidationException(String.format(
					"Validation failed for book info - title: '%s', author: '%s'! Both the fields are mandatory!",
					title, author));
		}
	}

}
