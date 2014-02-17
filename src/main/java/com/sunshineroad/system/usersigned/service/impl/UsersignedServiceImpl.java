package com.sunshineroad.system.usersigned.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.util.ListUtils;
import com.sunshineroad.system.usersigned.dao.UsersignedDao;
import com.sunshineroad.system.usersigned.entity.Usersigned;
import com.sunshineroad.system.usersigned.service.UsersignedService;
import com.sunshineroad.system.usersigned.vo.UsersignedVo;

/**
 * omplatformNew
 * com.sunshineroad.system.usersigned.service.impl
 * @{#} UsersignedServiceImpl.java Create on  2013-6-13 上午4:48:46
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：用户签到记录处理
 *
 */
@Service("usersignedService")
public class UsersignedServiceImpl implements UsersignedService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected UsersignedDao<Usersigned, Integer> usersignedDao;

	public UsersignedDao<Usersigned, Integer> getUsersignedDao(){
		return this.usersignedDao;
	}

	public List<UsersignedVo> list() {
		HQLParameter p = new HQLParameter(Usersigned.class);
		System.out.println(p);
		return ListUtils.transform(usersignedDao.findPageByHql(" from Usersigned "),
				UsersignedVo.class);
	}

	@Override
	public void update(Usersigned usersigned) throws Exception {
		usersignedDao.update(usersigned);
	}

	@Override
	public Integer save(Usersigned usersigned) throws Exception {
		return usersignedDao.save(usersigned);
	}

	@Override
	public void delete(Usersigned usersigned) throws Exception {
		usersignedDao.delete(usersigned);
	}
	
	@Override
	public boolean IsSigned(String user_ID,String occurday,String flag) {
		Usersigned usersigned = usersignedDao.findSigned(user_ID,occurday,flag);
		if (usersigned != null)
		{
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String getSelfLoginName() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();
		return userDetails.getUsername();
	}

}
