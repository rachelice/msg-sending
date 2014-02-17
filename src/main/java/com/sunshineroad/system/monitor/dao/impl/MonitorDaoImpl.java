package com.sunshineroad.system.monitor.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.monitor.dao.MonitorDao;
import com.sunshineroad.system.monitor.entity.Monitor;

@Repository("monitorDao")
public class MonitorDaoImpl extends HibernateDaoSupport<Monitor, Integer> implements MonitorDao<Monitor, Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
	
	public MonitorDaoImpl(){
		this.getEntityClass();
	}
	
}
