package com.ct.lms.virtual.datatables;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.ct.lms.beans.LibraryTxnDetails;
import com.ct.lms.utils.UniqueIdGeneratorUtil;

public class LibraryTxnDetailsTable {

	private static Map<LibraryTxnDetails, LibraryTxnDetails> libraryDetailsMap;

	private static Map<Long, LibraryTxnDetails> idx_id_libraryDetails;

	static {
		libraryDetailsMap = new HashMap<>();
		idx_id_libraryDetails = new HashMap<>();
	}

	public LibraryTxnDetails saveOrUpdate(LibraryTxnDetails libraryDetails) {
		LibraryTxnDetails libraryDetailsObj = libraryDetailsMap.get(libraryDetails);
		if (Objects.isNull(libraryDetailsObj)) {
			libraryDetailsObj = save(libraryDetails);
		} else {
			update(libraryDetailsObj, libraryDetails);
		}
		return libraryDetailsObj;
	}

	public LibraryTxnDetails save(LibraryTxnDetails libraryDetails) {
		LibraryTxnDetails libraryDetailsObj;
		libraryDetails.setId(
				UniqueIdGeneratorUtil.getUniqueLibraryTxnId(libraryDetails.getUserId(), libraryDetails.getBookId()));
		libraryDetails.setIssuedOn(new Date());
		libraryDetails.setReturnedOn(null);
		libraryDetailsMap.put(libraryDetails, libraryDetails);
		libraryDetailsObj = libraryDetails;
		// indexing should be done in a background thread
		idx_id_libraryDetails.put(libraryDetailsObj.getId(), libraryDetailsObj);
		return libraryDetailsObj;
	}

	public void update(LibraryTxnDetails libraryDetailsObj, LibraryTxnDetails libraryDetails) {
		if (Objects.nonNull(libraryDetails.getIssuedOn())) {
			libraryDetailsObj.setIssuedOn(libraryDetails.getIssuedOn());
		}
		if (Objects.nonNull(libraryDetails.getReturnedOn())) {
			libraryDetailsObj.setReturnedOn(libraryDetails.getReturnedOn());
		}
	}

	public LibraryTxnDetails fetchById(long id) {
		return idx_id_libraryDetails.get(id);
	}

}
