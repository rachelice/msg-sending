package com.sunshineroad.framework.web.support.pagination;

import org.springframework.core.NamedThreadLocal;

/**
 * omplatform
 * com.sunshineroad.framework.web.support.pagination
 * @{#} PaginationUtils.java Create on  2013-6-13 上午9:19:13
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:xxxxxx">xxxxxx</a>
 * @version 1.0
 * 功能说明：用于存放Ext的分页数据
 *
 */

public class PaginationUtils {

	private static final ThreadLocal<Pagination> paginationHolder = new NamedThreadLocal<Pagination>(
			"Pagination Holder");

	public static void setPagination(Pagination p){
		paginationHolder.set(p);
	}
	public static void resetPaginationContext() {
		paginationHolder.remove();
	}
	public static Pagination getPagination(){
		return paginationHolder.get();
	}
	
	public static int getStart(){
		return getPagination().getStart();
	}
	
	public static int getLimit(){
		return getPagination().getLimit();
	}
	
	public static String getSorter(){
		return getPagination().getSorter();
	}
	
	public static String getOrder(){
		return getPagination().getOrder();
	}
	
	public static void setTotal(int total){
		getPagination().setTotal(total);
	}
	
	public static void getTotal(){
		getPagination().getTotal();
	}
	
	public static boolean exist(){
		return getPagination() != null;
	}
}
