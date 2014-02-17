package com.sunshineroad.system.actionlog.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.actionlog.usercase.ActionlogUC;
import com.sunshineroad.system.actionlog.vo.ActionlogVo;

/**
 * omplatform
 * com.sunshineroad.system.resource.controller
 * @{#} ResourcesController.java Create on  2013-6-15 上午9:41:26
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：系统操作日志维护处理
 *
 */
@Controller
@RequestMapping("actionlogs")
public class ActionlogController {
	
	@Autowired
	private ActionlogService actlogService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list() throws Exception{
		HttpServletRequest request =WebUtils.getRequestByContext();
		String userID=request.getParameter("userID");
		String actions=request.getParameter("actions");
		String result=request.getParameter("result");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String occurdates=request.getParameter("occurdates");
		
		ActionlogVo actvo = new ActionlogVo();
		if(StringUtils.isNotBlank(actions)){
			actvo.setAction("%"+actions+"%");
		}
		if(StringUtils.isNotBlank(result)){
			actvo.setStatus(result);
		}
		if(StringUtils.isNotBlank(occurdates)){
			actvo.setOccurdate(sdf.parse(occurdates));
		}
		if(StringUtils.isNotBlank(userID)){
			actvo.setUser_id("%"+userID+"%");
		}
		
		ActionlogUC actuc = new ActionlogUC();

		return ResponseUtils.sendPagination(actuc.getlist(actlogService,actvo)) ;
	}
    
}
