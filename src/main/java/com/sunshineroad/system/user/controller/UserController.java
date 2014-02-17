package com.sunshineroad.system.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.user.service.UserService;

/**
 * omplatform
 * com.sunshineroad.system.user.controller
 * @{#} UserController.java Create on  2013-6-13 上午9:45:47
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：系统用户菜单加载操作
 *
 */

@Controller
@RequestMapping(value="loginUser")
public class UserController { 
	
    @Autowired
    private UserService userService;
    
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object loginUser() throws Exception{
		return ResponseUtils.sendPagination(this.userService.loginUser());
	}

}
