package com.sunshineroad.driverschool.mspmsglisthistory.dao.impl;

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

import com.sunshineroad.driverschool.mspmsglisthistory.dao.MspMsgListHistoryDao;
import com.sunshineroad.driverschool.mspmsglisthistory.entity.MspMsgListHistory;
import com.sunshineroad.driverschool.mspmsglisthistory.entityvo.MspMsgListHistoryVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 短信清单历史记录
 * @author  
 * @date 2014-02-24 12:50:29
 * @version V1.0   
 *
 */
@Repository("MspMsgListHistoryDao")
public class MspMsgListHistoryDaoImpl extends HibernateDaoSupport<MspMsgListHistory, Integer> implements MspMsgListHistoryDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public MspMsgListHistoryDaoImpl(){
		this.getEntityClass();
	} 
  
}
