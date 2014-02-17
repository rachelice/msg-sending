package ${bussiPackage}.${entityPackage}.dao.impl;

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

import ${bussiPackage}.${entityPackage}.dao.${entityName}Dao;
import ${bussiPackage}.${entityPackage}.entity.${entityName};
import ${bussiPackage}.${entityPackage}.entityvo.${entityName}Vo;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;


/**   
 * @Title: daoImpl
 * @Description: ${ftl_description}
 * @author  
 * @date ${ftl_create_time}
 * @version V1.0   
 *
 */
@Repository("${entityName}Dao")
public class ${entityName}DaoImpl extends HibernateDaoSupport<${entityName}, Integer> implements ${entityName}Dao {
   @Resource(name="sessionFactory_system")
	    public void setSessionFactory(SessionFactory sessionFactory){
	    	super.sessionFactory = sessionFactory;
	    }
	public ${entityName}DaoImpl(){
		this.getEntityClass();
	} 
  
}
