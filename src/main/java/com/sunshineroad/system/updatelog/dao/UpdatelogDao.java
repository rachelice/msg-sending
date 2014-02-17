package com.sunshineroad.system.updatelog.dao;

import java.util.List;

import com.sunshineroad.framework.support.dao.hibernate.HibernateDao;
import com.sunshineroad.system.updatelog.entity.Updatelog;

public interface UpdatelogDao<T,ID> extends HibernateDao<T, ID> {

	public List<Updatelog> findAll();

}
