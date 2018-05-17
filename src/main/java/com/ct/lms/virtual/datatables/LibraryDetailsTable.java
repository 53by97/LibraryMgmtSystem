package com.ct.lms.virtual.datatables;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.ct.lms.beans.LibraryDetails;
import com.ct.lms.utils.UniqueIdGeneratorUtil;

public class LibraryDetailsTable {

	private static Map<LibraryDetails, LibraryDetails> libraryDetailsMap;

	private static Map<Long, LibraryDetails> idx_id_libraryDetails;

	static {
		libraryDetailsMap = new HashMap<>();
		idx_id_libraryDetails = new HashMap<>();
	}

	public LibraryDetails saveOrUpdate(LibraryDetails libraryDetails) {
		LibraryDetails libraryDetailsObj = libraryDetailsMap.get(libraryDetails);
		if (Objects.isNull(libraryDetailsObj)) {
			libraryDetailsObj = save(libraryDetails);
		} else {
			update(libraryDetailsObj, libraryDetails);
		}
		return libraryDetailsObj;
	}

	public LibraryDetails save(LibraryDetails libraryDetails) {
		LibraryDetails libraryDetailsObj;
		libraryDetails.setId(UniqueIdGeneratorUtil.getUniqueLibraryTxnId(libraryDetails.getUserId(),
				libraryDetails.getBookId()));
		libraryDetails.setIssuedOn(new Date());
		libraryDetailsMap.put(libraryDetails, libraryDetails);
		libraryDetailsObj = libraryDetails;
		// indexing should be done in a background thread
		idx_id_libraryDetails.put(libraryDetailsObj.getId(), libraryDetailsObj);
		return libraryDetailsObj;
	}

	public void update(LibraryDetails libraryDetailsObj, LibraryDetails libraryDetails) {
		if (Objects.nonNull(libraryDetails.getIssuedOn())) {
			libraryDetailsObj.setIssuedOn(libraryDetails.getIssuedOn());
		}
		if (Objects.nonNull(libraryDetails.getReturnedOn())) {
			libraryDetailsObj.setReturnedOn(libraryDetails.getReturnedOn());
		}
	}

	public LibraryDetails fetchById(long id) {
		return idx_id_libraryDetails.get(id);
	}

}
