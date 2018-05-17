package com.ct.lms.virtual.datatables;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.ct.lms.beans.UserDetails;
import com.ct.lms.utils.DataMappingUtil;
import com.ct.lms.utils.GenericUtil;
import com.ct.lms.utils.UniqueIdGeneratorUtil;

public class UserDetailsTable {

	private static Map<UserDetails, UserDetails> userDetailsMap;

	private static Map<Long, UserDetails> idx_id_userDetails;
	private static Map<String, List<UserDetails>> idx_title_userDetails;

	static {
		userDetailsMap = new HashMap<>();
		idx_id_userDetails = new HashMap<>();
		idx_title_userDetails = new HashMap<>();
	}

	public UserDetails saveOrUpdate(UserDetails userDetails) {
		UserDetails userDetailsObj = userDetailsMap.get(userDetails);
		if (Objects.isNull(userDetailsObj)) {
			userDetailsObj = save(userDetails);
		} else {
			update(userDetailsObj, userDetails);
		}
		return userDetailsObj;
	}

	public UserDetails save(UserDetails userDetails) {
		UserDetails userDetailsObj;
		userDetails.setId(UniqueIdGeneratorUtil.getUniqueUserId(userDetails.getEmail(), userDetails.getContactNo()));
		DataMappingUtil.addDefaultUserDetails(userDetails);
		userDetailsMap.put(userDetails, userDetails);
		userDetailsObj = userDetails;
		// indexing should be done in a background thread
		idx_id_userDetails.put(userDetailsObj.getId(), userDetailsObj);
		GenericUtil.putToMap(idx_title_userDetails, userDetailsObj.getName(), userDetailsObj);
		return userDetailsObj;
	}

	public void update(UserDetails userDetailsObj, UserDetails userDetails) {
		if (userDetails.getIssuedBooks() != 0) {
			userDetailsObj.setIssuedBooks(userDetails.getIssuedBooks());
		}
		if (StringUtils.isNotBlank(userDetails.getAddress())) {
			userDetailsObj.setAddress(userDetails.getAddress());
		}
		userDetailsObj.setUpdatedOn(new Date());
	}

	public UserDetails fetchById(long id) {
		return idx_id_userDetails.get(id);
	}

	public List<UserDetails> searchByName(String name) {
		return idx_title_userDetails.get(name);
	}

}
