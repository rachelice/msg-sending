package com.sunshineroad.system.security.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.sunshineroad.system.user.dao.UserDao;
import com.sunshineroad.system.user.model.UserModel;

/**
 * omplatform
 * com.sunshineroad.system.security.service.impl
 * @{#} MyAuthenticationFilter.java Create on  2013-6-13 上午9:51:23
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：用户登陆过滤器
 *
 */

@Service("myAuthenticationFilter")
public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String CAPTCHA = "captcha";
	private static final String ISMOBILE = "ismobile";
	
    @Autowired
	private UserDao userDao;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		System.out.println("000000000000000");
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		// check验证码
		String captcha = obtainCaptcha(request);
		String ismobile = obtainIsmobile(request);
		String login_captcha= (String) request.getSession().getAttribute("LOGIN_CAPTCHA") ;
		if(!login_captcha.equals(login_captcha )){
			if (ismobile==null&&(captcha == null || !captcha.equalsIgnoreCase(login_captcha))) {
				BadCredentialsException exception = new BadCredentialsException("验证码输入不正确！请重新输入！");
				throw exception;
			}
		}
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		System.out.println(">>>>>>>>>>000<<<<<<<<<< username is " + username+"   passwod:"+password);

		// 验证用户账号与密码是否正确
		username = username.trim();
		UserModel user = this.userDao.findByUsername(username);
		 

		//System.out.println(" username is " + user.getPassword());
		//String passwordMd5=CipherUtil.generatePassword(password);
		if (user == null || !user.getPassword().equalsIgnoreCase(password)) {
			BadCredentialsException exception = new BadCredentialsException("权限认证失败！用户名或密码不匹配！");
			//request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
			throw exception;
		}

		// 实现 Authentication
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		 
		// 允许子类设置详细属性
		setDetails(request, authRequest);

		// 运行UserDetailsService的loadUserByUsername 再次封装Authentication
		return this.getAuthenticationManager().authenticate(authRequest);
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(USERNAME);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(PASSWORD);
		return null == obj ? "" : obj.toString();
	}
	
	protected String obtainCaptcha(HttpServletRequest request) {
		Object obj = request.getParameter(CAPTCHA);
		return null == obj ? "" : obj.toString();
	}
	
	protected String obtainIsmobile(HttpServletRequest request) {
		Object obj = request.getParameter(ISMOBILE);
		return null == obj ? "" : obj.toString();
	}
	
	@Override
	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
		super.setDetails(request, authRequest);
	}
}
