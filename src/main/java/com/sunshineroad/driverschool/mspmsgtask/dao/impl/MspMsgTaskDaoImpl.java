package com.sunshineroad.driverschool.mspmsgtask.dao.impl;

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

import com.sunshineroad.driverschool.mspmsgtask.dao.MspMsgTaskDao;
import com.sunshineroad.driverschool.mspmsgtask.entity.MspMsgTask;
import com.sunshineroad.driverschool.mspmsgtask.entityvo.MspMsgTaskVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 短信任务
 * @author  
 * @date 2014-02-24 12:47:15
 * @version V1.0   
 *
 */
@Repository("MspMsgTaskDao")
public class MspMsgTaskDaoImpl extends HibernateDaoSupport<MspMsgTask, Integer> implements MspMsgTaskDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public MspMsgTaskDaoImpl(){
		this.getEntityClass();
	} 
  
}
