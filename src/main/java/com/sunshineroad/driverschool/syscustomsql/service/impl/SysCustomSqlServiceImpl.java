package com.sunshineroad.driverschool.syscustomsql.service.impl;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunshineroad.driverschool.freeTable.entity.MyDataBase;
import com.sunshineroad.driverschool.syscustomsql.dao.SysCustomSqlDao;
import com.sunshineroad.driverschool.syscustomsql.entity.SysCustomSql;
import com.sunshineroad.driverschool.syscustomsql.entityvo.SysCustomSqlVo;
import com.sunshineroad.driverschool.syscustomsql.service.SysCustomSqlService;
import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;
import com.sunshineroad.framework.util.ListUtils;

@Service("sysCustomSqlService")
@Transactional
public class SysCustomSqlServiceImpl extends BaseServiceImpl<SysCustomSql, Integer>  implements SysCustomSqlService {
	@Autowired
	private SysCustomSqlDao  sysCustomSqlDao;

	
	public SysCustomSql getSysCustomSqlById(Integer id){
		StringBuffer hql= new StringBuffer(" FROM SysCustomSql  WHERE id="+id);
		 List<SysCustomSql> list=sysCustomSqlDao.findByHQL(hql.toString());
		 if(null==list||list.size()==0){
			 return null;
		 }
		 
		 return list.get(0);
	}
	public List<SysCustomSqlVo> list(SysCustomSql entity) {
		HQLParameter p = new HQLParameter(SysCustomSql.class);	   
		return ListUtils.transform(sysCustomSqlDao.findPageByHql(" from SysCustomSql "   ),
				SysCustomSqlVo.class);
	}
	
	 
		/**
	     * 获取表名
	     * @return    List<表>
	     */
	    public List<MyDataBase> getTables(){
	        List<MyDataBase> mdbls=new ArrayList<MyDataBase>();
	         
	        SQLQuery sq=sysCustomSqlDao.createSQLQuery("show tables");
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
	        SQLQuery sq=sysCustomSqlDao.createSQLQuery("desc "+tablename).addScalar("Field");
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
	        SQLQuery sq=sysCustomSqlDao.createSQLQuery("desc "+tablename).addScalar("Field");
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
	        SQLQuery sq=sysCustomSqlDao.createSQLQuery("select * from "+tablename);
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
	        SQLQuery sq=sysCustomSqlDao.createSQLQuery(sql).addScalar("Field");
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
	        SQLQuery sq=sysCustomSqlDao.createSQLQuery(sql).addScalar("Field");
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
	        SQLQuery sq=sysCustomSqlDao.createSQLQuery(sql);
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
/*
 * (non-Javadoc)
 * @see com.sunshineroad.driverschool.syscustomsql.service.SysCustomSqlService#getContentStrBySql(java.lang.String)
 
 public static void main(String[] args) {
        Connection conn = getConnection();
        String sql = "select * from class";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= data.getColumnCount(); i++) {
                    // 获得所有列的数目及实际列数
                    int columnCount = data.getColumnCount();
                    // 获得指定列的列名
                    String columnName = data.getColumnName(i);
                    // 获得指定列的列值
                    String columnValue = rs.getString(i);
                    // 获得指定列的数据类型
                    int columnType = data.getColumnType(i);
                    // 获得指定列的数据类型名
                    String columnTypeName = data.getColumnTypeName(i);
                    // 所在的Catalog名字
                    String catalogName = data.getCatalogName(i);
                    // 对应数据类型的类
                    String columnClassName = data.getColumnClassName(i);
                    // 在数据库中类型的最大字符个数
                    int columnDisplaySize = data.getColumnDisplaySize(i);
                    // 默认的列的标题
                    String columnLabel = data.getColumnLabel(i);
                    // 获得列的模式
                    String schemaName = data.getSchemaName(i);
                    // 某列类型的精确度(类型的长度)
                    int precision = data.getPrecision(i);
                    // 小数点后的位数
                    int scale = data.getScale(i);
                    // 获取某列对应的表名
                    String tableName = data.getTableName(i);
                    // 是否自动递增
                    boolean isAutoInctement = data.isAutoIncrement(i);
                    // 在数据库中是否为货币型
                    boolean isCurrency = data.isCurrency(i);
                    // 是否为空
                    int isNullable = data.isNullable(i);
                    // 是否为只读
                    boolean isReadOnly = data.isReadOnly(i);
                    // 能否出现在where中
                    boolean isSearchable = data.isSearchable(i);
                    System.out.println(columnCount);
                    System.out.println("获得列" + i + "的字段名称:" + columnName);
                    System.out.println("获得列" + i + "的字段值:" + columnValue);
                    System.out.println("获得列" + i + "的类型,返回SqlType中的编号:"
                            + columnType);
                    System.out.println("获得列" + i + "的数据类型名:" + columnTypeName);
                    System.out.println("获得列" + i + "所在的Catalog名字:"
                            + catalogName);
                    System.out.println("获得列" + i + "对应数据类型的类:"
                            + columnClassName);
                    System.out.println("获得列" + i + "在数据库中类型的最大字符个数:"
                            + columnDisplaySize);
                    System.out.println("获得列" + i + "的默认的列的标题:" + columnLabel);
                    System.out.println("获得列" + i + "的模式:" + schemaName);
                    System.out
                            .println("获得列" + i + "类型的精确度(类型的长度):" + precision);
                    System.out.println("获得列" + i + "小数点后的位数:" + scale);
                    System.out.println("获得列" + i + "对应的表名:" + tableName);
                    System.out.println("获得列" + i + "是否自动递增:" + isAutoInctement);
                    System.out.println("获得列" + i + "在数据库中是否为货币型:" + isCurrency);
                    System.out.println("获得列" + i + "是否为空:" + isNullable);
                    System.out.println("获得列" + i + "是否为只读:" + isReadOnly);
                    System.out.println("获得列" + i + "能否出现在where中:"
                            + isSearchable);
                }
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
    }
    
    获得列1的字段名称:CLASS_NO
获得列1的字段值:111
获得列1的类型,返回SqlType中的编号:12
获得列1的数据类型名:VARCHAR2
获得列1所在的Catalog名字:
获得列1对应数据类型的类:java.lang.String
获得列1在数据库中类型的最大字符个数:10
获得列1的默认的列的标题:CLASS_NO
获得列1的模式:
获得列1类型的精确度(类型的长度):10
获得列1小数点后的位数:0
获得列1对应的表名:
获得列1是否自动递增:false
获得列1在数据库中是否为货币型:false
获得列1是否为空:0
获得列1是否为只读:false
获得列1能否出现在where中:true
 
 */
		@Override
		public String[] getContentStrBySql(String sql) {
			 
			/*sql = "select adad as uu,basasas,1+2 aspp from dual";
			
			
			Pattern p = Pattern.compile("\\bselect\\b(.*?)\\bfrom\\b");//正则表达式，取select和from之间的字符串，不包括select和from
			Matcher m = p.matcher(sql.toLowerCase());
			String fieldstr="";
			while(m.find()) {
				fieldstr=m.group(1);
			       //System.out.println("找到啦====="+m.group(1));//m.group(1)不包括这两个字符

			}
			if(fieldstr==null||fieldstr.equals("")){
				return null;
			};
	        String[] fieldstemp=fieldstr.split(",");
	        String[] fields=new String[fieldstemp.length];
	        for(int i=0;i<fieldstemp.length;i++ ){
	        	String[] as =fieldstemp[i].split("\\bas\\b");
	        	if(as.length>1){
	        		fields[i]=as[1].trim().toLowerCase();
	        	}else{
	        		fields[i]=as[0].trim().toLowerCase();
	        	}
	        	System.out.println("找到啦====="+fields[i]);
	        }
	       // List<MyDataBase> list=getFields("sys_parameter");
	        sql = "select * from sys_parameter";
	      */
			ArrayList<String> jsonContent =new ArrayList<String>();
	        try {
	        	java.sql.ResultSet rs=this.sysCustomSqlDao.selectBySql(sql);
	        	ResultSetMetaData rsmd = rs.getMetaData();  
	        	 
	        	int sum=0;
	        	while (rs.next()) {  
	        		StringBuffer temp = new StringBuffer(" ");
	        	    for (int i = 1; i <= rsmd.getColumnCount(); i++) {  
	        	       /*
	        	    	System.out.print("列名=="+rsmd.getColumnName(i));  
	        	        System.out.print("\t");  
	        	        System.out.print(rs.getObject(i));  
	        	        */
	        	    	if(null!=rs.getObject(i)||sum==0){
	        	    		//第一行数据为空也输出，第二行开始只输出不为空的字段
	        	    		ResultSetMetaData data = rs.getMetaData();
	        	    		// 获得所有列的数目及实际列数
	                        int columnCount = data.getColumnCount();
	                        // 获得指定列的列名
	                        String columnName = data.getColumnName(i);
	                        // 获得指定列的列值
	                        String columnValue = rs.getString(i);
	                        // 获得指定列的数据类型
	                        int columnType = data.getColumnType(i);
	                        // 获得指定列的数据类型名
	                        String columnTypeName = data.getColumnTypeName(i);
	                        // 所在的Catalog名字
	                        String catalogName = data.getCatalogName(i);
	                        // 对应数据类型的类
	                        String columnClassName = data.getColumnClassName(i);
	                        // 在数据库中类型的最大字符个数
	                        int columnDisplaySize = data.getColumnDisplaySize(i);
	                        // 默认的列的标题
	                        String columnLabel = data.getColumnLabel(i);
	                        // 获得列的模式
	                        String schemaName = data.getSchemaName(i);
	                        // 某列类型的精确度(类型的长度)
	                        int precision = data.getPrecision(i);
	                        // 小数点后的位数
	                        int scale = data.getScale(i);
	                        // 获取某列对应的表名
	                        String tableName = data.getTableName(i);
	                        // 是否自动递增
	                        boolean isAutoInctement = data.isAutoIncrement(i);
	                        // 在数据库中是否为货币型
	                        boolean isCurrency = data.isCurrency(i);
	                        // 是否为空
	                        int isNullable = data.isNullable(i);
	                        // 是否为只读
	                        boolean isReadOnly = data.isReadOnly(i);
	                        // 能否出现在where中
	                        boolean isSearchable = data.isSearchable(i);
	                        System.out.println(columnCount);
	                        System.out.println("获得列" + i + "的字段名称:" + columnName);
	                        System.out.println("获得列" + i + "的字段值:" + columnValue);
	                        System.out.println("获得列" + i + "的类型,返回SqlType中的编号:"
	                                + columnType);
	                        System.out.println("获得列" + i + "的数据类型名:" + columnTypeName);
	                        System.out.println("获得列" + i + "所在的Catalog名字:"
	                                + catalogName);
	                        System.out.println("获得列" + i + "对应数据类型的类:"
	                                + columnClassName);
	                        System.out.println("获得列" + i + "在数据库中类型的最大字符个数:"
	                                + columnDisplaySize);
	                        System.out.println("获得列" + i + "的默认的列的标题:" + columnLabel);
	                        System.out.println("获得列" + i + "的模式:" + schemaName);
	                        System.out
	                                .println("获得列" + i + "类型的精确度(类型的长度):" + precision);
	                        System.out.println("获得列" + i + "小数点后的位数:" + scale);
	                        System.out.println("获得列" + i + "对应的表名:" + tableName);
	                        System.out.println("获得列" + i + "是否自动递增:" + isAutoInctement);
	                        System.out.println("获得列" + i + "在数据库中是否为货币型:" + isCurrency);
	                        System.out.println("获得列" + i + "是否为空:" + isNullable);
	                        System.out.println("获得列" + i + "是否为只读:" + isReadOnly);
	                        System.out.println("获得列" + i + "能否出现在where中:"
	                                + isSearchable);
	                        

	                        System.out.println("-------------------------------------------" );
	        	    		String str=rs.getObject(i)==null?"":rs.getObject(i).toString();
	        	    		temp.append( ""+rsmd.getColumnName(i)+":'"+str+"',");
	        	    	}
	        	    }    
	        	    sum++;
	        	    temp=new StringBuffer("{"+temp.substring(0, temp.length()-1)+"}");
	        	    
	        	    jsonContent.add(temp.toString());
	        	   // System.out.print("\n");  
	        	   
	        	}  
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
	       String[] result = new String[jsonContent.size()];
	       jsonContent.toArray( result);
	        return result;
	    }
	
		@Override
	public void update(SysCustomSql model)  {
		this.sysCustomSqlDao.update(model);	
	}
	
	@Override
	public SysCustomSql save(SysCustomSql model)   {
		this.sysCustomSqlDao.save(model);	
		return model;
	}

	@Override
	public void delete(SysCustomSql model)  {
		this.sysCustomSqlDao.delete(model);	
	}
}


