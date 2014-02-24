package com.sunshineroad.driverschool.mspstudent.entity;
 

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
 * @Description: 学员表
 * @author  
 * @date 2014-02-20 11:03:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "MSP_STUDENT", schema = "")
public class MspStudent extends BaseEntity {
	/**驾校许可证号*/
	private java.lang.String licenseCode;
	/**驾校名称*/
	private java.lang.String enterpriseName;
	/**班期名称*/
	private java.lang.String semesterName;
	/**电话*/
	private java.lang.String userTel;
	/**ID*/
	private java.lang.Long id;
	/**驾校id*/
	private java.lang.Long enterpriseId;
	/**学员姓名*/
	private java.lang.String learnerName;
	/**身份证号*/
	private java.lang.String identityNumber;
	/**性别*/
	private java.lang.String gender;
	/**班期id*/
	private java.lang.Long semesterId;
	/**手机号码*/
	private java.lang.String mobileNumber;
	/**科目一已完成学时*/
	private java.math.BigDecimal subjectOneThFinishtime;
	/**科目二理论已完成学时*/
	private java.math.BigDecimal subjectTwoThFinishtime;
	/**科目二实操已完成学时*/
	private java.math.BigDecimal subjectTwoOpFinishtime;
	/**科目三理论已完成学时*/
	private java.math.BigDecimal subjectThreeThFinishtime;
	/**科目三实操已完成学时*/
	private java.math.BigDecimal subjectThreeOpFinishtime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**创建时间*/
	private java.util.Date createTime;
	/**备注*/
	private java.lang.String remark;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾校许可证号
	 */
	@Column(name ="LICENSE_CODE",nullable=true,length=20)
	public java.lang.String getLicenseCode(){
		return this.licenseCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾校许可证号
	 */
	public void setLicenseCode(java.lang.String licenseCode){
		this.licenseCode = licenseCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾校名称
	 */
	@Column(name ="ENTERPRISE_NAME",nullable=true,length=50)
	public java.lang.String getEnterpriseName(){
		return this.enterpriseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾校名称
	 */
	public void setEnterpriseName(java.lang.String enterpriseName){
		this.enterpriseName = enterpriseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  班期名称
	 */
	@Column(name ="SEMESTER_NAME",nullable=true,length=50)
	public java.lang.String getSemesterName(){
		return this.semesterName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  班期名称
	 */
	public void setSemesterName(java.lang.String semesterName){
		this.semesterName = semesterName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */
	@Column(name ="USER_TEL",nullable=true,length=11)
	public java.lang.String getUserTel(){
		return this.userTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setUserTel(java.lang.String userTel){
		this.userTel = userTel;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  ID
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="MSP_STUDENT_seq",allocationSize=1)
	@Column(name ="ID",nullable=false,precision=20,scale=0)
	public java.lang.Long getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  ID
	 */
	public void setId(java.lang.Long id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  驾校id
	 */
	@Column(name ="ENTERPRISE_ID",nullable=true,precision=20,scale=0)
	public java.lang.Long getEnterpriseId(){
		return this.enterpriseId;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  驾校id
	 */
	public void setEnterpriseId(java.lang.Long enterpriseId){
		this.enterpriseId = enterpriseId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学员姓名
	 */
	@Column(name ="LEARNER_NAME",nullable=true,length=50)
	public java.lang.String getLearnerName(){
		return this.learnerName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学员姓名
	 */
	public void setLearnerName(java.lang.String learnerName){
		this.learnerName = learnerName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="IDENTITY_NUMBER",nullable=true,length=50)
	public java.lang.String getIdentityNumber(){
		return this.identityNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdentityNumber(java.lang.String identityNumber){
		this.identityNumber = identityNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="GENDER",nullable=true,length=4)
	public java.lang.String getGender(){
		return this.gender;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setGender(java.lang.String gender){
		this.gender = gender;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  班期id
	 */
	@Column(name ="SEMESTER_ID",nullable=true,precision=20,scale=0)
	public java.lang.Long getSemesterId(){
		return this.semesterId;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  班期id
	 */
	public void setSemesterId(java.lang.Long semesterId){
		this.semesterId = semesterId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号码
	 */
	@Column(name ="MOBILE_NUMBER",nullable=true,length=11)
	public java.lang.String getMobileNumber(){
		return this.mobileNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号码
	 */
	public void setMobileNumber(java.lang.String mobileNumber){
		this.mobileNumber = mobileNumber;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  科目一已完成学时
	 */
	@Column(name ="SUBJECT_ONE_TH_FINISHTIME",nullable=true,precision=20,scale=6)
	public java.math.BigDecimal getSubjectOneThFinishtime(){
		return this.subjectOneThFinishtime;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  科目一已完成学时
	 */
	public void setSubjectOneThFinishtime(java.math.BigDecimal subjectOneThFinishtime){
		this.subjectOneThFinishtime = subjectOneThFinishtime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  科目二理论已完成学时
	 */
	@Column(name ="SUBJECT_TWO_TH_FINISHTIME",nullable=true,precision=20,scale=6)
	public java.math.BigDecimal getSubjectTwoThFinishtime(){
		return this.subjectTwoThFinishtime;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  科目二理论已完成学时
	 */
	public void setSubjectTwoThFinishtime(java.math.BigDecimal subjectTwoThFinishtime){
		this.subjectTwoThFinishtime = subjectTwoThFinishtime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  科目二实操已完成学时
	 */
	@Column(name ="SUBJECT_TWO_OP_FINISHTIME",nullable=true,precision=20,scale=6)
	public java.math.BigDecimal getSubjectTwoOpFinishtime(){
		return this.subjectTwoOpFinishtime;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  科目二实操已完成学时
	 */
	public void setSubjectTwoOpFinishtime(java.math.BigDecimal subjectTwoOpFinishtime){
		this.subjectTwoOpFinishtime = subjectTwoOpFinishtime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  科目三理论已完成学时
	 */
	@Column(name ="SUBJECT_THREE_TH_FINISHTIME",nullable=true,precision=20,scale=6)
	public java.math.BigDecimal getSubjectThreeThFinishtime(){
		return this.subjectThreeThFinishtime;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  科目三理论已完成学时
	 */
	public void setSubjectThreeThFinishtime(java.math.BigDecimal subjectThreeThFinishtime){
		this.subjectThreeThFinishtime = subjectThreeThFinishtime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  科目三实操已完成学时
	 */
	@Column(name ="SUBJECT_THREE_OP_FINISHTIME",nullable=true,precision=20,scale=6)
	public java.math.BigDecimal getSubjectThreeOpFinishtime(){
		return this.subjectThreeOpFinishtime;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  科目三实操已完成学时
	 */
	public void setSubjectThreeOpFinishtime(java.math.BigDecimal subjectThreeOpFinishtime){
		this.subjectThreeOpFinishtime = subjectThreeOpFinishtime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=200)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
}
