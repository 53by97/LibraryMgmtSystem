package com.ct.lms.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GenericUtil {

	public static <T> void putToMap(Map<String, List<T>> map, String key, T item) {
		if (Objects.isNull(map.get(key))) {
			List<T> list = new ArrayList<>();
			map.put(key, list);
		}
		map.get(key).add(item);
	}

	private GenericUtil() {
		// let's not allow instantiating an Util class
	}
}
