package com.sunshineroad.driverschool.freeTable.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.sunshineroad.driverschool.sysparameter.entity.SysParameter;
import com.sunshineroad.driverschool.freeTable.dao.FreeTableDao;
import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
@Service("freeTableDao")
public class FreeTableDaoImpl  extends HibernateDaoSupport< SysParameter, Integer> implements FreeTableDao {
 
	   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
