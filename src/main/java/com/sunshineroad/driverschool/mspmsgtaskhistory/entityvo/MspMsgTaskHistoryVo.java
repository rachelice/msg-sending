package com.sunshineroad.driverschool.mspmsgtaskhistory.entityvo;

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
 * @Description: 短信任务
 * @author  
 * @date 2014-02-24 12:48:15
 * @version V1.0   
 *
 */

public class MspMsgTaskHistoryVo   {
	/**id*/
	private java.lang.Long id;
	/**msgNum*/
	private java.lang.String msgNum;
	/**msgContent*/
	private java.lang.String msgContent;
	/**msgType*/
	private java.lang.String msgType;
	/**status*/
	private java.lang.String status;
	/**sendingTime*/
	private java.util.Date sendingTime;
	/**priority*/
	private java.lang.Integer priority;
	/**createTime*/
	private java.util.Date createTime;
	/**submitTime*/
	private java.util.Date submitTime;
	/**submitterCode*/
	private java.lang.String submitterCode;
	/**groupSending*/
	private java.lang.String groupSending;
	/**businessCode*/
	private java.lang.String businessCode;
	
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  id
	 */
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
	 *@return: java.lang.String  msgNum
	 */
public java.lang.String getMsgNum(){
		return this.msgNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  msgNum
	 */
	public void setMsgNum(java.lang.String msgNum){
		this.msgNum = msgNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  msgContent
	 */
public java.lang.String getMsgContent(){
		return this.msgContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  msgContent
	 */
	public void setMsgContent(java.lang.String msgContent){
		this.msgContent = msgContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  msgType
	 */
public java.lang.String getMsgType(){
		return this.msgType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  msgType
	 */
	public void setMsgType(java.lang.String msgType){
		this.msgType = msgType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  status
	 */
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
	 *@return: java.util.Date  sendingTime
	 */
public java.util.Date getSendingTime(){
		return this.sendingTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  sendingTime
	 */
	public void setSendingTime(java.util.Date sendingTime){
		this.sendingTime = sendingTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  priority
	 */
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createTime
	 */
public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  submitTime
	 */
public java.util.Date getSubmitTime(){
		return this.submitTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  submitTime
	 */
	public void setSubmitTime(java.util.Date submitTime){
		this.submitTime = submitTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  submitterCode
	 */
public java.lang.String getSubmitterCode(){
		return this.submitterCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  submitterCode
	 */
	public void setSubmitterCode(java.lang.String submitterCode){
		this.submitterCode = submitterCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  groupSending
	 */
public java.lang.String getGroupSending(){
		return this.groupSending;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  groupSending
	 */
	public void setGroupSending(java.lang.String groupSending){
		this.groupSending = groupSending;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  businessCode
	 */
public java.lang.String getBusinessCode(){
		return this.businessCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  businessCode
	 */
	public void setBusinessCode(java.lang.String businessCode){
		this.businessCode = businessCode;
	}
}
