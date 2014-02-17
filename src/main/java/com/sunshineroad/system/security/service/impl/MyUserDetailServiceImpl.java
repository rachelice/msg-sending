package com.sunshineroad.system.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sunshineroad.system.resource.entity.ResourceModel;
import com.sunshineroad.system.role.entity.Role;
import com.sunshineroad.system.user.dao.UserDao;
import com.sunshineroad.system.user.model.UserModel;

/**
 * omplatform
 * com.sunshineroad.system.security.service.impl
 * @{#} MyUserDetailServiceImpl.java Create on  2013-6-13 上午9:53:12
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：登记登陆用户信息
 *
 */

@Service("myUserDetailServiceImpl")
public class MyUserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
    public UserDao userDao;

	// 登录验证
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(">>>>>>>>>>111<<<<<<<<<< username is " + username);
		
		//取得用户的权限
		 UserModel userModel = this.userDao.findByUsername(username);
		 
 
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(userModel);

		// 封装成spring security的user
		User userdetail = new User(
				userModel.getLoginName(), 
				userModel.getPassword(),
				true, 
				true, 
				true,
				true, 
				grantedAuths	//用户的权限
			);
		return userdetail;
	}

	// 取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(UserModel userModel) {
		List<ResourceModel> resources = new ArrayList<ResourceModel>();
		List<Role> roles =  userModel.getRoles();
		for (Role role : roles) {
			List<ResourceModel> tempRes = role.getResources();
			for (ResourceModel res : tempRes) {
				resources.add(res);
				System.out.println("我的资源路径---->"+res.getText()+res.getUrl());
			}
		}
		
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		
		//authSet.add(new SimpleGrantedAuthority("userModels"));
		//authSet.add(new SimpleGrantedAuthority("ROLE_NO_USER"));
		authSet.add(new SimpleGrantedAuthority("ROLE_" +"index.jsp"));
		authSet.add(new SimpleGrantedAuthority("ROLE_菜单权限"));
		authSet.add(new SimpleGrantedAuthority("ROLE_loginUser"));
		authSet.add(new SimpleGrantedAuthority("ROLE_resource/root"));
		
		for (ResourceModel res : resources) {
			// TODO:ZZQ 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
			// 关联代码：applicationContext-security.xml
			// 关联代码：com.huaxin.security.MySecurityMetadataSource#loadResourceDefine
			authSet.add(new SimpleGrantedAuthority("ROLE_" + res.getUrl()));
			//authSet.add(new SimpleGrantedAuthority("ROLE_" + res.getText()));
			
		}
		return authSet;
	}}
