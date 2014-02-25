package com.sunshineroad.driverschool.sysparameter.entity;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sunshineroad.framework.support.entity.BaseEntity;

/**   
 * @Title: Entity
 * @Description: 参数
 * @author  
 * @date 2014-01-09 10:34:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_parameter", schema = "")
public class SysParameter extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**id*/
	private java.lang.Long id;
	/**参数名称*/
	private java.lang.String parName;
	/**参数代码*/
	private java.lang.String parCode;
	/**上级参数*/
	private java.lang.Long parUpId;
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

	@Column(name ="IS_DEF",nullable=true)
	@org.hibernate.annotations.Type(type="yes_no")
	private boolean isDef;
	
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="sys_parameter_seq",allocationSize=1)
	@Column(name ="ID",nullable=false,precision=32,scale=0)
	public java.lang.Long getId(){
		return this.id;
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
	@Column(name ="PAR_NAME",nullable=true,length=100)
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
	@Column(name ="PAR_CODE",nullable=true,length=100)
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
	@Column(name ="PAR_UP_ID",nullable=true,precision=32,scale=0)
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
	@Column(name ="ICO_URL",nullable=true,length=500)
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

	@Column(name ="IS_DIR",nullable=true )
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
	@Column(name ="PAR_TYPE",nullable=true,length=100)
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
	@Column(name ="PAR_LEV",nullable=true,precision=2,scale=0)
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

	@org.hibernate.annotations.Type(type="yes_no")
	@Column(name ="IS_EXP",nullable=true )
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
	@Column(name ="SORT_INDEX",nullable=true,precision=5,scale=0)
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
	@Column(name ="IS_DEF",nullable=true)
	@org.hibernate.annotations.Type(type="yes_no")
	public Boolean getIsDef(){
		return this.isDef;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  默认选中
	 */
 
	public void setIsDef(boolean isDef){
		this.isDef = isDef;
	}
}
