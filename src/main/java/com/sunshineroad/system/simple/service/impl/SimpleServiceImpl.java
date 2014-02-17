package com.sunshineroad.system.simple.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.system.simple.dao.SimpleDao;
import com.sunshineroad.system.simple.domain.Simple;
import com.sunshineroad.system.simple.service.SimpleService;

@Service("simpleServiceImpl")
public class SimpleServiceImpl implements SimpleService{
	
	private static final Log logger = LogFactory.getLog(SimpleServiceImpl.class);
	
	@Autowired
	private SimpleDao<Simple, Integer> simpleDao;

	@Override
	public void selectSimple() {
		logger.debug(simpleDao);
		simpleDao.find();
	}
}
