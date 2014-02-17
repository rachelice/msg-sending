package com.sunshineroad.driverschool.freeTable.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.driverschool.sysparameter.entity.SysParameter;
import com.sunshineroad.driverschool.sysparameter.entityvo.SysParameterVo;
import com.sunshineroad.driverschool.freeTable.dao.FreeTableDao;
import com.sunshineroad.driverschool.freeTable.entity.MyDataBase;
import com.sunshineroad.driverschool.freeTable.service.FreeTableService;
import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;
import com.sunshineroad.framework.util.ListUtils;
@Service("freeTableService")
public class FreeTableServiceImpl extends BaseServiceImpl<SysParameter, Integer> implements FreeTableService {
	@Autowired
	private FreeTableDao  freeTableDao;
	
	 
	 
	/**
     * 获取表名
     * @return    List<表>
     */
    public List<MyDataBase> getTables(){
        List<MyDataBase> mdbls=new ArrayList<MyDataBase>();
         
        SQLQuery sq=freeTableDao.createSQLQuery("show tables");
        List<String> sls=sq.list();
        for(String str:sls){
            if("jbpm".equals(str.substring(0, 4)))
                continue;
            MyDataBase mdb=new MyDataBase();
            mdb.setTableName(str);
            mdbls.add(mdb);
        }
        return mdbls;
    }
    
    /**
     * 获取字段名    
     * @param tablename    表名
     * @return
     */
    public List<MyDataBase> getFields(String tablename){
        List<MyDataBase> mdbls=new ArrayList<MyDataBase>();
        SQLQuery sq=freeTableDao.createSQLQuery("desc "+tablename).addScalar("Field");
        List<String> sls=sq.list();
        for(String str:sls){
            MyDataBase mdb=new MyDataBase();
            mdb.setFieldname(str);
            mdbls.add(mdb);
        }
        return mdbls;
    }
    
    /**
     * 获取字段
     * @param tablename 表名
     * @return
     */
    public String[] getFieldsInArray(String tablename){
        String[] fields;
        SQLQuery sq=freeTableDao.createSQLQuery("desc "+tablename).addScalar("Field");
        List<String> sls=sq.list();
        fields=new String[sls.size()];
        for(int i=0;i<sls.size();i++){
            fields[i]=sls.get(i);
        }
        return fields;
    }
    
    /**
     * 获取表内容
     * @param tablename
     * @return
     */
    public String[][] getTableContent(String tablename){
        String[][] content=null;
        SQLQuery sq=freeTableDao.createSQLQuery("select * from "+tablename);
        List<Object[]> ls=sq.list();
        content=new String[ls.size()][getFields(tablename).size()];
        for(int i=0;i<ls.size();i++){
            Object[] strs=ls.get(i);
            for(int j=0;j<strs.length;j++){
                content[i][j]=strs[j]==null?"":strs[j].toString();
            }
        }
        return content;
    }
    
    /**
     * 将字段名集合处理为JSON格式的字符串
     * @param tablename    对应表名
     * @return    字符串数组，每一项为一个Ext中grid的一个header
     */
    public String[] getfiledsHeaders(String tablename){
        String[] fields=this.getFieldsInArray(tablename);
        String[] content=new String[fields.length];
        String temp="{text:'#1',dataIndex:'#1',flex:1}";
        
        for(int i=0;i<fields.length;i++){
            content[i]=temp.replace("#1", fields[i]);
        }
        return content;
    }
    
    /**
     * 将数据处理为JSON格式的字符串
     * @param tablename    对应表名
     * @return    字符串数组，每一项为一条数据库记录
     */
    public String[] getContentStr(String tablename){
        String[] fields=this.getFieldsInArray(tablename);
        String[][] content=this.getTableContent(tablename);
        String jsonContent[]=new String[content.length];
        for(int i=0;i<content.length;i++){
            String temp="";
            for(int j=0;j<fields.length;j++){
                temp=temp+"'"+fields[j]+"':'"+content[i][j]+"',";
            }
            temp="{"+temp.substring(0, temp.length()-1)+"}";
            jsonContent[i]=temp;
        }
    
        return jsonContent;
    }

	@Override
	public List<MyDataBase> getFieldsBySql(String sql) {

        List<MyDataBase> mdbls=new ArrayList<MyDataBase>();
        SQLQuery sq=freeTableDao.createSQLQuery(sql).addScalar("Field");
        List<String> sls=sq.list();
        for(String str:sls){
            MyDataBase mdb=new MyDataBase();
            mdb.setFieldname(str);
            mdbls.add(mdb);
        }
        return mdbls;
    
		 
	}

	@Override
	public String[] getFieldsInArrayBySql(String sql) {
        String[] fields; 
        SQLQuery sq=freeTableDao.createSQLQuery(sql).addScalar("Field");
        List<String> sls=sq.list();
        fields=new String[sls.size()];	
        for(int i=0;i<sls.size();i++){
            fields[i]=sls.get(i);
        }
        return fields;
    }

	@Override
	public String[][] getTableContentBySql(String sql) {
        String[][] content=null;
        SQLQuery sq=freeTableDao.createSQLQuery(sql);
        List<Object[]> ls=sq.list();
        content=new String[ls.size()][getFieldsBySql(sql).size()];
        for(int i=0;i<ls.size();i++){
            Object[] strs=ls.get(i);
            for(int j=0;j<strs.length;j++){
                content[i][j]=strs[j]==null?"":strs[j].toString();
            }
        }
        return content;
    }

	@Override
	public String[] getfiledsHeadersBySql(String sql) {
        String[] fields=this.getFieldsInArrayBySql(sql);
        String[] content=new String[fields.length];
        String temp="{text:'#1',dataIndex:'#1',flex:1}";
        
        for(int i=0;i<fields.length;i++){
            content[i]=temp.replace("#1", fields[i]);
        }
        return content;
    }

	@Override
	public String[] getContentStrBySql(String sql) {
		
		StringBuffer hql= new StringBuffer(" FROM SysParameter  WHERE 1=1");
	 
		hql.append(" ORDER BY sortIndex");
		 List<SysParameterVo> list= ListUtils.transform(freeTableDao.findPageByHql(hql.toString() ),
				SysParameterVo.class);
        String[] fields=this.getFieldsInArrayBySql(sql);
        String[][] content=this.getTableContentBySql(sql);
        String jsonContent[]=new String[content.length];
        for(int i=0;i<content.length;i++){
            String temp="";
            for(int j=0;j<fields.length;j++){
                temp=temp+"'"+fields[j]+"':'"+content[i][j]+"',";
            }
            temp="{"+temp.substring(0, temp.length()-1)+"}";
            jsonContent[i]=temp;
        }
    
        return jsonContent;
    }
}
