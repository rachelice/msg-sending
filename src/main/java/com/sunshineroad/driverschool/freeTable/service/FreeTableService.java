package com.sunshineroad.driverschool.freeTable.service;

import java.util.List;

import com.sunshineroad.driverschool.sysparameter.entity.SysParameter;
import com.sunshineroad.driverschool.freeTable.entity.MyDataBase;
import com.sunshineroad.framework.support.service.IBaseService;

public interface FreeTableService extends IBaseService<SysParameter, Integer>{
	
	/**
     * 将数据处理为JSON格式的字符串
     * @param tablename    对应表名
     * @return    字符串数组，每一项为一条数据库记录
     */
    public String[] getContentStrBySql(String sql);/**
     * 获取表名
     * @return    List<表>
     */
    public List<MyDataBase> getTables();
    
    /**
     * 获取字段名    
     * @param tablename    表名
     * @return
     */
    public List<MyDataBase> getFields(String tablename);
    
    /**
     * 获取字段
     * @param tablename 表名
     * @return
     */
    public String[] getFieldsInArray(String tablename);
    
    /**
     * 获取表内容
     * @param tablename
     * @return
     */
    public String[][] getTableContent(String tablename);
    
    /**
     * 将字段名集合处理为JSON格式的字符串
     * @param tablename    对应表名
     * @return    字符串数组，每一项为一个Ext中grid的一个header
     */
    public String[] getfiledsHeaders(String tablename);
    
    /**
     * 将数据处理为JSON格式的字符串
     * @param tablename    对应表名
     * @return    字符串数组，每一项为一条数据库记录
     */
    public String[] getContentStr(String tablename);
    
    
 
    
    /**
     * 获取字段名    
     * @param tablename    表名
     * @return
     */
    public List<MyDataBase> getFieldsBySql(String sql);
    
    /**
     * 获取字段
     * @param tablename 表名
     * @return
     */
    public String[] getFieldsInArrayBySql(String sql);
    
    /**
     * 获取表内容
     * @param tablename
     * @return
     */
    public String[][] getTableContentBySql(String sql);
    
    /**
     * 将字段名集合处理为JSON格式的字符串
     * @param tablename    对应表名
     * @return    字符串数组，每一项为一个Ext中grid的一个header
     */
    public String[] getfiledsHeadersBySql(String sql);
    
}
