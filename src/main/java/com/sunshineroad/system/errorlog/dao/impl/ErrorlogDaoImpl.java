package com.sunshineroad.system.errorlog.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.errorlog.dao.ErrorlogDao;
import com.sunshineroad.system.errorlog.entity.Errorlog;

@Repository("errorlogDao")
public class ErrorlogDaoImpl extends HibernateDaoSupport<Errorlog, Integer> implements ErrorlogDao<Errorlog, Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
	
	@Override
	public List<Errorlog> findAll() {
		// TODO Auto-generated method stub
		return null;

	}
}
