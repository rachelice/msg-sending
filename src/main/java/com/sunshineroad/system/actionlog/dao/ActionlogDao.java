package com.sunshineroad.system.actionlog.dao;

import java.util.List;

import com.sunshineroad.framework.support.dao.hibernate.HibernateDao;
import com.sunshineroad.system.actionlog.entity.Actionlog;

public interface ActionlogDao<T,ID> extends HibernateDao<T, ID> {

	public List<Actionlog> findAll();

}
