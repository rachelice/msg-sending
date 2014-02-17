package com.sunshineroad.system.user.dao.impl;

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

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.framework.web.support.pagination.PaginationUtils;
import com.sunshineroad.system.user.dao.UserDao;
import com.sunshineroad.system.user.model.UserModel;
import com.sunshineroad.system.user.model.UserQueryModel;


/**
 * User:
 * Date:
 * Version: 1.0
 */
@Repository("UserDao")
public class UserHibernate4DaoImpl extends HibernateDaoSupport<UserModel, Integer> implements UserDao {

    private static final String HQL_LIST = "from UserModel ";
    private static final String HQL_COUNT = "select count(*) from UserModel ";

    @SuppressWarnings("unused")
	private static final String HQL_LIST_QUERY_LOGIN = " where loginName = ?";
    private static final String HQL_LIST_QUERY_CONDITION = " where username like ?";
    @SuppressWarnings("unused")
	private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by id desc";
    @SuppressWarnings("unused")
	private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;
    
    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
	 
	public UserHibernate4DaoImpl(){
		this.getEntityClass();
	}
    @SuppressWarnings("unused")
	@Transactional
    private Object[] getQueryParam(UserQueryModel command) {
        //TODO 改成全文索引
        String usernameLikeStr = "%" + command.getUsername() + "%";
        return new Object[]{
            usernameLikeStr
        };
    }
  
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public UserModel findByUsername(String loginName) {
		Criteria cri = this.getSession().createCriteria(UserModel.class);

		Criterion cron = Restrictions.eq("loginName",loginName);

		cri.add(cron);

		 
		List<UserModel> list =  cri.list();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	

	@SuppressWarnings("unchecked")
	public List<UserModel> findPageByHql(String hql, Object... params) {
		this.getEntityClass();
		if (PaginationUtils.exist() && PaginationUtils.getSorter() != null) {
			hql += " order by " + PaginationUtils.getSorter() + " "
					+ PaginationUtils.getOrder();
		}
		Query query = createHQLQuery(hql, params);

		if (PaginationUtils.exist()) {
			Query countQuery = createHQLQuery("select count(*)"
					+ removeSelect(hql), params);
			int total = Integer.valueOf(countQuery.uniqueResult().toString());
			PaginationUtils.setTotal(total);

			query.setFirstResult(PaginationUtils.getStart()).setMaxResults(
					PaginationUtils.getLimit());
			
			System.out.println("PaginationUtils.getLimit()="+PaginationUtils.getLimit());
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<UserModel> findPageBySql(String sql, Object... params) {
		if (PaginationUtils.exist()) {
			sql += " order by " + PaginationUtils.getSorter() + " "
					+ PaginationUtils.getOrder();
		}
		SQLQuery query = createSQLQuery(sql, params);

		if (PaginationUtils.exist()) {

			SQLQuery countQuery = createSQLQuery("select count(1)"
					+ removeSelect(sql), params);
			int total = Integer.valueOf(countQuery.uniqueResult().toString());
			PaginationUtils.setTotal(total);

			query.setFirstResult(PaginationUtils.getStart()).setMaxResults(
					PaginationUtils.getLimit());
		}
		return query.list();
	}

	public SQLQuery createSQLQuery(String sql, Object... params) {
		return (SQLQuery) setParameters(getSession().createSQLQuery(sql), params);
	}

	public Query createHQLQuery(String hql, Object... params) {
		return setParameters(getSession().createQuery(hql),params);
	}

	public static String buildHQLByClass(Class<?> clazz) {
		return "from " + clazz.getSimpleName() + " t";
	}

	public static String removeSelect(String str) {
		int pos = str.toLowerCase().indexOf("from");
		if (pos != -1) {
			str.substring(pos);
		}
		return str;
	}

}
