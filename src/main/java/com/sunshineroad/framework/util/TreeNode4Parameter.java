package com.sunshineroad.framework.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 定义树节点
 */
public class TreeNode4Parameter {

	
	/**id*/
	private java.lang.Long id;
	/**参数名称*/
	private java.lang.String text;
	/**参数代码*/
	private java.lang.String code;
	/**上级参数*/
	private java.lang.Long pId;
	/**图标路径*/
	private java.lang.String icoUrl;
	
	//是否是叶子节点
	private boolean leaf;
	/**参数类型*/
	private java.lang.String parType;
	/**层级*/
	private java.lang.Integer parLev;
	/**是否默认展开*/
	private java.lang.Integer isExp;
	/**排序序号*/
	private java.lang.Integer sortIndex;
	/**默认选中*/
	private java.lang.Integer isDef;
	
	 
	
	//子节点的集合
	//(@JsonInclude(Include.NON_NULL)序列化时的标记 如果为空则不参与序列化)
	@JsonInclude(Include.NON_NULL)  
	private List<TreeNode4Parameter> children;

	public TreeNode4Parameter() {}
	
	public TreeNode4Parameter(long id, String text, boolean leaf) {
		super();
		this.id = id;
		this.text = text;
		this.leaf = leaf;
	}

	public TreeNode4Parameter(long id, String text, boolean leaf, List<TreeNode4Parameter> children) {
		super();
		this.id = id;
		this.text = text;
		this.leaf = leaf;
		this.children = children;
	}
	 
}
