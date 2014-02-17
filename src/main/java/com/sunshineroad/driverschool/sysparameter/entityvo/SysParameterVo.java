package com.sunshineroad.driverschool.sysparameter.entityvo;

import java.util.ArrayList;
import java.util.List;

import com.sunshineroad.framework.util.TreeNode;

/**   
 * @Title: Entity
 * @Description: 参数
 * @author  
 * @date 2014-01-09 10:34:34
 * @version V1.0   
 *
 */

public class SysParameterVo   {
	/**id*/
	private java.lang.Long id;
	/**参数名称*/
	private java.lang.String parName;
	/**参数代码*/
	private java.lang.String parCode;
	/**上级参数*/
	private java.lang.Long parUpId;
	/**上级参数*/
	private java.lang.String parUpName;
	/**图标路径*/
	private java.lang.String icoUrl;
	/**是否有子类*/
	private Boolean isDir;
	/**参数类型*/
	private java.lang.String parType;
	/**层级*/
	private java.lang.Integer parLev;
	/**是否默认展开*/
	private Boolean isExp;
	/**排序序号*/
	private java.lang.Integer sortIndex;
	/**默认选中*/
	private Boolean isDef;
	
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  id
	 */
public java.lang.Long getId(){
		return this.id;
	}

	public java.lang.String getParUpName() {
		return parUpName;
	}

	public void setParUpName(java.lang.String parUpName) {
		this.parUpName = parUpName;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  id
	 */
	public void setId(java.lang.Long id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数名称
	 */
public java.lang.String getParName(){
		return this.parName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数名称
	 */
	public void setParName(java.lang.String parName){
		this.parName = parName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数代码
	 */
public java.lang.String getParCode(){
		return this.parCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数代码
	 */
	public void setParCode(java.lang.String parCode){
		this.parCode = parCode;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  上级参数
	 */
public java.lang.Long getParUpId(){
		return this.parUpId;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  上级参数
	 */
	public void setParUpId(java.lang.Long parUpId){
		this.parUpId = parUpId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图标路径
	 */
public java.lang.String getIcoUrl(){
		return this.icoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标路径
	 */
	public void setIcoUrl(java.lang.String icoUrl){
		this.icoUrl = icoUrl;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否有子类
	 */
public Boolean getIsDir(){
		return this.isDir;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否有子类
	 */
	public void setIsDir(Boolean isDir){
		this.isDir = isDir;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数类型
	 */
public java.lang.String getParType(){
		return this.parType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数类型
	 */
	public void setParType(java.lang.String parType){
		this.parType = parType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  层级
	 */
public java.lang.Integer getParLev(){
		return this.parLev;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  层级
	 */
	public void setParLev(java.lang.Integer parLev){
		this.parLev = parLev;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否默认展开
	 */
public Boolean getIsExp(){
		return this.isExp;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否默认展开
	 */
	public void setIsExp(Boolean isExp){
		this.isExp = isExp;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序序号
	 */
public java.lang.Integer getSortIndex(){
		return this.sortIndex;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序序号
	 */
	public void setSortIndex(java.lang.Integer sortIndex){
		this.sortIndex = sortIndex;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  默认选中
	 */
public Boolean getIsDef(){
		return this.isDef;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  默认选中
	 */
	public void setIsDef(Boolean isDef){
		this.isDef = isDef;
	}
	public static TreeNode sysParameterVo2TreeNode(SysParameterVo vo){
		if(null==vo){
			return null;
		}
		TreeNode treenode = new TreeNode();
		 treenode.setId(Integer.valueOf(vo.getId().toString()));
		 treenode.setIndex(vo.getSortIndex());
		 treenode.setLeaf(!(vo.getIsDef()!=null&&vo.getIsDir()));
		
		 if(vo.getParUpId()!=null){
			 treenode.setParentId(Integer.valueOf(vo.getParUpId().toString()));
		 }else{
			 treenode.setParentId(0);
		 }
		 
		 treenode.setText(vo.getParName());
		 treenode.setExpanded(vo.getIsDef());
		 
		return treenode;
	}

	public static List<TreeNode> voList2TreenodeList( List<SysParameterVo> list) {
		if(null==list)return null;
		List<TreeNode> tList= new ArrayList<TreeNode>();
		for(SysParameterVo vo:list){
			tList.add(sysParameterVo2TreeNode(vo));
		}
		return tList;
	}
}
