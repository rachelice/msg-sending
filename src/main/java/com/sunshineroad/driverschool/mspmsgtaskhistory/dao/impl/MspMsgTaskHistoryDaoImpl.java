package com.sunshineroad.driverschool.mspmsgtaskhistory.dao.impl;

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

import com.sunshineroad.driverschool.mspmsgtaskhistory.dao.MspMsgTaskHistoryDao;
import com.sunshineroad.driverschool.mspmsgtaskhistory.entity.MspMsgTaskHistory;
import com.sunshineroad.driverschool.mspmsgtaskhistory.entityvo.MspMsgTaskHistoryVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 短信任务
 * @author  
 * @date 2014-02-24 12:48:19
 * @version V1.0   
 *
 */
@Repository("MspMsgTaskHistoryDao")
public class MspMsgTaskHistoryDaoImpl extends HibernateDaoSupport<MspMsgTaskHistory, Integer> implements MspMsgTaskHistoryDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public MspMsgTaskHistoryDaoImpl(){
		this.getEntityClass();
	} 
  
}
