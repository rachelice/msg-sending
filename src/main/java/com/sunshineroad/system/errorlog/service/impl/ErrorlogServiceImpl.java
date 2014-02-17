package com.sunshineroad.system.errorlog.service.impl;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.util.ExcelUtil;
import com.sunshineroad.framework.util.ListUtils;
import com.sunshineroad.system.errorlog.dao.ErrorlogDao;
import com.sunshineroad.system.errorlog.entity.Errorlog;
import com.sunshineroad.system.errorlog.service.ErrorlogService;
import com.sunshineroad.system.errorlog.vo.ErrorlogVo;

/**
 * omplatform
 * com.sunshineroad.system.errorlog.service.impl
 * @{#} ErrorlogServiceImpl.java Create on  2013-6-13 上午4:41:30
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：监控异常信息记录处理
 *
 */
@Service("errorlogService")
public class ErrorlogServiceImpl implements ErrorlogService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected ErrorlogDao<Errorlog, Integer> elogDao;
	
	public ErrorlogDao<Errorlog, Integer> getErrorlogDao(){
		return this.elogDao;
	}
	
	public List<ErrorlogVo> List(List<Errorlog>	elogList) {
		HQLParameter p = new HQLParameter(Errorlog.class);
		System.out.println(p);
		List<ErrorlogVo> elogvoList=new ArrayList<ErrorlogVo>();
		 for(Errorlog elog:elogList){
			 ErrorlogVo elogvo=new ErrorlogVo();
			 elogvo.setId(elog.getId());			
			 elogvo.setOccurdate(elog.getOccurdate());
			 elogvo.setResponsedate(elog.getResponsedate());
			 elogvo.setUser_id(elog.getUser_id());
			 elogvo.setDescription(elog.getDescription());
			 if(elog.getMonitor()!=null){
				 elogvo.setTerminal(elog.getMonitor().getName());
			 }
			 elogvoList.add(elogvo);
		}
			 
		return elogvoList;
	}
	
	@Override
	public List<ErrorlogVo> MonitorList() {
		HQLParameter p = new HQLParameter(Errorlog.class);
		System.out.println(p);
		return List(elogDao.findPageByHql(" from Errorlog where responsedate is null"));
	}
	
	@Override
	public List<ErrorlogVo> MonitorHistoryList(ErrorlogVo elog) throws ParseException {
		HQLParameter p = new HQLParameter(Errorlog.class);
		System.out.println(p);
		String terminal = elog.getTerminal();
		Date startTime=elog.getStartTime();
		Date endTime=elog.getEndTime();
		String hql=" from Errorlog ";

		if(terminal == null) {
			if(startTime == null) {
				return List(elogDao.findPageByHql(hql));
			}
			hql = hql + " where occurdate >= ? and occurdate <= ? ";		
			return List(elogDao.findPageByHql(hql,startTime,endTime));
		}
		
		terminal="%"+terminal+"%";
		hql=hql + " where terminal like ? ";
		if(startTime == null) {
			return List(elogDao.findPageByHql(hql,terminal));
		}
		
		hql=hql + " and occurdate >= ? and occurdate <= ? ";
		return List(elogDao.findPageByHql(hql,terminal,startTime,endTime));
	}
	
	@Override
	public boolean ExportListToExcel(ErrorlogVo elog, StringBuffer fileName) throws SQLException, IllegalAccessException {
		ResultSet rs = null;
		
		String path=ErrorlogServiceImpl.class.getProtectionDomain().getCodeSource()
			     .getLocation().getPath();
		if (path.indexOf("WEB-INF") > 0) {
		    path = path.substring(0, path.indexOf("WEB-INF"))+"download/sys_errorlogs/";
		} else {
		    throw new IllegalAccessException("路径获取错误");
		}
		
        File newFile = new File(path);
        if(!newFile.exists()){
        	newFile.mkdirs();
        }
		
		String xlsName = "historyerrorlogs_"+(new java.text.SimpleDateFormat("yyyyMMddHHmmss"))
				.format(new Date()).toString() + ".xls";
		
		fileName.setLength(0);
		fileName.append("/download/sys_errorlogs/"+xlsName);
		xlsName=path+xlsName;
		
		String terminal = elog.getTerminal();
		Date startTime=elog.getStartTime();
		Date endTime=elog.getEndTime();
		String sql="select (select s.name from sys_monitor s where s.terminal=t.terminal) as 终端," +
				"occurdate as 发生时间, user_id as 响应用户,responsedate as 响应时间, " +
				"description as 具体描述 from sys_errorlog t ";

		if(terminal == null) {
			if(startTime == null) {
				rs = elogDao.selectBySql(sql);
				return ExcelUtil.DBToExcel(rs, xlsName);
			}
			sql = sql + " where occurdate >= ? and occurdate <= ? ";		
			rs = elogDao.selectBySql(sql,startTime,endTime);
			return ExcelUtil.DBToExcel(rs, xlsName);
		}
		
		terminal="%"+terminal+"%";
		sql=sql + " where terminal like ? ";
		if(startTime == null) {
			rs = elogDao.selectBySql(sql,terminal);
			return ExcelUtil.DBToExcel(rs, xlsName);
		}
		
		sql=sql + " and occurdate >= ? and occurdate <= ? ";
		rs = elogDao.selectBySql(sql,terminal,startTime,endTime);
		return ExcelUtil.DBToExcel(rs, xlsName);
	}
	
	@Override
	public void update(Errorlog elog) throws Exception {
		elogDao.update(elog);
	}

	@Override
	public Integer save(Errorlog elog) throws Exception {
		return elogDao.save(elog);
	}

	@Override
	public void delete(Errorlog elog) throws Exception {
		elogDao.delete(elog);
	}
	@Override
	public List<ErrorlogVo> getRoot() {
		return	 ListUtils.transform(elogDao.findByHQL(" from Role "),
					ErrorlogVo.class);
	}
	
	public List<ErrorlogVo> list(String hql,Object...params) {
		 
		return ListUtils.transform(elogDao.findPageByHql(hql,params),
				ErrorlogVo.class);
	}
}
