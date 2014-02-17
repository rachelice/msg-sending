package com.sunshineroad.system.nxbranch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.nxbranch.entity.Nxbranch;
import com.sunshineroad.system.nxbranch.service.NxbranchService;

/**
 * omplatform
 * com.sunshineroad.system.nxbranch.controller
 * @{#} NxbranchController.java Create on  2013-6-13 上午9:39:08
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：农信机构选择处理及相关
 *
 */

@Controller
@RequestMapping(value="nxbranchs")
public class NxbranchController {
	
	@Autowired
	private NxbranchService mService;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list(){
		return ResponseUtils.sendPagination(mService.list()) ;
	}

	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody Nxbranch Nxbranch) throws Exception{
		this.mService.update(Nxbranch);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody Nxbranch Nxbranch) throws Exception{
		return ResponseUtils.sendSuccess("保存成功",this.mService.save(Nxbranch));
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody Nxbranch Nxbranch) throws Exception{
		this.mService.delete(Nxbranch);
		return ResponseUtils.sendSuccess("删除成功");
	}
		
}
