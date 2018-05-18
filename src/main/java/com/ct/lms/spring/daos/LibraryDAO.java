package com.ct.lms.spring.daos;

import com.ct.lms.beans.LibraryTxnDetails;
import com.ct.lms.exceptions.ValidationException;

public interface LibraryDAO {

	LibraryTxnDetails lendBook(long userId, long bookId) throws ValidationException;

	LibraryTxnDetails returnBook(long libraryTxnId);

}
