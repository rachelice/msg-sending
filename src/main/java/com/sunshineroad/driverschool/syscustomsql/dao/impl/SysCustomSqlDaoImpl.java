package com.sunshineroad.driverschool.syscustomsql.dao.impl;

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

import com.sunshineroad.driverschool.syscustomsql.dao.SysCustomSqlDao;
import com.sunshineroad.driverschool.syscustomsql.entity.SysCustomSql;
import com.sunshineroad.driverschool.syscustomsql.entityvo.SysCustomSqlVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 报表
 * @author  
 * @date 2014-01-26 17:58:38
 * @version V1.0   
 *
 */
@Repository("SysCustomSqlDao")
public class SysCustomSqlDaoImpl extends HibernateDaoSupport<SysCustomSql, Integer> implements SysCustomSqlDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public SysCustomSqlDaoImpl(){
		this.getEntityClass();
	} 
  
}
