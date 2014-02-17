package com.sunshineroad.framework.util;

import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;
import org.apache.log4j.Logger;

/**
 * omplatformNew com.sunshineroad.system.job.service.util
 * 
 * @{# TelnetConn.java Create on 2013-6-13 上午4:47:21
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0 功能说明：Telnet连接处理
 * 
 */
public class TelnetConn
{

	private static final Logger logger = Logger.getLogger(TelnetConn.class);

	private TelnetClient telnet = new TelnetClient();
	private InputStream in;
	private PrintStream out;
	private String prompt;
	@SuppressWarnings("unused")
	private static String end_of = "";
	String s;

	public void TelnetCmd(String server, String user, String password)
	{
		try
		{
			// Connect to the specified server
			telnet.connect(server, 23);

			logger.info("Login............................");
			// Get input and output stream references
			in = telnet.getInputStream();
			out = new PrintStream(telnet.getOutputStream());

			// Login
			readUntil("login:", true);
			write(user);
			readUntil("assword:", true);
			write(password);

			// Advance to a prompt
			prompt = "$>";
			readUntil(prompt, false);

			// Exec Cmd

		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.info("logon failed", e);
		}
	}

	public String readUntil(String pattern, boolean lastCharModel)
	{
		try
		{
			char[] strChar = pattern.toCharArray();
			char lastChar = pattern.charAt(pattern.length() - 1);
			StringBuilder sb = new StringBuilder();
			// boolean found = false;
			char ch = (char) in.read();

			if (lastCharModel)
			{
				while (true)
				{
					System.setProperty("GBK", "iso8859-1");
					sb.append(ch);

					if (ch == lastChar)
					{
						if (sb.toString().endsWith(pattern))
						{
							return sb.toString();
						}
					}
					ch = (char) in.read();
				}
			} else
			{
				while (true)
				{
					System.setProperty("GBK", "iso8859-1");
					sb.append(ch);
					int i=0;
					for (char temp : strChar)
					{
						if (ch == temp)
						{
							if (sb.toString().endsWith(pattern.substring(i, i+1)))
							{
								return sb.toString();
							}
						}
						i++;
					}
					ch = (char) in.read();
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void write(String value)
	{
		try
		{
			out.println(value);
			out.flush();
			// System.out.println( value );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String sendCmd(String command)
	{
		try
		{
			prompt = "$>";
			write(command);
			// return readUntil( s+prompt );
			return readUntil(prompt, false);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void disconnect()
	{
		try
		{
			telnet.disconnect();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
