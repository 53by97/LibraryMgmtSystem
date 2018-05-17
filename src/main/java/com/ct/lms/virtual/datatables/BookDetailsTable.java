package com.ct.lms.virtual.datatables;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.ct.lms.beans.BookDetails;
import com.ct.lms.utils.DataMappingUtil;
import com.ct.lms.utils.GenericUtil;
import com.ct.lms.utils.UniqueIdGeneratorUtil;

public class BookDetailsTable {

	private static Map<BookDetails, BookDetails> bookDetailsMap;

	private static Map<Long, BookDetails> idx_id_bookDetails;
	private static Map<String, List<BookDetails>> idx_title_bookDetails;
	private static Map<String, List<BookDetails>> idx_author_bookDetails;

	static {
		bookDetailsMap = new HashMap<>();
		idx_id_bookDetails = new HashMap<>();
		idx_title_bookDetails = new HashMap<>();
		idx_author_bookDetails = new HashMap<>();
	}

	public BookDetails saveOrUpdate(BookDetails bookDetails) {
		BookDetails bookDetailsObj = bookDetailsMap.get(bookDetails);
		if (Objects.isNull(bookDetailsObj)) {
			bookDetailsObj = save(bookDetails);
		} else {
			update(bookDetailsObj, bookDetails);
		}
		return bookDetailsObj;
	}

	public BookDetails save(BookDetails bookDetails) {
		BookDetails bookDetailsObj;
		bookDetails.setId(UniqueIdGeneratorUtil.getUniqueBookId(bookDetails.getTitle(), bookDetails.getAuthor()));
		DataMappingUtil.addDefaultBookDetails(bookDetails);
		bookDetailsMap.put(bookDetails, bookDetails);
		bookDetailsObj = bookDetails;
		// indexing should be done in a background thread
		idx_id_bookDetails.put(bookDetailsObj.getId(), bookDetailsObj);
		GenericUtil.putToMap(idx_title_bookDetails, bookDetailsObj.getTitle(), bookDetailsObj);
		GenericUtil.putToMap(idx_author_bookDetails, bookDetailsObj.getAuthor(), bookDetailsObj);
		return bookDetailsObj;
	}

	public void update(BookDetails bookDetailsObj, BookDetails bookDetails) {
		if (bookDetails.getQuantity() != 0) {
			bookDetailsObj.setQuantity(bookDetails.getQuantity());
		}
		if (bookDetails.getIssued() != 0) {
			bookDetailsObj.setIssued(bookDetails.getIssued());
		}
		if (StringUtils.isNotBlank(bookDetails.getPublisher())) {
			bookDetailsObj.setPublisher(bookDetails.getPublisher());
		}
		bookDetailsObj.setUpdatedOn(new Date());
	}

	public BookDetails fetchById(long id) {
		return idx_id_bookDetails.get(id);
	}

	public List<BookDetails> searchByTitle(String text) {
		return idx_title_bookDetails.get(text);
	}

	public List<BookDetails> searchByAuthor(String text) {
		return idx_author_bookDetails.get(text);
	}

}
