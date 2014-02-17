package com.sunshineroad.framework.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

import com.sunshineroad.framework.context.spring.SpringDispatcherContextHolder;

@Deprecated
public class WebDispatcherServlet extends DispatcherServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SpringDispatcherContextHolder.initDispatcherContext(response);
		
		java.util.ResourceBundle  bundlePath = java.util.ResourceBundle.getBundle("resources//base_config");
    	String jsBasePath=bundlePath.getString("js");
    	response.setHeader("Access-Control-Allow-Origin", jsBasePath+"/*");
		super.doService(request, response);
	}
}
