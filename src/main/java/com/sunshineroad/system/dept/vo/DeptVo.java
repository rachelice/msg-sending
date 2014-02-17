package com.sunshineroad.system.dept.vo;

import java.util.ArrayList;
import java.util.List;

import com.sunshineroad.framework.util.TreeNode;
import com.sunshineroad.system.dept.entity.Dept;

public class DeptVo {

	private Integer id;

	private String deptName;
	/**
	 * 代码
	 */
	private String deptCode;
	/**
	 * 描述
	 */
	private String description;
 
	
	private String deptLevel;
	
	
	private Integer parentId;

	private String parentDeptName;
		
	private String address;
	
	private String email;
	
	private String leaf;
	
	private Integer orderIndex;
	
	private Integer manager;

	
	public static List<TreeNode> deptList2TreeNodeList(List<Dept> deptList){
		if(deptList==null){
			return null;
		}
		List<TreeNode> nodeList= new ArrayList<TreeNode>();
		for (int i = 0; i < deptList.size(); i++) {
			nodeList.add(DeptVo.dept2TreeNode(deptList.get(i)));
		}
		
		return nodeList;
	}
	public static TreeNode dept2TreeNode(Dept dept){
		if(null==dept){
			return null;
		}
		TreeNode node = new TreeNode(
				dept.getId(),		 //Integer id,              
				dept.getParentId(),	 //Integer parentId,        
				dept.getOrderIndex(),	 //Integer index,           
				dept.getManager(),	 //Integer int1,       getManager     
				Integer.valueOf(0),	 //Integer int2,            
				Integer.valueOf(0),	 //Integer int3,            
				Integer.valueOf(0),	 //Integer int4,            
				dept.getDeptName(),	 //String text,             
				dept.getDeptCode(),	 //String str1,             
				dept.getDeptLevel(),	 //String str2,             
				dept.getDeptName(),	 //String str3,             
				dept.getDescription(),	 //String str4,             
				dept.getEmail(),	 //String str5,             
				dept.getAddress(),			 //String str6,             
				"",			 //String str7,             
				"",			 //String str8,             
				dept.getLeaf()!=null&&dept.getLeaf().equalsIgnoreCase("1"), //boolean leaf, 
				false,
				false			 //boolean expanded  
);
		return node;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}
	
	public String getParentDeptName() {
		return parentDeptName;
	}

	public void setParentDeptName(String parentDeptName) {
		this.parentDeptName = parentDeptName;
	}
	
}
