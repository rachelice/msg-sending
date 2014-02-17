package com.sunshineroad.system.actionlog.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.actionlog.dao.ActionlogDao;
import com.sunshineroad.system.actionlog.entity.Actionlog;

@Repository("actionlogDao")
public class ActionlogDaoImpl extends HibernateDaoSupport<Actionlog, Integer> implements ActionlogDao<Actionlog, Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Actionlog> findAll() {
		// TODO Auto-generated method stub
		Criteria cri = this.getSession().createCriteria(Actionlog.class);

		List<Actionlog> list =  cri.list();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
}
