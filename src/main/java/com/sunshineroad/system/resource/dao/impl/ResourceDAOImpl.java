package com.sunshineroad.system.resource.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.resource.dao.ResourceDAO;
import com.sunshineroad.system.resource.entity.ResourceModel;

@Repository("resourceDAO")
public class ResourceDAOImpl extends HibernateDaoSupport<ResourceModel, Integer> implements ResourceDAO<ResourceModel, Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
	
	@Override
	public List<ResourceModel> getRootResource() {
		return this.findWithWhere(" t.parent is null and t.type = 'PANEL'");
	}

	@Override
	public List<ResourceModel> getChildrenByParent(Integer id) {
		return this.findWithWhere(" t.parent =" + id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResourceModel> findAll() {
		// TODO Auto-generated method stub
		Criteria cri = this.getSession().createCriteria(ResourceModel.class);

		List<ResourceModel> list =  cri.list();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ResourceModel> findByIdsForHql(Integer[] ids){
		String hql="FROM ResourceModel WHERE id IN (:alist)";
		Query query = getSession().createQuery(hql);
		query.setParameterList("alist", ids);

		return query.list();
	}
}
