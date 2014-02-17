package com.sunshineroad.system.credentials.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.util.ListUtils;
import com.sunshineroad.system.credentials.dao.CredentialsDao;
import com.sunshineroad.system.credentials.entity.Credentials;
import com.sunshineroad.system.credentials.service.CredentialsService;
import com.sunshineroad.system.credentials.vo.CredentialsVo;
import com.sunshineroad.system.updatelog.entity.Updatelog;

/**
 * omplatformNew
 * com.sunshineroad.system.credentials.service.impl
 * @{#} CredentialsServiceImpl.java Create on  2013-6-13 上午9:26:26
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：证件类型相关处理
 *
 */
@Service("credentialsService")
public class CredentialsServiceImpl implements CredentialsService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected CredentialsDao<Credentials, Integer> creDao;

	public List<CredentialsVo> list() {
		HQLParameter p = new HQLParameter(Updatelog.class);
		System.out.println(p);
		return ListUtils.transform(creDao.findPageByHql(" from Credentials "),
				CredentialsVo.class);
	}

	@Override
	public void update(Credentials cre) throws Exception {
		creDao.update(cre);
	}

	@Override
	public Integer save(Credentials cre) throws Exception {
		return creDao.save(cre);
	}

	@Override
	public void delete(Credentials cre) throws Exception {
		creDao.delete(cre);
	}

}
