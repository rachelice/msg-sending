package com.sunshineroad.driverschool.schooluser.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunshineroad.driverschool.schooluser.dao.SchoolUserDao;
import com.sunshineroad.driverschool.schooluser.entity.SchoolUser;
import com.sunshineroad.driverschool.schooluser.entityvo.SchoolUserVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: uu
 * @author  
 * @date 2013-12-25 14:03:32
 * @version V1.0   
 *
 */
@Repository("SchoolUserDao")
public class SchoolUserDaoImpl extends HibernateDaoSupport<SchoolUser, Integer> implements SchoolUserDao {
  
	public SchoolUserDaoImpl(){
		this.getEntityClass();
	} 
  
}
