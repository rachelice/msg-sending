package com.sunshineroad.driverschool.sysparameter.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sunshineroad.driverschool.sysparameter.dao.SysParameterDao;
import com.sunshineroad.driverschool.sysparameter.entity.SysParameter;
import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;


/**   
 * @Title: daoImpl
 * @Description: 参数
 * @author  
 * @date 2014-01-09 10:34:34
 * @version V1.0   
 *
 */
@Repository("SysParameterDao")
public class SysParameterDaoImpl extends HibernateDaoSupport<SysParameter, Integer> implements SysParameterDao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public SysParameterDaoImpl(){
		this.getEntityClass();
	} 
  
}
