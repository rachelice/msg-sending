package com.sunshineroad.system.updatelog.usercase;

import java.util.List;

import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.system.updatelog.vo.UpdatelogVo;

/**
 * omplatform
 * com.sunshineroad.system.actionlog.usercase
 * @{#} ActionlogUC.java Create on  2013-7-31 上午3:30:07
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">张光明</a>
 * @version 1.0
 * 功能说明：
 *
 */
public class UpdatelogUC
{
	
	public List<UpdatelogVo> getlist(UpdatelogService updatelogService,UpdatelogVo updatelogVo) throws Exception{
	
		return updatelogService.list(updatelogVo);
	}
}
