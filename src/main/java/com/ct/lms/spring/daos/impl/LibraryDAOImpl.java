package com.ct.lms.spring.daos.impl;

import static com.ct.lms.constants.LibraryConstants.BOOKS_PER_USER_LIMIT;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ct.lms.beans.BookDetails;
import com.ct.lms.beans.LibraryDetails;
import com.ct.lms.beans.UserDetails;
import com.ct.lms.exceptions.ValidationException;
import com.ct.lms.spring.daos.LibraryDAO;
import com.ct.lms.virtual.datatables.BookDetailsTable;
import com.ct.lms.virtual.datatables.LibraryDetailsTable;
import com.ct.lms.virtual.datatables.UserDetailsTable;

@Service
public class LibraryDAOImpl implements LibraryDAO {

	private UserDetailsTable userDetailsTable;
	private BookDetailsTable bookDetailsTable;
	private LibraryDetailsTable libraryDetailsTable;

	public LibraryDAOImpl() {
		this.userDetailsTable = new UserDetailsTable();
		this.bookDetailsTable = new BookDetailsTable();
		this.libraryDetailsTable = new LibraryDetailsTable();
	}

	@Override
	public LibraryDetails lendBook(long userId, long bookId) throws ValidationException {
		UserDetails userDetailsObj = userDetailsTable.fetchById(userId);
		if (userDetailsObj.getIssuedBooks() == BOOKS_PER_USER_LIMIT) {
			throw new ValidationException(String.format("Books per user limit reached for user: ", userId));
		}

		LibraryDetails libraryDetails = new LibraryDetails(userId, bookId);
		libraryDetails = libraryDetailsTable.saveOrUpdate(libraryDetails);

		UserDetails userDetails = new UserDetails(userDetailsObj.getIssuedBooks() + 1, new Date());
		userDetailsTable.update(userDetailsObj, userDetails);

		BookDetails bookDetailsObj = bookDetailsTable.fetchById(bookId);
		BookDetails bookDetails = new BookDetails(bookDetailsObj.getIssued() + 1, new Date());
		bookDetailsTable.update(bookDetailsObj, bookDetails);

		return libraryDetails;
	}

}
