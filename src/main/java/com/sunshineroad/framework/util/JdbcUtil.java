package com.sunshineroad.framework.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

/**
 * 常常有 JDBC 分页查询 这里给二个例子介绍一下
 * JDBC 分页查询
 * 分成二种方式希望对大家有所帮助
 * 分另表示了absolute 与relative 的区别
 * @see 这时用到一个数据源设计模式 
 * 数据源与数据库连接没有关系 
 * 例用接口回调的特性
 * @author liuqing
 * @version 1.0
 * 2011-8-2
 *
 */
public class JdbcUtil {
	
	/**
	 * 数据源
	 */
	private DataSource dataSource;
	
	/**
	 * 不否启用多数据源
	 */
	private boolean isMultipleDataSource;
	
	/**
	 * 有时一个系统可能要使用多个数据源,存放多个数据源
	 */
	private Map<String,DataSource> dataSources = new TreeMap<String,DataSource>();
	
	/**
	 * if true isMultipleDataSource is Key to DataSource
	 */
	private String dataSourceKey;

	/**
	 * 默认构造器
	 */
	public JdbcUtil() {
		
	}
	
	/**
	 * 构造器 Spring 的构造器注入
	 * @param dataSource
	 */
	public JdbcUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * JDBC 分页查询
	 * @param sql       SQL 查询语句
	 * @param firstSize 起始页
	 * @param maxSize   返回数据条数
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet queryPageAbsolute(String sql,
			int firstSize,int maxSize) throws SQLException {
		PreparedStatement pre = this.getConn().prepareStatement(sql);
		pre.setMaxRows(maxSize);
		ResultSet rs = pre.executeQuery();
		rs.absolute(firstSize * maxSize);
		return rs;
	}
	
	/**
	 * JDBC 分页查询
	 * @param sql        SQL 查询语句
	 * @param firstSize  起始页
	 * @param maxSize    返回数据条数
	 * @return ResultSet 返回结果集
	 * @throws SQLException
	 */
	public ResultSet queryPageRelative(String sql,
			int firstSize,int maxSize) throws SQLException {
		PreparedStatement pre = getConn().prepareStatement(sql);
		pre.setMaxRows(maxSize);
		ResultSet rs = pre.executeQuery();
		rs.relative(firstSize);
		return rs;
	}
	
	/**
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	private Connection getConn() throws SQLException {
		//使用多数据源的情况
		if (this.isMultipleDataSource) {
			DataSource v_dataSource = this.queryDataSourceByKey();
			if (v_dataSource != null) {
				return v_dataSource.getConnection();
			}
		}
		return this.dataSource.getConnection();
	}
	/**
	 * 获得多数据源方法
	 * @return DataSource
	 */
	public DataSource queryDataSourceByKey() {
		for (Map.Entry<String, DataSource> ds:this.dataSources.entrySet()) {
			if (ds.getKey().equals(dataSourceKey)) {
				return ds.getValue();
			}
		}
		return null;
	}
	
	/**
	 * 获得多数据源方法
	 * @return DataSource
	 */
	public DataSource queryDataSourceByKey(String useKey) {
		for (Map.Entry<String, DataSource> ds:this.dataSources.entrySet()) {
			if (ds.getKey().equals(useKey)) {
				return ds.getValue();
			}
		}
		return null;
	}
	
	/**
	 * 数据源
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * 数据源 setter 注入
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * @return the isMultipleDataSource
	 */
	public boolean isMultipleDataSource() {
		return isMultipleDataSource;
	}

	/**
	 * @param isMultipleDataSource the isMultipleDataSource to set
	 */
	public void setMultipleDataSource(boolean isMultipleDataSource) {
		this.isMultipleDataSource = isMultipleDataSource;
	}

	/**
	 * @return the dataSources
	 */
	public Map<String, DataSource> getDataSources() {
		return dataSources;
	}

	/**
	 * @param dataSources the dataSources to set
	 */
	public void setDataSources(Map<String, DataSource> dataSources) {
		this.dataSources = dataSources;
	}

	/**
	 * 返回当前使用的数据源
	 * @return the dataSourceKey
	 */
	public String getDataSourceKey() {
		return dataSourceKey;
	}

	/**
	 * 要使用的数据源为
	 * @param dataSourceKey the dataSourceKey to set
	 */
	public void setDataSourceKey(String dataSourceKey) {
		this.dataSourceKey = dataSourceKey;
	}

}
