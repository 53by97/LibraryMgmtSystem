package com.ct.lms.virtual.datatables;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.ct.lms.beans.BookDetails;
import com.ct.lms.utils.DataMappingUtil;
import com.ct.lms.utils.GenericUtil;
import com.ct.lms.utils.UniqueIdGeneratorUtil;

public class BookDetailsTable {

	private static Set<BookDetails> bookDetailsSet;

	private static Map<String, List<BookDetails>> idx_title_bookDetails;
	private static Map<String, List<BookDetails>> idx_author_bookDetails;

	static {
		bookDetailsSet = new HashSet<>();
		idx_title_bookDetails = new HashMap<>();
		idx_author_bookDetails = new HashMap<>();
	}

	public synchronized BookDetails saveOrUpdate(BookDetails bookDetails) {
		if (bookDetailsSet.contains(bookDetails)) {
			BookDetails bookDetailsObj = null;
			Iterator<BookDetails> iterator = bookDetailsSet.iterator();
			while (iterator.hasNext()) {
				bookDetailsObj = (BookDetails) iterator.next();
				if (bookDetailsObj.equals(bookDetails)) {
					break;
				}
			}
			if (bookDetails.getQuantity() != 0) {
				bookDetailsObj.setQuantity(bookDetailsObj.getQuantity() + bookDetails.getQuantity());
			}
			if (bookDetails.getIssued() != 0) {
				bookDetailsObj.setIssued(bookDetailsObj.getIssued() + bookDetails.getIssued());
			}
			if (StringUtils.isNotBlank(bookDetails.getPublisher())) {
				bookDetailsObj.setPublisher(bookDetails.getPublisher());
			}
			bookDetailsObj.setUpdatedOn(new Date());
		} else {
			bookDetails.setId(UniqueIdGeneratorUtil.getUniqueBookId(bookDetails.getTitle(), bookDetails.getAuthor()));
			DataMappingUtil.addDefaultBookDetails(bookDetails);
			bookDetailsSet.add(bookDetails);
			// indexing should be done in a background thread
			GenericUtil.putToMap(idx_title_bookDetails, bookDetails.getTitle(), bookDetails);
			GenericUtil.putToMap(idx_author_bookDetails, bookDetails.getAuthor(), bookDetails);
		}
		return bookDetails;
	}

	public List<BookDetails> searchByTitle(String text) {
		return idx_title_bookDetails.get(text);
	}

	public List<BookDetails> searchByAuthor(String text) {
		return idx_author_bookDetails.get(text);
	}

}
