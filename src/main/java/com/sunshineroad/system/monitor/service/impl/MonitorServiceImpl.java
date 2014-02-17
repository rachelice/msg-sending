package com.sunshineroad.system.monitor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.util.ListUtils;
import com.sunshineroad.system.monitor.dao.MonitorDao;
import com.sunshineroad.system.monitor.entity.Monitor;
import com.sunshineroad.system.monitor.service.MonitorService;
import com.sunshineroad.system.monitor.vo.MonitorVo;

/**
 * omplatform
 * com.sunshineroad.system.monitor.service.impl
 * @{#} MonitorServiceImpl.java Create on  2013-6-13 上午9:36:48
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：监控终端信息
 *
 */

@Service("monitorServiceImpl")
public class MonitorServiceImpl implements MonitorService {

	@Autowired
	private MonitorDao<Monitor, Integer> mDao;

	public List<MonitorVo> list() {
		HQLParameter p = new HQLParameter(Monitor.class);
		System.out.println(p);
		return ListUtils.transform(mDao.findPageByHql(" from Monitor "),
				MonitorVo.class);
	}
	
	@Override
	public List<MonitorVo> getRoot() {
		return ListUtils.transform(mDao.findByHQL(" from Monitor "),
				MonitorVo.class);
	}

	@Override
	public void update(Monitor monitor) throws Exception {
		mDao.update(monitor);
	}

	@Override
	public Integer save(Monitor monitor) throws Exception {
		return mDao.save(monitor);
	}

	@Override
	public void delete(Monitor monitor) throws Exception {
		mDao.delete(monitor);
	}

}
