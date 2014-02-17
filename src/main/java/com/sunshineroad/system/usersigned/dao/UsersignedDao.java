package com.sunshineroad.system.usersigned.dao;

import java.util.List;

import com.sunshineroad.framework.support.dao.hibernate.HibernateDao;
import com.sunshineroad.system.usersigned.entity.Usersigned;

public interface UsersignedDao<T,ID> extends HibernateDao<T, ID> {

	public List<Usersigned> findAll();
	
	public Usersigned findSigned(String loginName,String occurday,String flag);

}
