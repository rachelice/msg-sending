package ${bussiPackage}.${entityPackage}.controller;
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

import ${bussiPackage}.${entityPackage}.entity.${entityName};
import ${bussiPackage}.${entityPackage}.entityvo.${entityName}Vo;
import ${bussiPackage}.${entityPackage}.service.${entityName}Service;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: ${ftl_description}
 * @author auto Generate
 * @date ${ftl_create_time}
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="${entityName?uncap_first}")
public class ${entityName}Controller extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(${entityName}Controller.class);

	public ${entityName}Controller(){		
	}

	@Autowired
	private ${entityName}Service ${entityName?uncap_first}Service;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		${entityName} ${entityName?uncap_first}= new ${entityName}();
  
		return ResponseUtils.sendPagination(${entityName?uncap_first}Service.list(${entityName?uncap_first})) ;
	}
 
	@RequestMapping(value="update/{id}",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody ${entityName}Vo ${entityName?uncap_first}Vo) throws Exception{
		${entityName} ${entityName?uncap_first} =new ${entityName}();
		PropertyUtils.copyProperties(${entityName?uncap_first}, ${entityName?uncap_first}Vo);
		this.${entityName?uncap_first}Service.update(${entityName?uncap_first});
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody ${entityName}Vo ${entityName?uncap_first}Vo) throws Exception{
		${entityName} ${entityName?uncap_first} =new ${entityName}();
		PropertyUtils.copyProperties(${entityName?uncap_first}, ${entityName?uncap_first}Vo);
		return ResponseUtils.sendSuccess("保存成功",this.${entityName?uncap_first}Service.save(${entityName?uncap_first}).getId());
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody ${entityName} ${entityName?uncap_first}) throws Exception{
		this.${entityName?uncap_first}Service.delete(${entityName?uncap_first});
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
