package com.sunshineroad.framework.util;

/**
 * omplatformNew
 * com.sunshineroad.system.job.service.util
 * @{#} StringHandling.java Create on  2013-6-13 上午4:43:51
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：字符串处理
 *
 */

public class StringHandling {

	//Split String with specified separator and return an array
	public String[] splitstring(String text,String separator){

		String[] ss = text.split(separator);

        return ss;
	
	}
	
	//Check whether all the string chars are int
	public boolean isnumeral(String text){
		
        String reg = "^\\d{1,}$";//代表至少一个数字组成的字符串
        String target = text.trim();//需要判断的字符串
        if (target.trim().matches(reg)) 
        {
            return true;
        }//如果要判断是不是int，那就判断Long.parserLong(target)>Intger.MIN_VALUE和<Integer.MAX_VALUE
        else {
        	return false;	
        	}
	
	}
}
