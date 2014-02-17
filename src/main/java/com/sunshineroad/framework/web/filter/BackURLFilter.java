package com.sunshineroad.framework.web.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;


/**
 * omplatformNew
 * com.sunshineroad.framework.web.filter
 * @{#} BackURLFilter.java Create on  2013-6-13 上午5:26:46
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：URL过滤器
 *
 */

public class BackURLFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String backURL = request.getParameter("BackURL");
        if(StringUtils.isEmpty(backURL)) {
            backURL = request.getHeader("Referer");
        }
        
		// (获得extjs session过期值)
		String head = request.getHeader("x-requested-with");
		if (head != null && (head.equalsIgnoreCase("XMLHttpRequest"))) {
/*			if (request.getSession().getAttribute("LOGIN_CAPTCHA") == null) {
				response.addHeader("_timeout", "true");				
			}*/
			if(request.getRequestURL().indexOf("timeout.jsp")!=-1){
				response.addHeader("_timeout", "true");		
			}
			filterChain.doFilter(request, response);
		} else {

			/*
			 * System.out.println("lhl:"+request.getRequestURL());
			 * if(request.getRequestURL().indexOf("assocustoms")==-1){
			 * CustomerContextHolder
			 * .setCustomerType(CustomerContextHolder.DATA_SOURCE_A); }else{
			 * CustomerContextHolder
			 * .setCustomerType(CustomerContextHolder.DATA_SOURCE_B); }
			 */

			request.setAttribute("BackURL", backURL);

			request.setAttribute("mBackURL", getMBackURL(request, response));

			filterChain.doFilter(request, response);
		}

    }

    public static String getMBackURL(HttpServletRequest request, HttpServletResponse response) {
        String basePath = request.getScheme() + "://" + request.getServerName();
        if (request.getServerPort() != 80) {
            basePath += ":" + request.getServerPort();
        }
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();

        String backURL = basePath + requestURI + (queryString == null || queryString.length() == 0 ? "" : "?" + queryString);

        /*
        try {
            backURL = response.encodeURL(backURL);
            backURL = URLEncoder.encode(backURL, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        */
        return backURL;
    }



    @Override
    public void destroy() {

    }
}
