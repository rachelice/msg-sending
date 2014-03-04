package com.sunshineroad.framework.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MspTreeData {
	// 构造无序的结果集列表，实际应用中，该数据应该从数据库中查询获得；
	public static List getMspTreeData( String parentCode ) {
		String sql = "select * from MSP_TREE_VIEW " ;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@192.168.40.147:1521:kdp";
		String user = "MSP";
		String pwd = "MSP";
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List dataList = new ArrayList();
        try{
        	Class.forName( driver ).newInstance();
            conn = DriverManager.getConnection( url, user, pwd );
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    		rs = stmt.executeQuery( sql );
    		if( rs != null ){
    			while( rs.next() ) {
    				HashMap dataRecord = new HashMap();
    				dataRecord.put( "id", rs.getString( "code" ) );
    				dataRecord.put("str1", rs.getString( "mobile_num" ));
    				dataRecord.put("text", rs.getString( "name" ));
    				dataRecord.put("parentId", rs.getString( "parent_code" ));
    				dataList.add( dataRecord );
    			}
    		}
        }catch (Exception ex) {
            ex.printStackTrace();
        }
		return dataList;
	}
}
