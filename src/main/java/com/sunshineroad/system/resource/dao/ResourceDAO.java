package com.sunshineroad.system.resource.dao;

import java.util.List;

import com.sunshineroad.framework.support.dao.hibernate.HibernateDao;
import com.sunshineroad.system.resource.entity.ResourceModel;

public interface ResourceDAO<T,ID> extends HibernateDao<T,ID> {

	public List<ResourceModel> getRootResource();
	
	public List<ResourceModel> getChildrenByParent(Integer id);

	public List<ResourceModel> findAll();
	
	public String getText();

	public List<ResourceModel> findByIdsForHql(Integer[] ids);
}
