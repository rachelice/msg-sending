package com.sunshineroad.framework.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * omplatform com.sunshineroad.framework.util
 * 
 * @{# TxtParser.java Create on 2013-6-24 上午9:02:33
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0 功能说明：txt文件读取
 * 
 */
public class TxtParser
{
	/**
	 * 功能：Java读取txt文件的内容(文件不考虑双字节字符)
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 读出的txt的内容
	 */

	private static final Log logger = LogFactory.getLog(TxtParser.class);

	public String getTextFromTxt(String filePath) throws Exception
	{

		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		StringBuffer buff = new StringBuffer();
		String temp = null;
		while ((temp = br.readLine()) != null)
		{
			buff.append(temp + "\r\n");
		}
		br.close();
		return buff.toString();
	}

	/**
	 * 功能：Java读取txt文件的内容 步骤： 1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出readline() 备注：需要考虑的是异常情况
	 * 
	 * @param filePath
	 * @return
	 */

	public List<String> readTxtFile(String filePath)
	{
		try
		{
			// String encoding="GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists())
			{ // 判断文件是否存在
				String encoding = getCharset(filePath);
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				List<String> lineTxtList = new ArrayList<String>();
				while ((lineTxt = bufferedReader.readLine()) != null)
				{
					// 去除空行
					char ch[] = lineTxt.trim().toCharArray();
					if (ch.length > 0)
					{
						if (ch[0] != ch[ch.length - 1])
						{
							lineTxtList.add(lineTxt);
						}
					}
				}
				read.close();
				return lineTxtList;

			} else
			{
				logger.error("找不到指定的文件");
			}
		}
		catch (Exception e)
		{
			logger.error("读取文件内容出错");
			e.printStackTrace();
		}
		return null;

	}

	private String getCharset(String fileName) throws IOException
	{

		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(
				fileName));
		int p = (bin.read() << 8) + bin.read();

		String code = null;

		switch (p)
		{
		case 0xefbb:
			code = "UTF-8";
			break;
		case 0xfffe:
			code = "Unicode";
			break;
		case 0xfeff:
			code = "UTF-16BE";
			break;
		default:
			code = "GBK";
		}
		return code;
	}

}
