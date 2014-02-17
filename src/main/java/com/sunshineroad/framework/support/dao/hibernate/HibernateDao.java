package com.sunshineroad.framework.support.dao.hibernate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;


public interface HibernateDao<T,ID> {
	
	public List<T> find();

	/**
	 * 保存实体类，返回主键ID
	 * @param <ID>
	 * @param <T>
	 * @param entity 实体类
	 * @return
	 */
	public ID save(T entity);
	
	/**
	 * 删除集合
	 * @param <T>
	 * @param entityList
	 */
	public  void delete(List<T> entityList);
	
	/**
	 * 删除实体类
	 * @param <T>
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * 更新实体类
	 * @param <T>
	 * @param entity
	 */
	public void update(T entity);
	
	public T get(ID id);
	
	/**
	 * @param content
	 */
	
	public Object findUniqueBy(Class<?> entityClass, String propertyName,
			Object value);
	
	public List<T> findByHQL(String hql);
	
	public List<T> findByHQL(String hql, Object... params);
	
	public List<T> findWithWhere(String where);
	
	public List<T> findPageByHql(String hql, Object... params);
	
	public SQLQuery createSQLQuery(String sql, Object... params) ;

	public Query createHQLQuery(String hql, Object... params) ;
	
	public int getNextval(String sequenceName);
	
	public int updateBySql(String sql, Object... params);
	
	public List<T> selectBySql(Class<T> clazz, String rows,String sql, Object... params);
	
	public ResultSet selectBySql(String sql, Object... params) throws SQLException;
}
