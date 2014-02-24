package com.sunshineroad.driverschool.mspmsglisthistory.entity;
 

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
 * @Description: 短信清单历史记录
 * @author  
 * @date 2014-02-24 12:50:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "msp_msg_list_history", schema = "")
public class MspMsgListHistory extends BaseEntity {
	/**id*/
	private java.lang.Long id;
	/**messagenum*/
	private java.lang.String messagenum;
	/**content*/
	private java.lang.String content;
	/**mobilenumber*/
	private java.sql.Clob mobilenumber;
	/**status*/
	private java.lang.String status;
	/**sendingtime*/
	private java.util.Date sendingtime;
	/**priority*/
	private java.lang.Integer priority;
	/**count*/
	private java.lang.Integer count;
	/**createtime*/
	private java.util.Date createtime;
	
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="msp_msg_list_history_seq",allocationSize=1)
	@Column(name ="ID",nullable=false,precision=20,scale=0)
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
	 *@return: java.lang.String  messagenum
	 */
	@Column(name ="MESSAGENUM",nullable=true,length=16)
	public java.lang.String getMessagenum(){
		return this.messagenum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  messagenum
	 */
	public void setMessagenum(java.lang.String messagenum){
		this.messagenum = messagenum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  content
	 */
	@Column(name ="CONTENT",nullable=true,length=150)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  content
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.sql.Clob
	 *@return: java.sql.Clob  mobilenumber
	 */
	@Column(name ="MOBILENUMBER",nullable=true)
	public java.sql.Clob getMobilenumber(){
		return this.mobilenumber;
	}

	/**
	 *方法: 设置java.sql.Clob
	 *@param: java.sql.Clob  mobilenumber
	 */
	public void setMobilenumber(java.sql.Clob mobilenumber){
		this.mobilenumber = mobilenumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  status
	 */
	@Column(name ="STATUS",nullable=true,length=4)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  status
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  sendingtime
	 */
	@Column(name ="SENDINGTIME",nullable=true)
	public java.util.Date getSendingtime(){
		return this.sendingtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  sendingtime
	 */
	public void setSendingtime(java.util.Date sendingtime){
		this.sendingtime = sendingtime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  priority
	 */
	@Column(name ="PRIORITY",nullable=true)
	public java.lang.Integer getPriority(){
		return this.priority;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  priority
	 */
	public void setPriority(java.lang.Integer priority){
		this.priority = priority;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  count
	 */
	@Column(name ="COUNT",nullable=true)
	public java.lang.Integer getCount(){
		return this.count;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  count
	 */
	public void setCount(java.lang.Integer count){
		this.count = count;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createtime
	 */
	@Column(name ="CREATETIME",nullable=true)
	public java.util.Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createtime
	 */
	public void setCreatetime(java.util.Date createtime){
		this.createtime = createtime;
	}
}
