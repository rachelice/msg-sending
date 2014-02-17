package com.sunshineroad.system.resource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.system.resource.service.ResourceService;
import com.sunshineroad.system.resource.vo.ResourceNode;

/**
 * omplatform
 * com.sunshineroad.system.resource.controller
 * @{#} ResourceController.java Create on  2013-6-13 上午9:40:50
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：系统资源菜单加载处理
 *
 */
@Controller
@RequestMapping("resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value="root",method=RequestMethod.GET)
	public @ResponseBody List<ResourceNode> root() throws Exception{
		return this.resourceService.getRoot();
	}
	
	@RequestMapping(value="child",method=RequestMethod.GET)
	public @ResponseBody List<ResourceNode> child(@RequestParam("id") Integer id) throws Exception{
		return this.resourceService.getChildren(id);
	}
    
}
