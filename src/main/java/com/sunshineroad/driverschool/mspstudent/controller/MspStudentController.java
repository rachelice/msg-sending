package com.sunshineroad.driverschool.mspstudent.controller;
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

import com.sunshineroad.driverschool.mspstudent.entity.MspStudent;
import com.sunshineroad.driverschool.mspstudent.entityvo.MspStudentVo;
import com.sunshineroad.driverschool.mspstudent.service.MspStudentService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 学员表
 * @author auto Generate
 * @date 2014-02-20 11:03:27
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="mspStudent")
public class MspStudentController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MspStudentController.class);

	public MspStudentController(){		
	}

	@Autowired
	private MspStudentService mspStudentService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		MspStudent mspStudent= new MspStudent();
  
		return ResponseUtils.sendPagination(mspStudentService.list(mspStudent)) ;
	}
 
	@RequestMapping(value="update",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody MspStudentVo mspStudentVo) throws Exception{
		MspStudent mspStudent =new MspStudent();
		PropertyUtils.copyProperties(mspStudent, mspStudentVo);
		this.mspStudentService.update(mspStudent);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody MspStudentVo mspStudentVo) throws Exception{
		MspStudent mspStudent =new MspStudent();
		PropertyUtils.copyProperties(mspStudent, mspStudentVo);
		return ResponseUtils.sendSuccess("保存成功",this.mspStudentService.save(mspStudent).getId());
	}
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody MspStudent mspStudent) throws Exception{
		this.mspStudentService.delete(mspStudent);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
