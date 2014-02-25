package com.sunshineroad.driverschool.sysparameter.controller;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.driverschool.sysparameter.entity.SysParameter;
import com.sunshineroad.driverschool.sysparameter.entityvo.SysParameterVo;
import com.sunshineroad.driverschool.sysparameter.service.SysParameterService;
import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.TreeNode;
import com.sunshineroad.framework.util.WebUtils;
/**   
 * @Title: Controller
 * @Description: 参数
 * @author auto Generate
 * @date 2014-01-09 10:34:32
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="sysParameter")
public class SysParameterController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
//	private static final Logger logger = Logger.getLogger(SysParameterController.class);

	public SysParameterController(){		
	}

	@Autowired
	private SysParameterService sysParameterService;
	 
 //sysParameterVo2TreeNode
	

	@RequestMapping(value="getTreeNodeChildren",method=RequestMethod.GET)
	public @ResponseBody Object getTreeNodeChildren(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id=request.getParameter("id");
		if(null==id||id.length()==0){
			return null;
		} 	   
		return ResponseUtils.sendPagination(sysParameterService.getChildrenById(Long.valueOf(id))) ;
		}
	 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
	 	 SysParameterVo	sysParameterVo= new SysParameterVo();
	  
		
	 	 String id=request.getParameter("id");
		 if(null!=id){
			 sysParameterVo.setId(Long.valueOf(id));
		 }else{
			 sysParameterVo.setId(1l);
		 }

	 	 String params=request.getParameter("params");
	 	 try {
	 		if(null!=params){
				byte b[] = params.getBytes("ISO-8859-1");
				params = new String(b);
	 		}
	 	} catch (UnsupportedEncodingException e) {
	 		 params=null;
		}
	 	if(null!=params){
			 sysParameterVo.setParName(params);
			}
		 
		return ResponseUtils.sendPagination(sysParameterService.list(sysParameterVo)) ;
	 
	}
 
	@RequestMapping(value="update/{id}",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody SysParameterVo sysParameterVo) throws Exception{
		SysParameter sysParameter =new SysParameter();
		PropertyUtils.copyProperties(sysParameter, sysParameterVo);
		this.sysParameterService.update(sysParameter);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody SysParameterVo sysParameterVo) throws Exception{
		SysParameter sysParameter =new SysParameter();
		PropertyUtils.copyProperties(sysParameter, sysParameterVo);
		return ResponseUtils.sendSuccess("保存成功",this.sysParameterService.save(sysParameter).getId());
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody SysParameter sysParameter) throws Exception{
		this.sysParameterService.delete(sysParameter);
		return ResponseUtils.sendSuccess("删除成功");
	}
	
	@RequestMapping(value="root",method=RequestMethod.GET)
	public @ResponseBody List<TreeNode> root() throws Exception{
		 HttpServletRequest request =WebUtils.getRequestByContext();
			String id=request.getParameter("id"); 
		if(null==id||id.length()==0){
			return null;
		}else{
			Integer pid=Integer.valueOf(id);
			List<TreeNode> nodeList= sysParameterService.getChildrenById(Long.valueOf(id));
			
			return	nodeList;
			 
		}
		//return this.deptService.getRoot();
	}
	
 
  
}
