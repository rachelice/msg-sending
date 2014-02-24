package com.sunshineroad.driverschool.mspstudent.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunshineroad.driverschool.mspstudent.dao.MspStudentDao;
import com.sunshineroad.driverschool.mspstudent.entity.MspStudent;
import com.sunshineroad.driverschool.mspstudent.entityvo.MspStudentVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 学员表
 * @author  
 * @date 2014-02-20 11:03:29
 * @version V1.0   
 *
 */
@Repository("MspStudentDao")
public class MspStudentDaoImpl extends HibernateDaoSupport<MspStudent, Integer> implements MspStudentDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public MspStudentDaoImpl(){
		this.getEntityClass();
	} 
  
}
