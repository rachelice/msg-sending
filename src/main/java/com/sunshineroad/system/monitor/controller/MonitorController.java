package com.sunshineroad.system.monitor.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.monitor.entity.Monitor;
import com.sunshineroad.system.monitor.service.MonitorService;

/**
 * omplatform
 * com.sunshineroad.system.monitor.controller
 * @{#} MonitorController.java Create on  2013-6-13 上午9:38:00
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：监控终端信息处理
 *
 */

@Controller
@RequestMapping(value="monitors")
public class MonitorController {
	
	@Autowired
	private MonitorService mService;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list(){
		return ResponseUtils.sendPagination(mService.list()) ;
	}
	
	@RequestMapping(value="root",method=RequestMethod.GET)
	public @ResponseBody Object root() throws Exception{
		return this.mService.getRoot();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody Monitor monitor) throws Exception{
		this.mService.update(monitor);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody Monitor monitor) throws Exception{
		return ResponseUtils.sendSuccess("保存成功",this.mService.save(monitor));
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody Monitor monitor) throws Exception{
		this.mService.delete(monitor);
		return ResponseUtils.sendSuccess("删除成功");
	}
		
}
