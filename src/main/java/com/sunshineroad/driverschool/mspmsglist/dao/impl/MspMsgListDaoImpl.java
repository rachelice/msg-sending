package com.sunshineroad.driverschool.mspmsglist.dao.impl;

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

import com.sunshineroad.driverschool.mspmsglist.dao.MspMsgListDao;
import com.sunshineroad.driverschool.mspmsglist.entity.MspMsgList;
import com.sunshineroad.driverschool.mspmsglist.entityvo.MspMsgListVo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: 短信清单
 * @author  
 * @date 2014-02-24 12:49:30
 * @version V1.0   
 *
 */
@Repository("MspMsgListDao")
public class MspMsgListDaoImpl extends HibernateDaoSupport<MspMsgList, Integer> implements MspMsgListDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public MspMsgListDaoImpl(){
		this.getEntityClass();
	} 
  
}
