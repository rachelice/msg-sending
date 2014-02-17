package com.sunshineroad.system.connaddress.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.AES;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.connaddress.entity.Connaddress;
import com.sunshineroad.system.connaddress.service.ConnaddressService;
import com.sunshineroad.system.connaddress.vo.ConnaddressVo;

/**
 * omplatformNew
 * com.sunshineroad.system.connaddress.controller
 * @{#} ConnaddressController.java Create on  2013-6-13 上午5:16:27
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：访问终端连接设置
 *
 */
@Controller
@RequestMapping(value="connaddrs")
public class ConnaddressController {
	
	@Autowired
	private ConnaddressService connaddrService;
	
	@Autowired
	private ActionlogService actionlogService;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list(){
		return ResponseUtils.sendPagination(connaddrService.list()) ;
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody ConnaddressVo connaddr) throws Exception{

		Connaddress connaddress = new Connaddress();
		if(connaddr.isAccountchg())
		{
			connaddress.setAccount(AES.encode(connaddr.getAccount()));
			
		}else{
			connaddress.setAccount(connaddr.getAccount());
		}
		if(connaddr.isIpaddresschg())
		{
			connaddress.setIpaddress(AES.encode(connaddr.getIpaddress()));
		}else{
			connaddress.setIpaddress(connaddr.getIpaddress());
		}
		if(connaddr.isPasswordchg())
		{
			connaddress.setPassword(AES.encode(connaddr.getPassword()));
		}else{
			connaddress.setPassword(connaddr.getPassword());
		}
		
		connaddress.setId(connaddr.getId());
		connaddress.setType(connaddr.getType());
		connaddress.setCommands(connaddr.getCommands());
		connaddress.setDescription(connaddr.getDescription());
		connaddress.setParameters(connaddr.getParameters());
		this.connaddrService.update(connaddress);
		String actDesc="更新连接";
		actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody ConnaddressVo connaddr) throws Exception{

		Connaddress connaddress = new Connaddress();
		connaddress.setIpaddress(AES.encode(connaddr.getIpaddress()));
		connaddress.setAccount(AES.encode(connaddr.getAccount()));
		connaddress.setPassword(AES.encode(connaddr.getPassword()));
		connaddress.setType(connaddr.getType());
		connaddress.setCommands(connaddr.getCommands());
		connaddress.setDescription(connaddr.getDescription());
		connaddress.setParameters(connaddr.getParameters());
		String actDesc="新建连接";
		actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("保存成功",this.connaddrService.save(connaddress));
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody ConnaddressVo connaddr) throws Exception{
		Connaddress connaddress = new Connaddress();
		connaddress.setId(connaddr.getId());
		this.connaddrService.delete(connaddress);
		String actDesc="删除连接";
		actionlogService.saveAlog("",actDesc,true,"");
		return ResponseUtils.sendSuccess("删除成功");
	}
	
	
	
/*	@RequestMapping(value="root",method=RequestMethod.GET)
	public @ResponseBody List<ErrorlogVo> root() throws Exception{
		return this.connaddrService.getRoot();
	}*/

	
}
