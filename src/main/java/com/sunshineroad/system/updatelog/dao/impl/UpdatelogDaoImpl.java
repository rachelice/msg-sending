package com.sunshineroad.system.updatelog.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.updatelog.dao.UpdatelogDao;
import com.sunshineroad.system.updatelog.entity.Updatelog;

@Repository("UpdatelogDao")
public class UpdatelogDaoImpl extends HibernateDaoSupport<Updatelog, Integer> implements UpdatelogDao<Updatelog, Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Updatelog> findAll() {
		// TODO Auto-generated method stub
		Criteria cri = this.getSession().createCriteria(Updatelog.class);

		List<Updatelog> list =  cri.list();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
}
