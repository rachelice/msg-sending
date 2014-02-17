package com.sunshineroad.system.connaddress.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.connaddress.dao.ConnaddressDao;
import com.sunshineroad.system.connaddress.entity.Connaddress;

@Repository("connaddressDao")
public class ConnaddressDaoImpl extends HibernateDaoSupport<Connaddress, Integer> implements ConnaddressDao<Connaddress, Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
