package com.sunshineroad.system.errorlog.dao;

import java.util.List;

import com.sunshineroad.framework.support.dao.hibernate.HibernateDao;
import com.sunshineroad.system.errorlog.entity.Errorlog;

public interface ErrorlogDao<T,ID> extends HibernateDao<T, ID> {

	public List<Errorlog> findAll();

}
