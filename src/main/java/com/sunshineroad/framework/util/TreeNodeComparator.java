package com.sunshineroad.framework.util;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class TreeNodeComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		TreeNode node1=(TreeNode)o1;
		TreeNode node2=(TreeNode)o2;
		if(node1.getParentId()!=node2.getParentId()){
			return node1.getParentId()-node2.getParentId();
		}else{
			if(null!=node1.getIndex()&&node1.getIndex()!=node2.getIndex()){
				return node1.getIndex()-node2.getIndex();
			}else{
				return node1.getId()-node2.getId();
			}
		}
		 
	}

}
