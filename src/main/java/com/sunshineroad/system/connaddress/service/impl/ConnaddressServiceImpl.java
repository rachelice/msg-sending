package com.sunshineroad.system.connaddress.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.util.ListUtils;
import com.sunshineroad.system.connaddress.dao.ConnaddressDao;
import com.sunshineroad.system.connaddress.entity.Connaddress;
import com.sunshineroad.system.connaddress.service.ConnaddressService;
import com.sunshineroad.system.connaddress.vo.ConnaddressVo;
import com.sunshineroad.system.errorlog.entity.Errorlog;

/**
 * omplatform
 * com.sunshineroad.system.connaddress.service.impl
 * @{#} ConnaddressServiceImpl.java Create on  2013-6-13 上午4:38:12
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：系统外终端连接设置，例如监控终端等。
 *
 */
@Service("connaddressService")
public class ConnaddressServiceImpl implements ConnaddressService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected ConnaddressDao<Connaddress, Integer> connaddrDao;

	@Override
	public List<ConnaddressVo> list() {
		HQLParameter p = new HQLParameter(Errorlog.class);
		System.out.println(p);
		return ListUtils.transform(connaddrDao.findPageByHql(" from Connaddress "),
				ConnaddressVo.class);
	}

	@Override
	public List<Connaddress> findByType(String type){
		return connaddrDao.findWithWhere(" t.type =" +"'"+ type +"'");
	}

	@Override
	public void update(Connaddress connaddr) throws Exception {
		connaddrDao.update(connaddr);
	}

	@Override
	public Integer save(Connaddress connaddr) throws Exception {
		return connaddrDao.save(connaddr);
	}

	@Override
	public void delete(Connaddress connaddr) throws Exception {
		connaddrDao.delete(connaddr);
	}

}
