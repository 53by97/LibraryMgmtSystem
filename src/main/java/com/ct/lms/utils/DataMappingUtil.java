package com.ct.lms.utils;

import java.util.Date;

import com.ct.lms.beans.BookDetails;
import com.ct.lms.beans.UserDetails;

public class DataMappingUtil {

	public static void addDefaultBookDetails(BookDetails bookDetails) {
		bookDetails.setQuantity(1);
		bookDetails.setIssued(0);
		Date currentDate = new Date();
		bookDetails.setCreatedOn(currentDate);
		bookDetails.setUpdatedOn(currentDate);
	}

	public static void addDefaultUserDetails(UserDetails userDetails) {
		userDetails.setIssuedBooks(0);
		Date currentDate = new Date();
		userDetails.setCreatedOn(currentDate);
		userDetails.setUpdatedOn(currentDate);
	}

	private DataMappingUtil() {
		// let's not allow instantiating an Util class
	}

}
