package com.ct.lms.virtual.datatables;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.ct.lms.beans.UserDetails;
import com.ct.lms.utils.DataMappingUtil;
import com.ct.lms.utils.GenericUtil;
import com.ct.lms.utils.UniqueIdGeneratorUtil;

public class UserDetailsTable {

	private static Set<UserDetails> userDetailsSet;

	private static Map<String, List<UserDetails>> idx_title_userDetails;

	static {
		userDetailsSet = new HashSet<>();
		idx_title_userDetails = new HashMap<>();
	}

	public synchronized UserDetails saveOrUpdate(UserDetails userDetails) {
		if (userDetailsSet.contains(userDetails)) {
			UserDetails userDetailsObj = null;
			Iterator<UserDetails> iterator = userDetailsSet.iterator();
			while (iterator.hasNext()) {
				userDetailsObj = (UserDetails) iterator.next();
				if (userDetailsObj.equals(userDetails)) {
					break;
				}
			}
			if (userDetails.getIssuedBooks() != 0) {
				userDetailsObj.setIssuedBooks(userDetailsObj.getIssuedBooks() + userDetails.getIssuedBooks());
			}
			if (StringUtils.isNotBlank(userDetails.getAddress())) {
				userDetailsObj.setAddress(userDetails.getAddress());
			}
			userDetailsObj.setUpdatedOn(new Date());
		} else {
			userDetails
					.setId(UniqueIdGeneratorUtil.getUniqueUserId(userDetails.getEmail(), userDetails.getContactNo()));
			DataMappingUtil.addDefaultUserDetails(userDetails);
			userDetailsSet.add(userDetails);
			// indexing should be done in a background thread
			GenericUtil.putToMap(idx_title_userDetails, userDetails.getName(), userDetails);
		}
		return userDetails;
	}

	public List<UserDetails> searchByName(String name) {
		return idx_title_userDetails.get(name);
	}

}
