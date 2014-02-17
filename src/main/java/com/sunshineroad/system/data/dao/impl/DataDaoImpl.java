package com.sunshineroad.system.data.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.data.dao.DataDao;
import com.sunshineroad.system.data.entity.Data;

@Repository("dataDao")
public class DataDaoImpl extends HibernateDaoSupport<Data, Integer> implements DataDao<Data, Integer>{

	@Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
