package com.sunshineroad.system.role.dao;

import java.util.List;

import com.sunshineroad.framework.support.dao.hibernate.HibernateDao;
import com.sunshineroad.system.role.entity.Role;

public interface RoleDao<T,ID> extends HibernateDao<T, ID> {

	List<Role> findByIdsForHql(Integer[] ids);

}
