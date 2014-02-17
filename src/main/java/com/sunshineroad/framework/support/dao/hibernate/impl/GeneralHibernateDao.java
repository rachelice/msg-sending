package com.sunshineroad.framework.support.dao.hibernate.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;


@SuppressWarnings("rawtypes")
@Repository
public class GeneralHibernateDao extends HibernateDaoSupport {


	public Object get(Class clazz,Serializable id){
		return getSession().get(clazz, id);
	}
	
	public List<?> find(Class clazz,Object... params){
		return this.findPageByHql(buildHQLByClass(clazz), params);
	}

	 
}
