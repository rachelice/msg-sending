package com.sunshineroad.driverschool.mspenterprise.dao.impl;

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

import com.sunshineroad.driverschool.mspenterprise.dao.MspEnterpriseDao;
import com.sunshineroad.driverschool.mspenterprise.entity.MspEnterprise;
import com.sunshineroad.driverschool.mspenterprise.entityvo.MspEnterpriseVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 企业表
 * @author  
 * @date 2014-02-24 12:45:38
 * @version V1.0   
 *
 */
@Repository("MspEnterpriseDao")
public class MspEnterpriseDaoImpl extends HibernateDaoSupport<MspEnterprise, Integer> implements MspEnterpriseDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public MspEnterpriseDaoImpl(){
		this.getEntityClass();
	} 
  
}
