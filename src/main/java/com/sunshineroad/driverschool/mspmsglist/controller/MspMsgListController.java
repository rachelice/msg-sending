package com.sunshineroad.driverschool.mspmsglist.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sunshineroad.framework.support.service.IBaseService;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.WebUtils; 

import com.sunshineroad.driverschool.mspmsglist.entity.MspMsgList;
import com.sunshineroad.driverschool.mspmsglist.entityvo.MspMsgListVo;
import com.sunshineroad.driverschool.mspmsglist.service.MspMsgListService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 短信清单
 * @author auto Generate
 * @date 2014-02-24 12:49:23
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="mspMsgList")
public class MspMsgListController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MspMsgListController.class);

	public MspMsgListController(){		
	}

	@Autowired
	private MspMsgListService mspMsgListService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		MspMsgList mspMsgList= new MspMsgList();
  
		return ResponseUtils.sendPagination(mspMsgListService.list(mspMsgList)) ;
	}
 
	@RequestMapping(value="update",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody MspMsgListVo mspMsgListVo) throws Exception{
		MspMsgList mspMsgList =new MspMsgList();
		PropertyUtils.copyProperties(mspMsgList, mspMsgListVo);
		this.mspMsgListService.update(mspMsgList);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody MspMsgListVo mspMsgListVo) throws Exception{
		MspMsgList mspMsgList =new MspMsgList();
		PropertyUtils.copyProperties(mspMsgList, mspMsgListVo);
		return ResponseUtils.sendSuccess("保存成功",this.mspMsgListService.save(mspMsgList).getId());
	}
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody MspMsgList mspMsgList) throws Exception{
		this.mspMsgListService.delete(mspMsgList);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
