package com.sunshineroad.framework.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * omplatform
 * com.sunshineroad.framework.util
 * @{#} ListUtils.java Create on  2013-6-13 上午9:10:45
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:xxxxxx">xxxxxx</a>
 * @version 1.0
 * 功能说明：List功能扩展
 *
 */

public class ListUtils extends org.apache.commons.collections.ListUtils {

	public static <T, S> List<T> transform(List<S> list, Class<T> clazz) {
		List<T> result = new ArrayList<T>();
		for (S s : list) {
			try {
				T o = clazz.newInstance();
				PropertyUtils.copyProperties(o, s);
				result.add(o);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static <S> List<Map<String,Object>> transform(List<S> list, String... fields) {
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		for (S s : list) {
			try {
				Map<String,Object> map = new HashMap<String,Object>();
				for (String field : fields) {
					map.put(field, PropertyUtils.getProperty(s, field));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
