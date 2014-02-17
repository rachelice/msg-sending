package com.sunshineroad.system.actionlog.service;

import java.util.List;

import com.sunshineroad.system.actionlog.dao.ActionlogDao;
import com.sunshineroad.system.actionlog.entity.Actionlog;
import com.sunshineroad.system.actionlog.vo.ActionlogVo;


public interface ActionlogService {

	public List<ActionlogVo> list(ActionlogVo actvo) throws Exception;
	
	public void update(Actionlog alog) throws Exception;
	
	public Integer save(Actionlog alog) throws Exception;
	
	public Integer saveAlog(String user,String actDesc,boolean status, String comments) throws Exception;
	
	public void delete(Actionlog alog) throws Exception;
	
	public ActionlogDao<Actionlog, Integer> getActionlogDao();
	
	public String getSelfLoginName();

}
