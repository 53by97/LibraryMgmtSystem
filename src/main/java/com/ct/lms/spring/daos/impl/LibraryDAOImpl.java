package com.ct.lms.spring.daos.impl;

import static com.ct.lms.constants.LibraryConstants.BOOKS_PER_USER_LIMIT;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ct.lms.beans.BookDetails;
import com.ct.lms.beans.LibraryTxnDetails;
import com.ct.lms.beans.UserDetails;
import com.ct.lms.exceptions.ValidationException;
import com.ct.lms.spring.daos.LibraryDAO;
import com.ct.lms.virtual.datatables.BookDetailsTable;
import com.ct.lms.virtual.datatables.LibraryTxnDetailsTable;
import com.ct.lms.virtual.datatables.UserDetailsTable;

@Service
public class LibraryDAOImpl implements LibraryDAO {

	private UserDetailsTable userDetailsTable;
	private BookDetailsTable bookDetailsTable;
	private LibraryTxnDetailsTable libraryTxnDetailsTable;

	public LibraryDAOImpl() {
		this.userDetailsTable = new UserDetailsTable();
		this.bookDetailsTable = new BookDetailsTable();
		this.libraryTxnDetailsTable = new LibraryTxnDetailsTable();
	}

	@Override
	public LibraryTxnDetails lendBook(long userId, long bookId) throws ValidationException {
		UserDetails userDetailsObj = userDetailsTable.fetchById(userId);
		if (userDetailsObj.getIssuedBooks() == BOOKS_PER_USER_LIMIT) {
			throw new ValidationException(String.format("Books per user limit reached for user: ", userId));
		}

		LibraryTxnDetails libraryTxnDetails = new LibraryTxnDetails(userId, bookId);
		libraryTxnDetails = libraryTxnDetailsTable.saveOrUpdate(libraryTxnDetails);

		UserDetails userDetails = new UserDetails(userDetailsObj.getIssuedBooks() + 1, new Date());
		userDetailsTable.update(userDetailsObj, userDetails);

		BookDetails bookDetailsObj = bookDetailsTable.fetchById(bookId);
		BookDetails bookDetails = new BookDetails(bookDetailsObj.getIssued() + 1, new Date());
		bookDetailsTable.update(bookDetailsObj, bookDetails);

		return libraryTxnDetails;
	}

	@Override
	public LibraryTxnDetails returnBook(long libraryTxnId) {
		LibraryTxnDetails libraryTxnDetailsObj = libraryTxnDetailsTable.fetchById(libraryTxnId);

		LibraryTxnDetails libraryTxnDetails = new LibraryTxnDetails(new Date());
		libraryTxnDetailsTable.update(libraryTxnDetailsObj, libraryTxnDetails);

		UserDetails userDetailsObj = userDetailsTable.fetchById(libraryTxnDetailsObj.getUserId());
		UserDetails userDetails = new UserDetails(userDetailsObj.getIssuedBooks() - 1, new Date());
		userDetailsTable.update(userDetailsObj, userDetails);

		BookDetails bookDetailsObj = bookDetailsTable.fetchById(libraryTxnDetailsObj.getBookId());
		BookDetails bookDetails = new BookDetails(bookDetailsObj.getIssued() - 1, new Date());
		bookDetailsTable.update(bookDetailsObj, bookDetails);

		return libraryTxnDetailsObj;
	}

}
