package com.sunshineroad.framework.util;

/**
 * omplatform
 * com.sunshineroad.system.fileupload.vo
 * @{#} test.java Create on  2013-6-17 上午3:50:14
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */

public class ExtJSFormResult {

	private boolean success;
	private String info;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}
	
	
	public String toResult() {
		return "{\"success\" : "+ this.success + ", \"msg\" : \"" + this.getInfo() + "\"}";
	}
}