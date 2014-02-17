package com.sunshineroad.framework.util;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sunshineroad.framework.context.spring.SpringDispatcherContextHolder;

public class WebUtils extends org.springframework.web.util.WebUtils {

	private static Log logger = LogFactory.getLog(WebUtils.class);

	/**
	 * 判断是否是异步的请求、AJAX请求
	 * 
	 * @param request
	 * @return boolean
	 */
	public static boolean isAsynRequest(HttpServletRequest request) {
		if (request == null) {
			request = SpringDispatcherContextHolder.getRequest();
		}
		return (request.getHeader("x-requested-with") != null && request
				.getHeader("x-requested-with").equalsIgnoreCase(
						"XMLHttpRequest"));
	}
    @SuppressWarnings("unused")
	public static String getUTF8String(String xml) {  
    // A StringBuffer Object  
    StringBuffer sb = new StringBuffer();  
    sb.append(xml);  
    String xmString = "";  
    String xmlUTF8="";  
    if(1==1)return xml;
    try {  
    xmString = new String(sb.toString().getBytes("UTF-8"));  
    xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");  
    System.out.println("utf-8 编码：" + xmlUTF8) ;  
    } catch (UnsupportedEncodingException e) {  
    // TODO Auto-generated catch block  
    e.printStackTrace();  
    }  
    // return to String Formed  
    return xmlUTF8;  
    }  
  public static HttpServletRequest getRequestByContext(){
	  
	return  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
  }
	public static void send(String text) {
		try {
			HttpServletResponse response = SpringDispatcherContextHolder
					.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.write(text);
			out.close();
		} catch (Exception e) {
			logger.error("Output something to client error,error message:"
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public static void sendFailure(String text) {
		send(JsonUtil.buildFailure(text));
	}

	public static void sendSuccess(String text) {
		send(JsonUtil.buildSuccess(text));
	}

	public static void sendPagination(List<?> list) {
		send(JsonUtil.buildPagination(list));
	}

	public static void sendArrayList(List<?> list) {
		send(JsonUtil.buildArrayList(list));
	}
}
