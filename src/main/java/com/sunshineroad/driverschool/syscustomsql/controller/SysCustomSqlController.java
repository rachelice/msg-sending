package com.sunshineroad.driverschool.syscustomsql.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.driverschool.syscustomsql.entity.SysCustomSql;
import com.sunshineroad.driverschool.syscustomsql.entityvo.SysCustomSqlVo;
import com.sunshineroad.driverschool.syscustomsql.service.SysCustomSqlService;
import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.WebUtils;
/**   
 * @Title: Controller
 * @Description: 报表
 * @author auto Generate
 * @date 2014-01-26 17:58:34
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="sysCustomSql")
public class SysCustomSqlController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SysCustomSqlController.class);

	public SysCustomSqlController(){		
	}

	@Autowired
	private SysCustomSqlService sysCustomSqlService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		SysCustomSql sysCustomSql= new SysCustomSql();
  
		return ResponseUtils.sendPagination(sysCustomSqlService.list(sysCustomSql)) ;
	}
 
	@RequestMapping(value="update/{id}",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody SysCustomSqlVo sysCustomSqlVo) throws Exception{
		SysCustomSql sysCustomSql =new SysCustomSql();
		PropertyUtils.copyProperties(sysCustomSql, sysCustomSqlVo);
		this.sysCustomSqlService.update(sysCustomSql);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody SysCustomSqlVo sysCustomSqlVo) throws Exception{
		SysCustomSql sysCustomSql =new SysCustomSql();
		PropertyUtils.copyProperties(sysCustomSql, sysCustomSqlVo);
		return ResponseUtils.sendSuccess("保存成功",this.sysCustomSqlService.save(sysCustomSql).getId());
	}
	
	@RequestMapping(value="delete/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody SysCustomSql sysCustomSql) throws Exception{
		this.sysCustomSqlService.delete(sysCustomSql);
		return ResponseUtils.sendSuccess("删除成功");
	}
    

	@RequestMapping(value="getContentStrBySql",method=RequestMethod.GET)
	public @ResponseBody  Map<String,Object>  getContentStrBySql(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String id=request.getParameter("id");
		if(null==id||id.length()==0){
			return null;
		} 
		SysCustomSql scs=this.sysCustomSqlService.getSysCustomSqlById(Integer.valueOf(id));
		if(null==scs||null==scs.getSql()){
			return null;
		}
		String result[]=this.sysCustomSqlService.getContentStrBySql(scs.getSql());
		StringBuffer sbf=new StringBuffer();
		for(String s:result){
			sbf.append( s+",");
		}
		StringBuffer fields= new StringBuffer(" ");
		StringBuffer fieldheader= new StringBuffer(" ");
		if(result.length>0){
			String[] strs=result[0].split(",");
			for(String s:strs){
				String str=s.replaceAll("\\'", "").replaceAll("\\{", "").replaceAll("\\}", "").trim();
				str=str.split("\\:")[0];
				fieldheader.append("{dataIndex:'"+str+"',text:'"+str+"',flex:1,defaultValue:''},");
				fields.append("'"+str+"',");
			}
			
		}
		//fieldheader=new StringBuffer("fieldheader:["+fieldheader.substring(0, fieldheader.length()-1)+"]");
		//fields=new StringBuffer("fields:["+fields.substring(0, fields.length()-1)+"]");
		//sbf=new StringBuffer("contentstr:["+sbf.substring(0, sbf.length()-1)+"]");
		//return "{"+fields.toString()+","+fieldheader.toString()+","+sbf.toString()+"}";
		Map<String,Object> resultMap= new HashMap<String,Object>();
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("fields","["+ fields.substring(0, fields.length()-1)+"]");  
		map.put("fieldheader", "["+fieldheader.substring(0, fieldheader.length()-1)+"]");  
		map.put("contentstr", "["+sbf.substring(0, sbf.length()-1)+"]");   
		resultMap.put("success", true);
		resultMap.put("result", map);
		//resultMap.put("fields", fields.substring(0, fields.length()-1));   
		//resultMap.put("contentstr", sbf.substring(0, sbf.length()-1));
		return resultMap;
	}
  
}
