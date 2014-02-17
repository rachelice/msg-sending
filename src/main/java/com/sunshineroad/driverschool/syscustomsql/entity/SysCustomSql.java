package com.sunshineroad.driverschool.syscustomsql.entity;
 

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

import java.util.List;

import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;

import com.sunshineroad.framework.support.entity.BaseEntity;

/**   
 * @Title: Entity
 * @Description: 报表
 * @author  
 * @date 2014-01-26 17:58:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sys_custom_sql", schema = "")
public class SysCustomSql extends BaseEntity {
	/**id*/
	private java.lang.Long id;
	/**sql*/
	private java.lang.String sql;
	/**note*/
	private java.lang.String note;
	/**count*/
	private java.lang.Long count;
	/**title*/
	private java.lang.String title;
	/**state*/
	private Boolean state;
	/**parentParamId*/
	private java.lang.Long parentParamId;
	/**syb1*/
	private java.lang.String syb1;
	/**syb2*/
	private java.lang.String syb2;
	/**syb3*/
	private java.lang.String syb3;
	/**syb4*/
	private java.lang.String syb4;
	/**syb5*/
	private java.lang.String syb5;
	/**createDate*/
	private java.util.Date createDate;
	
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="sys_custom_seq",allocationSize=1)
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
	 *@return: java.lang.String  sql
	 */
	@Column(name ="SQL",nullable=true,length=4000)
	public java.lang.String getSql(){
		return this.sql;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sql
	 */
	public void setSql(java.lang.String sql){
		this.sql = sql;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  note
	 */
	@Column(name ="NOTE",nullable=true,length=2000)
	public java.lang.String getNote(){
		return this.note;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  note
	 */
	public void setNote(java.lang.String note){
		this.note = note;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  count
	 */
	@Column(name ="COUNT",nullable=true,precision=32,scale=0)
	public java.lang.Long getCount(){
		return this.count;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  count
	 */
	public void setCount(java.lang.Long count){
		this.count = count;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  title
	 */
	@Column(name ="TITLE",nullable=true,length=2000)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  title
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  state
	 */
	@org.hibernate.annotations.Type(type="yes_no")
	@Column(name ="STATE",nullable=true,length=2)
	public Boolean getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  state
	 */
	public void setState(Boolean state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  parentParamId
	 */
	@Column(name ="PARENT_PARAM_ID",nullable=true,precision=32,scale=0)
	public java.lang.Long getParentParamId(){
		return this.parentParamId;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  parentParamId
	 */
	public void setParentParamId(java.lang.Long parentParamId){
		this.parentParamId = parentParamId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syb1
	 */
	@Column(name ="SYB1",nullable=true,length=200)
	public java.lang.String getSyb1(){
		return this.syb1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  syb1
	 */
	public void setSyb1(java.lang.String syb1){
		this.syb1 = syb1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syb2
	 */
	@Column(name ="SYB2",nullable=true,length=200)
	public java.lang.String getSyb2(){
		return this.syb2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  syb2
	 */
	public void setSyb2(java.lang.String syb2){
		this.syb2 = syb2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syb3
	 */
	@Column(name ="SYB3",nullable=true,length=200)
	public java.lang.String getSyb3(){
		return this.syb3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  syb3
	 */
	public void setSyb3(java.lang.String syb3){
		this.syb3 = syb3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syb4
	 */
	@Column(name ="SYB4",nullable=true,length=200)
	public java.lang.String getSyb4(){
		return this.syb4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  syb4
	 */
	public void setSyb4(java.lang.String syb4){
		this.syb4 = syb4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  syb5
	 */
	@Column(name ="SYB5",nullable=true,length=200)
	public java.lang.String getSyb5(){
		return this.syb5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  syb5
	 */
	public void setSyb5(java.lang.String syb5){
		this.syb5 = syb5;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createDate
	 */
	@Column(name ="CREATE_DATE",nullable=true,scale=6)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createDate
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
}
