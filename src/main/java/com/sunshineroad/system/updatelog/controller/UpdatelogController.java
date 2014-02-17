package com.sunshineroad.system.updatelog.controller;

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
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.system.updatelog.usercase.UpdatelogUC;
import com.sunshineroad.system.updatelog.vo.UpdatelogVo;

/**
 * omplatform
 * com.sunshineroad.system.resource.controller
 * @{#} ResourcesController.java Create on  2013-7-31 上午9:41:26
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：数据更新日志维护处理
 *
 */
@Controller
@RequestMapping("updatelogs")
public class UpdatelogController {
	
	@Autowired
	private UpdatelogService updatelogService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list() throws Exception{
		HttpServletRequest request =WebUtils.getRequestByContext();
		String userID=request.getParameter("userID");
		String actions=request.getParameter("actions");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String occurdates=request.getParameter("occurdates");
		
		UpdatelogVo updatelog = new UpdatelogVo();
		if(StringUtils.isNotBlank(actions)){
			updatelog.setAction("%"+actions+"%");
		}
		if(StringUtils.isNotBlank(occurdates)){
			updatelog.setOccurdate(sdf.parse(occurdates));
		}
		if(StringUtils.isNotBlank(userID)){
			updatelog.setUser_id("%"+userID+"%");
		}
		
		UpdatelogUC updateloguc = new UpdatelogUC();

		return ResponseUtils.sendPagination(updateloguc.getlist(updatelogService,updatelog)) ;
	}
    
}
