package com.ct.lms.spring.services;

import com.ct.lms.beans.LibraryDetails;
import com.ct.lms.exceptions.ValidationException;

public interface LibraryService {

	LibraryDetails lendBook(String userId, String bookId) throws ValidationException;

}
