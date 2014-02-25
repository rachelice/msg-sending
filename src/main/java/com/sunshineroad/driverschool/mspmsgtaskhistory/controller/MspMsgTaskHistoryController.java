package com.sunshineroad.driverschool.mspmsgtaskhistory.controller;
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

import com.sunshineroad.driverschool.mspmsgtaskhistory.entity.MspMsgTaskHistory;
import com.sunshineroad.driverschool.mspmsgtaskhistory.entityvo.MspMsgTaskHistoryVo;
import com.sunshineroad.driverschool.mspmsgtaskhistory.service.MspMsgTaskHistoryService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 短信任务
 * @author auto Generate
 * @date 2014-02-24 12:48:04
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="mspMsgTaskHistory")
public class MspMsgTaskHistoryController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MspMsgTaskHistoryController.class);

	public MspMsgTaskHistoryController(){		
	}

	@Autowired
	private MspMsgTaskHistoryService mspMsgTaskHistoryService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		MspMsgTaskHistory mspMsgTaskHistory= new MspMsgTaskHistory();
  
		return ResponseUtils.sendPagination(mspMsgTaskHistoryService.list(mspMsgTaskHistory)) ;
	}
 
	@RequestMapping(value="update",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody MspMsgTaskHistoryVo mspMsgTaskHistoryVo) throws Exception{
		MspMsgTaskHistory mspMsgTaskHistory =new MspMsgTaskHistory();
		PropertyUtils.copyProperties(mspMsgTaskHistory, mspMsgTaskHistoryVo);
		this.mspMsgTaskHistoryService.update(mspMsgTaskHistory);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody MspMsgTaskHistoryVo mspMsgTaskHistoryVo) throws Exception{
		MspMsgTaskHistory mspMsgTaskHistory =new MspMsgTaskHistory();
		PropertyUtils.copyProperties(mspMsgTaskHistory, mspMsgTaskHistoryVo);
		return ResponseUtils.sendSuccess("保存成功",this.mspMsgTaskHistoryService.save(mspMsgTaskHistory).getId());
	}
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody MspMsgTaskHistory mspMsgTaskHistory) throws Exception{
		this.mspMsgTaskHistoryService.delete(mspMsgTaskHistory);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
