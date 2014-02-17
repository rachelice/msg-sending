package com.sunshineroad.system.resource.vo;

import java.util.ArrayList;
import java.util.List;

import com.sunshineroad.framework.util.TreeNode;
import com.sunshineroad.system.resource.entity.ResourceModel;


public class ResourceNode {

	private Integer id;
	
	private String text;
	
	private String iconCls;
	
	private String type;
	
	private String component;
	
	private String description;
	
	private String url;
	
	private Integer parent_id;
	
	private Integer index;
	
	private boolean leaf;

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

/*	@Override
	public int compareTo(ResourceNode o) {
		// TODO Auto-generated method stub
		return this.getIndex().compareTo(o.getIndex());
	}*/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	
	public static List<TreeNode> resourceList2TreeNodeList(List<ResourceModel> resList){
		if(resList==null){
			return null;
		}
		List<TreeNode> nodeList= new ArrayList<TreeNode>();
		for (int i = 0; i < resList.size(); i++) {
			nodeList.add(ResourceNode.resource2TreeNode(resList.get(i)));
		}
		
		return nodeList;
	}
	public static TreeNode resource2TreeNode(ResourceModel res){
		if(null==res){
			return null;
		}
		int parentid=0;
		if(res.getParent() != null){
			parentid=res.getParent().getId();
		}else{
			parentid=9999;
		}
		TreeNode node = new TreeNode(
				res.getId(),		 //Integer id,              
				parentid,	 //Integer parentId,        
				res.getIndex(),	 //Integer index,           
				Integer.valueOf(0),	 //Integer int1,       getManager     
				Integer.valueOf(0),	 //Integer int2,            
				Integer.valueOf(0),	 //Integer int3,            
				Integer.valueOf(0),	 //Integer int4,            
				res.getText(),	 //String text,             
				res.getComponent(),	 //String str1,             
				res.getType(),	 //String str2,             
				res.getUrl(),	 //String str3,             
				res.getDescription(),	 //String str4,             
				res.getIconCls(),	 //String str5,             
				"",			 //String str6,             
				"",			 //String str7,             
				"",			 //String str8,             
				res.getLeaf(), //boolean leaf,
				res.isChecked(), //boolean checked
				true			 //boolean expanded 
				);
		return node;
	}
}
