package com.ct.lms.spring.services;

import com.ct.lms.beans.LibraryTxnDetails;
import com.ct.lms.exceptions.ValidationException;

public interface LibraryService {

	LibraryTxnDetails lendBook(String userId, String bookId) throws ValidationException;

	LibraryTxnDetails returnBook(String libraryTxnId) throws ValidationException;

}
