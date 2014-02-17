package com.sunshineroad.system.user.dao;

import com.sunshineroad.framework.support.dao.hibernate.HibernateDao;
import com.sunshineroad.system.user.model.UserModel;


public interface UserDao extends HibernateDao<UserModel, Integer> {


	public UserModel findByUsername(String username);
}
