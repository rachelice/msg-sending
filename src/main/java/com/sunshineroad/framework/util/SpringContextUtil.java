package com.sunshineroad.framework.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * omplatform
 * com.sunshineroad.framework.util
 * @{#} SpringContextUtil.java Create on  2013-6-13 上午8:58:09
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：获取spring容器，以访问容器中定义的其他bean
 *
 */

public class SpringContextUtil implements ApplicationContextAware{

	private static ApplicationContext	applicationContext;

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 */
	public void setApplicationContext(ApplicationContext applicationContext){
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	/**
	 * 获取对象
	 * @return  Object 一个以所给名字注册的bean的实例 (service注解方式，自动生成以首字母小写的类名为bean name)
	 */
	public static Object getBean(String name) throws BeansException{
		return applicationContext.getBean(name);
	}
}