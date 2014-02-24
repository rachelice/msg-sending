package com.sunshineroad.driverschool.mspmsgtask.controller;
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

import com.sunshineroad.driverschool.mspmsgtask.entity.MspMsgTask;
import com.sunshineroad.driverschool.mspmsgtask.entityvo.MspMsgTaskVo;
import com.sunshineroad.driverschool.mspmsgtask.service.MspMsgTaskService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 短信任务
 * @author auto Generate
 * @date 2014-02-24 12:47:02
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="mspMsgTask")
public class MspMsgTaskController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MspMsgTaskController.class);

	public MspMsgTaskController(){		
	}

	@Autowired
	private MspMsgTaskService mspMsgTaskService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		MspMsgTask mspMsgTask= new MspMsgTask();
  
		return ResponseUtils.sendPagination(mspMsgTaskService.list(mspMsgTask)) ;
	}
 
	@RequestMapping(value="update/{id}",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody MspMsgTaskVo mspMsgTaskVo) throws Exception{
		MspMsgTask mspMsgTask =new MspMsgTask();
		PropertyUtils.copyProperties(mspMsgTask, mspMsgTaskVo);
		this.mspMsgTaskService.update(mspMsgTask);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody MspMsgTaskVo mspMsgTaskVo) throws Exception{
		MspMsgTask mspMsgTask =new MspMsgTask();
		PropertyUtils.copyProperties(mspMsgTask, mspMsgTaskVo);
		return ResponseUtils.sendSuccess("保存成功",this.mspMsgTaskService.save(mspMsgTask).getId());
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody MspMsgTask mspMsgTask) throws Exception{
		this.mspMsgTaskService.delete(mspMsgTask);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
