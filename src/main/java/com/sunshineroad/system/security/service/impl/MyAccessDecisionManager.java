package com.sunshineroad.system.security.service.impl;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * omplatform
 * com.sunshineroad.system.security.service.impl
 * @{#} MyAccessDecisionManager.java Create on  2013-6-13 上午9:50:01
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：登陆用户访问权限判断过滤器
 *
 */

@Service("myAccessDecisionManager")
public class MyAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		System.out.println(">>>>>>>>>>444<<<<<<<<<< MyAccessDecisionManager ");
		if (configAttributes == null) {
			return;
		}

		// 所请求的资源拥有的权限(一个资源对多个权限)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			// 访问所请求资源所需要的权限
			String needPermission = configAttribute.getAttribute();
			System.out.println("====================》》》访问功能所需要的权限 is " + needPermission);
			// 用户所拥有的权限authentication
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				System.out.println("当前用户所拥有的权限 is " + ga.getAuthority());
				if (needPermission.equals(ga.getAuthority())) {
					return;
				}
				
			}
		}
		// 没有权限让我们去捕捉
		throw new AccessDeniedException(" 没有权限访问！");
	}
	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
