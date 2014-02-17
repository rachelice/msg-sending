package com.sunshineroad.system.role.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.role.dao.RoleDao;
import com.sunshineroad.system.role.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl extends HibernateDaoSupport<Role, Integer> implements RoleDao<Role, Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
	
	public RoleDaoImpl(){
		this.getEntityClass();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findByIdsForHql(Integer[] ids) {
		String hql="FROM Role WHERE id IN (:alist)";
		Query query = getSession().createQuery(hql);
		query.setParameterList("alist", ids);

		return query.list();
	}
	
	
}
