package com.sunshineroad.driverschool.mspenterprise.controller;
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

import com.sunshineroad.driverschool.mspenterprise.entity.MspEnterprise;
import com.sunshineroad.driverschool.mspenterprise.entityvo.MspEnterpriseVo;
import com.sunshineroad.driverschool.mspenterprise.service.MspEnterpriseService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 企业表
 * @author auto Generate
 * @date 2014-02-24 12:45:25
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="mspEnterprise")
public class MspEnterpriseController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MspEnterpriseController.class);

	public MspEnterpriseController(){		
	}

	@Autowired
	private MspEnterpriseService mspEnterpriseService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		MspEnterprise mspEnterprise= new MspEnterprise();
  
		return ResponseUtils.sendPagination(mspEnterpriseService.list(mspEnterprise)) ;
	}
 
	@RequestMapping(value="update",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody MspEnterpriseVo mspEnterpriseVo) throws Exception{
		MspEnterprise mspEnterprise =new MspEnterprise();
		PropertyUtils.copyProperties(mspEnterprise, mspEnterpriseVo);
		this.mspEnterpriseService.update(mspEnterprise);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody MspEnterpriseVo mspEnterpriseVo) throws Exception{
		MspEnterprise mspEnterprise =new MspEnterprise();
		PropertyUtils.copyProperties(mspEnterprise, mspEnterpriseVo);
		return ResponseUtils.sendSuccess("保存成功",this.mspEnterpriseService.save(mspEnterprise).getId());
	}
	
	@RequestMapping(value="delete}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody MspEnterprise mspEnterprise) throws Exception{
		this.mspEnterpriseService.delete(mspEnterprise);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
