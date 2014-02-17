package com.sunshineroad.system.actionlog.usercase;

import java.util.List;

import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.actionlog.vo.ActionlogVo;

/**
 * omplatform
 * com.sunshineroad.system.actionlog.usercase
 * @{#} ActionlogUC.java Create on  2013-7-12 上午3:30:07
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
public class ActionlogUC
{
	
	public List<ActionlogVo> getlist(ActionlogService actlogService,ActionlogVo actvo) throws Exception{
	
		return (actlogService.list(actvo));
	}
}
