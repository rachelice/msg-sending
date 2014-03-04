package com.sunshineroad.framework.util;

import java.util.Comparator;

/**
 * 节点比较器
 */
public class NodeIDComparator implements Comparator {
	// 按照节点编号比较
	public int compare(Object o1, Object o2) {
		String j1 = ((Node)o1).id.replace("-", "");
		String j2 = ((Node)o2).id.replace("-", "");
	    int result = (j1.compareTo(j2));
	    if( result < 0 ){
	    	return -1;
	    }else if( result > 0 ){
	    	return 1;
	    }else{
	    	return 0;
	    }
	}
}
