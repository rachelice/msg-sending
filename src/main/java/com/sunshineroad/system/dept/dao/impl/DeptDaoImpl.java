package com.sunshineroad.system.dept.dao.impl;



import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.dept.dao.DeptDao;
import com.sunshineroad.system.dept.entity.Dept;

@Repository("deptDao")
public class DeptDaoImpl extends HibernateDaoSupport<Dept, Integer> implements DeptDao<Dept, Integer> {
 
    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
	
	public DeptDaoImpl(){
		this.getEntityClass();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> findByIdsForHql(String string, Integer[] ids) {
		String hql="FROM Dept WHERE id IN (:alist)";
		Query query = getSession().createQuery(hql);
		query.setParameterList("alist", ids);

		return query.list();
	}
}
