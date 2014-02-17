package com.sunshineroad.system.dept.dao;



import java.util.List;

import com.sunshineroad.framework.support.dao.hibernate.HibernateDao;
import com.sunshineroad.system.dept.entity.Dept;

public interface DeptDao<T,ID> extends HibernateDao<T, ID> {

	List<Dept> findByIdsForHql(String string, Integer[] ids);

}
