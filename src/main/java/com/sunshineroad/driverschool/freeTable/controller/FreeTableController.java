package com.sunshineroad.driverschool.freeTable.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshineroad.driverschool.syscustomsql.entity.SysCustomSql;
import com.sunshineroad.driverschool.syscustomsql.service.SysCustomSqlService;
import com.sunshineroad.driverschool.freeTable.service.FreeTableService;
import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;


@Controller
@RequestMapping(value="freeTableController")
public class FreeTableController extends BaseControllerImpl {
	
	/**
	 * Logger for this class
	 */
//	private static final Logger logger = Logger.getLogger(FreeTableController.class);

	public FreeTableController(){		
	}

	@Autowired
	private FreeTableService freeTableService;
	
	/**
     * 将数据处理为JSON格式的字符串
     * @param tablename    对应表名
     * @return    字符串数组，每一项为一条数据库记录
     */
	

	@Autowired
	private SysCustomSqlService sysCustomSqlService;

	@RequestMapping(value="getContentStrBySql",method=RequestMethod.GET)
	public @ResponseBody  String  getContentStrBySql(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String id=request.getParameter("id");
		if(null==id||id.length()==0){
			return null;
		} 
		SysCustomSql scs=this.sysCustomSqlService.getSysCustomSqlById(Integer.valueOf(id));
		if(null==scs||null==scs.getSql()){
			return null;
		}
		return this.freeTableService.getContentStrBySql(scs.getSql()).toString();
	}


}
