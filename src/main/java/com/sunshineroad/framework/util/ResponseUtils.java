package com.sunshineroad.framework.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sunshineroad.framework.web.support.pagination.PaginationUtils;

/**
 * omplatform com.sunshineroad.framework.util
 * 
 * @{# ResponseUtils.java Create on 2013-6-13 上午9:12:34
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:xxxxxx">xxxxxx</a>
 * @version 1.0 功能说明：
 * 
 */

public class ResponseUtils
{

	public static final String RESPONSE_SUCCESS_KEY = "success";

	public static final String RESPONSE_FAILURE_KEY = "failure";

	public static final String RESPONSE_TEXT_KEY = "text";

	public static final String RESPONSE_RESULT_KEY = "result";

	public static final String RESPONSE_EXTRA_KEY = "extra";

	public static final String PAGINATION_ROOT_PROPERTY_KEY = "root";

	public static final String PAGINATION_TOTAL_PROPERTY_KEY = "total";

	/**
	 * 分页数据
	 * */
	public static <T> Map<String, Object> sendPagination(List<T> T)
	{
		Map<String, Object> map = getInstanceMap();
		int total = T.size();
		if (null != PaginationUtils.getPagination())
		{
			total = PaginationUtils.getPagination().getTotal();
		}
		map.put(PAGINATION_TOTAL_PROPERTY_KEY, total);
		map.put(PAGINATION_ROOT_PROPERTY_KEY, T);
		return map;
	}

	public static <T> Map<String, Object> sendPagination(List<T> T, String text)
	{
		Map<String, Object> map = getInstanceMap();
		int total = T.size();
		if (null != PaginationUtils.getPagination())
		{
			total = PaginationUtils.getPagination().getTotal();
		}
		map.put(PAGINATION_TOTAL_PROPERTY_KEY, total);
		if (StringUtils.isNotBlank(text))
		{
			map.put(RESPONSE_TEXT_KEY, text);
			map.put(RESPONSE_RESULT_KEY, false);
		} else
		{
			map.put(RESPONSE_RESULT_KEY, true);
		}

		map.put(PAGINATION_ROOT_PROPERTY_KEY, T);
		return map;
	}

	public static <T> Map<String, Object> sendList(List<T> T)
	{
		Map<String, Object> map = getInstanceMap();
		map.put(PAGINATION_ROOT_PROPERTY_KEY, T);
		map.put(RESPONSE_SUCCESS_KEY, true);
		return map;
	}

	public static <T, V, K> Map<String, Object> sendList(Map<K, V> T)
	{
		Map<String, Object> map = getInstanceMap();
		map.put(PAGINATION_ROOT_PROPERTY_KEY, T);
		map.put(RESPONSE_SUCCESS_KEY, true);
		return map;
	}

	public static Map<String, Object> sendSuccess(String text, Object... extra)
	{
		Map<String, Object> map = getInstanceMap();
		map.put(RESPONSE_SUCCESS_KEY, true);
		map.put(RESPONSE_TEXT_KEY, text);
		if (extra.length > 0)
		{
			map.put(RESPONSE_EXTRA_KEY, extra);
		}
		return map;
	}

	public static Map<String, Object> sendFailure(String text, Object... extra)
	{
		Map<String, Object> map = getInstanceMap();
		map.put(RESPONSE_FAILURE_KEY, true);
		map.put(RESPONSE_TEXT_KEY, text);
		if (extra.length > 0)
		{
			map.put(RESPONSE_EXTRA_KEY, extra);
		}
		return map;
	}

	private static Map<String, Object> getInstanceMap()
	{
		return new HashMap<String, Object>();
	}

}
