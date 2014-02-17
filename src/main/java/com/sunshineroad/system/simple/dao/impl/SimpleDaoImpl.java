package com.sunshineroad.system.simple.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.simple.dao.SimpleDao;
import com.sunshineroad.system.simple.domain.Simple;

@Repository("simpleDaoImpl")
public class SimpleDaoImpl extends HibernateDaoSupport<Simple,Integer> implements SimpleDao<Simple,Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }

}
