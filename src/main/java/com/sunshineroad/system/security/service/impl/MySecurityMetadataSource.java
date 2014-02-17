package com.sunshineroad.system.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.sunshineroad.system.resource.dao.ResourceDAO;
import com.sunshineroad.system.resource.entity.ResourceModel;

//1 加载资源与权限的对应关系
/**
 * omplatform
 * com.sunshineroad.system.security.service.impl
 * @{#} MySecurityMetadataSource.java Create on  2013-6-13 上午9:52:20
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：登陆用户权限加载
 *
 */

@Service("mySecurityMetadataSource")
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
 
     
	@Autowired
	protected ResourceDAO<ResourceModel, Integer> resourceDAO;
	
	public ResourceDAO<ResourceModel, Integer> getResourceDAO(){
		return this.resourceDAO;
	}



	// 返回所请求资源所需要的权限
	public Collection<ConfigAttribute> getAttributes(Object object)	throws IllegalArgumentException {
		System.out.println(">>>>>>>>>>333333333333<<<<<<<<<< 返回所请求资源所需要的权限3 ");
		String requestUrl = ((FilterInvocation) object).getRequestUrl().substring(1);
		if(requestUrl.indexOf('?')!=-1){
			requestUrl =requestUrl.substring(0, requestUrl.indexOf('?'));
		}
		//System.out.println("/aad/fea/87732-----" + "/aad/fea/87732".replaceAll("\\/\\d+", ""));
		if(requestUrl.indexOf('/')!=-1){
			//requestUrl =requestUrl.substring(0, requestUrl.indexOf('/'));
			requestUrl=requestUrl.replaceAll("\\/\\d+", "");
		}
		
		System.out.println("requestUrl is        2--------" + requestUrl);
		if (resourceMap == null) {
			loadResourceDefine();
		}
		//return 
		System.out.println("====================================>"+resourceMap.toString());
		if(resourceMap.get(requestUrl)==null){
			Collection<ConfigAttribute> returnCollection = new ArrayList<ConfigAttribute>(); 
			returnCollection.add(new SecurityConfig("ROLE_NO_USER")); 
			return returnCollection;			
		}
		
		return resourceMap.get(requestUrl);
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	// 加载所有资源与权限的关系
	public static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	public void loadResourceDefine() {
		 
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
			ConfigAttribute configAttribute = new SecurityConfig("ROLE_");
			List<ResourceModel> resources = this.resourceDAO.findAll();
			
			configAttributes = new ArrayList<ConfigAttribute>();
			configAttribute = new SecurityConfig("ROLE_" + "index.jsp");
			configAttributes.add(configAttribute);
			resourceMap.put("index.jsp", configAttributes);
			
			configAttributes = new ArrayList<ConfigAttribute>();
			configAttribute= new SecurityConfig("ROLE_菜单权限");
			configAttributes.add(configAttribute);
			resourceMap.put("resource", configAttributes);

			configAttributes = new ArrayList<ConfigAttribute>();
			configAttribute= new SecurityConfig("ROLE_resource/root");
			configAttributes.add(configAttribute);
			resourceMap.put("resource/root", configAttributes);


			configAttributes = new ArrayList<ConfigAttribute>();
			configAttribute= new SecurityConfig("ROLE_resource/child");
			configAttributes.add(configAttribute);
			resourceMap.put("resource/child", configAttributes);  
			
			configAttributes = new ArrayList<ConfigAttribute>();
			configAttribute= new SecurityConfig("ROLE_loginUser");
			configAttributes.add(configAttribute);
			resourceMap.put("loginUser", configAttributes);
			if(resources==null){  
				  configAttributes = new ArrayList<ConfigAttribute>();
				// TODO:ZZQ 通过资源名称来表示具体的权限 注意：必须"ROLE_"开头
				// 关联代码：applicationContext-security.xml
				// 关联代码：com.huaxin.security.MyUserDetailServiceImpl#obtionGrantedAuthorities
				  configAttribute = new SecurityConfig("ROLE_" + "index.jsp");
				configAttributes.add(configAttribute);
				resourceMap.put("index.jsp", configAttributes);
			}else{
				
				for (ResourceModel resource : resources) {
					  configAttributes = new ArrayList<ConfigAttribute>();
					// TODO:ZZQ 通过资源名称来表示具体的权限 注意：必须"ROLE_"开头
					// 关联代码：applicationContext-security.xml
					// 关联代码：com.huaxin.security.MyUserDetailServiceImpl#obtionGrantedAuthorities
					  configAttribute = new SecurityConfig("ROLE_" + resource.getUrl());
					configAttributes.add(configAttribute);
					resourceMap.put(resource.getUrl(), configAttributes);
				}
			}
		 
	}

}
