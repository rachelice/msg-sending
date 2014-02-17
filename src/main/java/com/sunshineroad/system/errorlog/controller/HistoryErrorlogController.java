package com.sunshineroad.system.errorlog.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.errorlog.entity.Errorlog;
import com.sunshineroad.system.errorlog.service.ErrorlogService;
import com.sunshineroad.system.errorlog.vo.ErrorlogVo;
import com.sunshineroad.system.monitor.service.MonitorService;

/**
 * omplatform
 * com.sunshineroad.system.errorlog.controller
 * @{#} HistoryErrorlogController.java Create on  2013-6-13 上午9:34:27
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：监控历史操作
 *
 */

@Controller
@RequestMapping(value="historyerrorlogs")
public class HistoryErrorlogController {
	
	@Autowired
	private ErrorlogService elogService;
	
	@Autowired
	private MonitorService monitorService;

	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody Object list() throws ParseException{
		ErrorlogVo elog= getParameterByReq();
		return ResponseUtils.sendPagination(elogService.MonitorHistoryList(elog));
	}
	
	private ErrorlogVo getParameterByReq() throws ParseException{
		ErrorlogVo elog= new ErrorlogVo();
		HttpServletRequest request =WebUtils.getRequestByContext();
		String terminal=request.getParameter("terminal");
		String startTime=request.getParameter("starttime");
		String endTime=request.getParameter("endtime");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if(StringUtils.isNotBlank(terminal)){
			elog.setTerminal(terminal);
		}
		if(StringUtils.isNotBlank(startTime)){
			startTime=startTime.substring(0, 10)+" 00:00:00";
			elog.setStartTime(sdf.parse(startTime));
		}
		if(StringUtils.isNotBlank(endTime)){
			endTime=endTime.substring(0, 10)+" 23:59:59";
			elog.setEndTime(sdf.parse(endTime));
		}
		
		return elog;
	}
	
	@RequestMapping(value="exports",method=RequestMethod.GET)
	public @ResponseBody Object exports() throws Exception{
		ErrorlogVo elog= getParameterByReq();
		StringBuffer fileName=new StringBuffer("");
		boolean result = this.elogService.ExportListToExcel(elog, fileName);
		if(result){
			return ResponseUtils.sendSuccess(fileName.toString());
		}
		
		return ResponseUtils.sendFailure("导出失败","export excel fail");
		
	}
	
	@RequestMapping(value="monitors",method=RequestMethod.GET)
	public @ResponseBody Object monitors() throws Exception{
		return this.monitorService.getRoot();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody Errorlog elog) throws Exception{
		this.elogService.update(elog);
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
