package com.sunshineroad.framework.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * omplatform com.sunshineroad.framework.util
 * 
 * @{# DateUtil.java Create on 2013-7-12 上午8:51:02
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0 功能说明：日期工具
 * 
 */
public class DateUtils
{
	public static String addDayS(String s, int n, String unit,String format)
	{
		try
		{
			if(format == null)
			{
				format = "yyyy-MM-dd";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);

			Calendar cd = Calendar.getInstance();
			cd.setTime(sdf.parse(s));
			if (unit.equals("d"))
			{
				cd.add(Calendar.DATE, n);// 增加一天
			}
			if (unit.equals("m"))
			{
				cd.add(Calendar.MONTH, n);// 增加一个月
			}
			if (unit.equals("y"))
			{
				cd.add(Calendar.YEAR, n);// 增加一个月
			}
			
			return sdf.format(cd.getTime());

		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public static String addDayS(Date s, int n, String unit,String format)
	{
		try
		{
			if(format == null)
			{
				format = "yyyy-MM-dd";
			}
			SimpleDateFormat sdf = new SimpleDateFormat(format);

			Calendar cd = Calendar.getInstance();
			cd.setTime(s);
			if (unit.equals("d"))
			{
				cd.add(Calendar.DATE, n);// 增加一天
			}
			if (unit.equals("m"))
			{
				cd.add(Calendar.MONTH, n);// 增加一个月
			}
			if (unit.equals("y"))
			{
				cd.add(Calendar.YEAR, n);// 增加一个月
			}
			
			return sdf.format(cd.getTime());

		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public static Date addDayD(Date s, int n, String unit)
	{
		try
		{
			Calendar cd = Calendar.getInstance();
			cd.setTime(s);
			if (unit.equals("d"))
			{
				cd.add(Calendar.DATE, n);// 增加一天
			}
			if (unit.equals("m"))
			{
				cd.add(Calendar.MONTH, n);// 增加一个月
			}
			if (unit.equals("y"))
			{
				cd.add(Calendar.YEAR, n);// 增加一个月
			}
			
			return cd.getTime();

		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public static String dateFormatS(Date s,String format)throws Exception
	{
		SimpleDateFormat sdft = new SimpleDateFormat(format);
		return sdft.format(s);
	}
	
	public static String dateFormatS(String s,String format)throws Exception
	{
		SimpleDateFormat sdft = new SimpleDateFormat(format);
		return sdft.format(sdft.parse(s));
	}
	
	public static Date dateFormatD(Date s,String format)throws Exception
	{
		SimpleDateFormat sdft = new SimpleDateFormat(format);
		return sdft.parse(s.toString());
	}
	
	public static Date dateFormatD(String s,String format)throws Exception
	{
		SimpleDateFormat sdft = new SimpleDateFormat(format);
		return sdft.parse(s);
	}
}
