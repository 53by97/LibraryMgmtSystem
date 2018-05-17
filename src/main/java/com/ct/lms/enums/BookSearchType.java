package com.ct.lms.enums;

import org.apache.commons.lang3.StringUtils;

public enum BookSearchType {

	TITLE("title"), AUTHOR("author");

	private String value;

	private BookSearchType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	/**
	 * Use this method instead of valueOf() as we return custom string
	 * 
	 * @param type
	 * @return
	 */
	public static BookSearchType getType(String type) {
		for (BookSearchType value : values()) {
			if (StringUtils.equals(value.toString(), type)) {
				return value;
			}
		}
		throw new IllegalArgumentException(String.format("Invalid BookSearchType enum value: %s", type));
	}

}
