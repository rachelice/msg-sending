package com.sunshineroad.system.busicode.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.busicode.dao.BusiCodeDao;
import com.sunshineroad.system.busicode.vo.BusiCodeVo;

@Repository("busicodeDao")
public class BusiCodeDaoImpl extends HibernateDaoSupport<BusiCodeVo, Integer> implements BusiCodeDao<BusiCodeVo, Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
}
