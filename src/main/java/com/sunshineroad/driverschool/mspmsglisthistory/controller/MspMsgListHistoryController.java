package com.sunshineroad.driverschool.mspmsglisthistory.controller;
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

import com.sunshineroad.driverschool.mspmsglisthistory.entity.MspMsgListHistory;
import com.sunshineroad.driverschool.mspmsglisthistory.entityvo.MspMsgListHistoryVo;
import com.sunshineroad.driverschool.mspmsglisthistory.service.MspMsgListHistoryService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 短信清单历史记录
 * @author auto Generate
 * @date 2014-02-24 12:50:16
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="mspMsgListHistory")
public class MspMsgListHistoryController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MspMsgListHistoryController.class);

	public MspMsgListHistoryController(){		
	}

	@Autowired
	private MspMsgListHistoryService mspMsgListHistoryService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		MspMsgListHistory mspMsgListHistory= new MspMsgListHistory();
  
		return ResponseUtils.sendPagination(mspMsgListHistoryService.list(mspMsgListHistory)) ;
	}
 
	@RequestMapping(value="update/{id}",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody MspMsgListHistoryVo mspMsgListHistoryVo) throws Exception{
		MspMsgListHistory mspMsgListHistory =new MspMsgListHistory();
		PropertyUtils.copyProperties(mspMsgListHistory, mspMsgListHistoryVo);
		this.mspMsgListHistoryService.update(mspMsgListHistory);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody MspMsgListHistoryVo mspMsgListHistoryVo) throws Exception{
		MspMsgListHistory mspMsgListHistory =new MspMsgListHistory();
		PropertyUtils.copyProperties(mspMsgListHistory, mspMsgListHistoryVo);
		return ResponseUtils.sendSuccess("保存成功",this.mspMsgListHistoryService.save(mspMsgListHistory).getId());
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody MspMsgListHistory mspMsgListHistory) throws Exception{
		this.mspMsgListHistoryService.delete(mspMsgListHistory);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
