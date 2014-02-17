package com.sunshineroad.system.updatelog.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.util.DateUtils;
import com.sunshineroad.system.updatelog.dao.UpdatelogDao;
import com.sunshineroad.system.updatelog.entity.Updatelog;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.system.updatelog.vo.UpdatelogVo;

/**
 * omplatform
 * com.sunshineroad.system.updatelog.service.impl
 * @{#} UpdatelogServiceImpl.java Create on  2013-6-13 上午9:43:54
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：（中心管理）数据更新前后的相关信息记录
 *
 */

@Service("updatelogService")
public class UpdatelogServiceImpl implements UpdatelogService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected UpdatelogDao<Updatelog, Integer> ulogDao;
	
	public UpdatelogDao<Updatelog, Integer> getUpdatelogDao(){
		return this.ulogDao;
	}

	@Override
	public List<UpdatelogVo> list(UpdatelogVo updatelogVo) {
		List<Updatelog> modelList;
		String hql;
		hql = "from Updatelog where user_id like ? and " + "action like ? ";
		if (updatelogVo.getUser_id() != null || updatelogVo.getAction() != null
				|| updatelogVo.getOccurdate() != null )
		{
			String user_id = updatelogVo.getUser_id();
			if (user_id == null)
			{
				user_id = "%";
			}
			String action = updatelogVo.getAction();
			if (action == null)
			{
				action = "%";
			}
			if (updatelogVo.getOccurdate() != null)
			{
				Date startdate = updatelogVo.getOccurdate();
				Date enddate = DateUtils.addDayD(startdate, 1, "d");

				System.out.println("StartDate: " + startdate);
				System.out.println("EndDate: " + enddate);

				hql += " and occurdate >= ? and occurdate < ?";

				modelList = ulogDao.findPageByHql(hql, user_id, action,
							startdate, enddate);
			} else{
				modelList = ulogDao.findPageByHql(hql, user_id, action);
			}
		} else
		{
			modelList = ulogDao.findPageByHql(" from Updatelog ");
		}
		List<UpdatelogVo> nodeList = new ArrayList<UpdatelogVo>();
		for (Updatelog model : modelList)
		{
			UpdatelogVo node = new UpdatelogVo();
			node.setId(model.getId());
			node.setAction(model.getAction());
			node.setOccurdate(model.getOccurdate());
			node.setUser_id(model.getUser_id());
			node.setTable_name(model.getTable_name());
			node.setKeys(model.getKeys());
			node.setKey_value(model.getKey_value());
			node.setColumns(model.getColumns());
			node.setOld_value(model.getOld_value());
			node.setNew_value(model.getNew_value());
			nodeList.add(node);
		}
		return nodeList;
	}

	public List<Updatelog> findRecord(String table,String keys,String keyvalue,String flag)
	{
		List<Updatelog> modelList;
		String hql = "from Updatelog where table_name = ? and keys = ? and key_value = ? and flag = ?";
		
		modelList = ulogDao.findPageByHql(hql, table, keys, keyvalue, flag);
		return modelList;
		
	}
	
	@Override
	public void update(Updatelog ulog) throws Exception {
		ulogDao.update(ulog);
	}

	@Override
	public Integer save(Updatelog ulog) throws Exception {
		return ulogDao.save(ulog);
	}

	@Override
	public void delete(Updatelog ulog) throws Exception {
		ulogDao.delete(ulog);
	}
	
	@Override
	public Integer saveUlog(Updatelog ulog) throws Exception {
		Date occurdate=new Date();
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		
		ulog.setOccurdate(occurdate);
		ulog.setTimestamp(timestamp);
		ulog.setUser_id(this.getSelfLoginName());
		
		return ulogDao.save(ulog);
	}

	public String getSelfLoginName() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();
		return userDetails.getUsername();
	}
}
