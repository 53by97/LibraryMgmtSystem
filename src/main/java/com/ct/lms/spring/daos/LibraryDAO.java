package com.ct.lms.spring.daos;

import com.ct.lms.beans.LibraryDetails;
import com.ct.lms.exceptions.ValidationException;

public interface LibraryDAO {

	LibraryDetails lendBook(long userId, long bookId) throws ValidationException;

}
