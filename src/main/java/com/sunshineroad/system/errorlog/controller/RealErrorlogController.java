package com.sunshineroad.system.errorlog.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.errorlog.entity.Errorlog;
import com.sunshineroad.system.errorlog.service.ErrorlogService;
import com.sunshineroad.system.errorlog.vo.ErrorlogVo;
import com.sunshineroad.system.user.service.UserService;

/**
 * omplatform
 * com.sunshineroad.system.errorlog.controller
 * @{#} RealErrorlogController.java Create on  2013-6-13 上午9:35:28
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：实时监控页面实现
 *
 */

@Controller
@RequestMapping(value="realerrorlogs")
public class RealErrorlogController {
	
	@Autowired
	private ErrorlogService elogService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list(){
		return ResponseUtils.sendPagination(elogService.MonitorList());
	}

	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody Errorlog elog) throws Exception{
		Errorlog errorlog = this.elogService.getErrorlogDao().get(elog.getId());
		errorlog.setUser_id(userService.getSelfUserModelBy().getLoginName());
		errorlog.setResponsedate(new Date());
		this.elogService.update(errorlog);
		System.out.println("errorlog save: "+errorlog.toString());
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody Errorlog elog) throws Exception{
		return ResponseUtils.sendSuccess("保存成功",this.elogService.save(elog));
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody Errorlog elog) throws Exception{
		this.elogService.delete(elog);
		return ResponseUtils.sendSuccess("删除成功");
	}
	
	
	
	@RequestMapping(value="root",method=RequestMethod.GET)
	public @ResponseBody List<ErrorlogVo> root() throws Exception{
		return this.elogService.getRoot();
	}

	
}
