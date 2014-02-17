package com.sunshineroad.system.credentials.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.credentials.dao.CredentialsDao;
import com.sunshineroad.system.credentials.entity.Credentials;

@Repository("CredentialsDao")
public class CredentialsDaoImpl extends HibernateDaoSupport<Credentials, Integer> implements CredentialsDao<Credentials, Integer> {
	
    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
    
    
}
