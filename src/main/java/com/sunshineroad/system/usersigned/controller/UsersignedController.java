package com.sunshineroad.system.usersigned.controller;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.usersigned.entity.Usersigned;
import com.sunshineroad.system.usersigned.service.UsersignedService;

/**
 * omplatformNew
 * com.sunshineroad.system.usersigned.controller
 * @{#} UsersignedController.java Create on  2013-6-13 上午5:09:15
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：用户签到
 *
 */
@Controller
@RequestMapping(value="loginUser/usersigned")
public class UsersignedController {
	
	@Autowired
	private UsersignedService usersignedService;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list(){
		return ResponseUtils.sendPagination(usersignedService.list()) ;
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody Usersigned usersigned) throws Exception{
		this.usersignedService.update(usersigned);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody Usersigned usersigned) throws Exception{

		Date occurdate=new Date();
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		SimpleDateFormat gettoday = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat gettime = new SimpleDateFormat("HH:mm:ss");
		usersigned.setOccurdate(occurdate);
		usersigned.setTimestamp(timestamp);
		usersigned.setOccurday(gettoday.format(occurdate));
		usersigned.setOccurtime(gettime.format(occurdate));
		if(!usersignedService.IsSigned(usersigned.getUser_id(), usersigned.getOccurday(), usersigned.getFlag()))
		{
			return ResponseUtils.sendSuccess("保存成功",this.usersignedService.save(usersigned));
		}else{
			return ResponseUtils.sendFailure("该用户已签到，无需再次签到！",usersigned.getId());
		}

	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody Usersigned usersigned) throws Exception{
		this.usersignedService.delete(usersigned);
		return ResponseUtils.sendSuccess("删除成功");
	}
	
	
	
/*	@RequestMapping(value="root",method=RequestMethod.GET)
	public @ResponseBody List<ErrorlogVo> root() throws Exception{
		return this.connaddrService.getRoot();
	}*/

	
}
