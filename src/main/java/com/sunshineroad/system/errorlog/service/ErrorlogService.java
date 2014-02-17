package com.sunshineroad.system.errorlog.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.sunshineroad.system.errorlog.dao.ErrorlogDao;
import com.sunshineroad.system.errorlog.entity.Errorlog;
import com.sunshineroad.system.errorlog.vo.ErrorlogVo;


public interface ErrorlogService {

	public List<ErrorlogVo> MonitorList();
	
	public List<ErrorlogVo> MonitorHistoryList(ErrorlogVo elog) throws ParseException;
	
	public void update(Errorlog elog) throws Exception;
	
	public Integer save(Errorlog elog) throws Exception;
	
	public void delete(Errorlog elog) throws Exception;
	
	public ErrorlogDao<Errorlog, Integer> getErrorlogDao();
	
	public List<ErrorlogVo> getRoot();
	
	public List<ErrorlogVo> list(String hql, Object... params);

	public boolean ExportListToExcel(ErrorlogVo elog, StringBuffer fileName) throws ParseException, SQLException, IllegalAccessException;
}
