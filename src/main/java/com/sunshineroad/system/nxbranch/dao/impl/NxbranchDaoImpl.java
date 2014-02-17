package com.sunshineroad.system.nxbranch.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.nxbranch.dao.NxbranchDao;
import com.sunshineroad.system.nxbranch.entity.Nxbranch;

@Repository("NxbranchDao")
public class NxbranchDaoImpl extends HibernateDaoSupport<Nxbranch, Integer> implements NxbranchDao<Nxbranch, Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
	
}
