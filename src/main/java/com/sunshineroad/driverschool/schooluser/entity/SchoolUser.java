package com.sunshineroad.driverschool.schooluser.entity;
 

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
 * @Description: uu
 * @author  
 * @date 2013-12-25 14:03:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "cip_user", schema = "")
public class SchoolUser extends BaseEntity {
	/**照片路径*/
	private java.lang.String picPath;
	/**邮件*/
	private java.lang.String userEmail;
	/**生日*/
	private java.util.Date userBirthday;
	/**上一次登陆时间*/
	private java.util.Date lastLoginTime;
	/**用户密码*/
	private java.lang.String password;
	/**1：正常；0：仅不能登录，不影响任何业务筛选*/
	private java.lang.Long enabled;
	/**credentialsNonExpired*/
	private java.lang.Long credentialsNonExpired;
	/**accountNonLocked*/
	private java.lang.Long accountNonLocked;
	/**accountNonExpired*/
	private java.lang.Long accountNonExpired;
	/**clientId*/
	private java.lang.Long clientId;
	/**驾校id*/
	private java.lang.Long drivingschoolId;
	/**证件类型*/
	private java.lang.String identityType;
	/**证件号*/
	private java.lang.String identityNum;
	/**性别*/
	private java.lang.String sex;
	/**名族*/
	private java.lang.String race;
	/**驾校数据*/
	private java.lang.String coachData;
	/**机构*/
	private java.lang.Long organizationId;
	/**指纹特征码1*/
	private java.lang.String fingerFeaturesOne;
	/**指纹特征码2*/
	private java.lang.String fingerFeaturesTwo;
	/**学员id，学员唯一标示*/
	private java.lang.Long id;
	/**uuid*/
	private java.lang.String uuid;
	/**更新时间*/
	private java.util.Date updateTime;
	/**创建时间*/
	private java.util.Date createTime;
	/**版本*/
	private java.lang.Long version;
	/**objectType*/
	private java.lang.String objectType;
	/**用户名*/
	private java.lang.String userName;
	/**登录名*/
	private java.lang.String loginName;
	/**联系电话*/
	private java.lang.String userTel;
	/**手机联系方式*/
	private java.lang.String userMobileTel;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  照片路径
	 */
	@Column(name ="PIC_PATH",nullable=true,length=200)
	public java.lang.String getPicPath(){
		return this.picPath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  照片路径
	 */
	public void setPicPath(java.lang.String picPath){
		this.picPath = picPath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮件
	 */
	@Column(name ="USER_EMAIL",nullable=true,length=50)
	public java.lang.String getUserEmail(){
		return this.userEmail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮件
	 */
	public void setUserEmail(java.lang.String userEmail){
		this.userEmail = userEmail;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  生日
	 */
	@Column(name ="USER_BIRTHDAY",nullable=true)
	public java.util.Date getUserBirthday(){
		return this.userBirthday;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  生日
	 */
	public void setUserBirthday(java.util.Date userBirthday){
		this.userBirthday = userBirthday;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  上一次登陆时间
	 */
	@Column(name ="LAST_LOGIN_TIME",nullable=true)
	public java.util.Date getLastLoginTime(){
		return this.lastLoginTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  上一次登陆时间
	 */
	public void setLastLoginTime(java.util.Date lastLoginTime){
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户密码
	 */
	@Column(name ="PASSWORD",nullable=true,length=100)
	public java.lang.String getPassword(){
		return this.password;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户密码
	 */
	public void setPassword(java.lang.String password){
		this.password = password;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  1：正常；0：仅不能登录，不影响任何业务筛选
	 */
	@Column(name ="ENABLED",nullable=true,precision=20,scale=0)
	public java.lang.Long getEnabled(){
		return this.enabled;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  1：正常；0：仅不能登录，不影响任何业务筛选
	 */
	public void setEnabled(java.lang.Long enabled){
		this.enabled = enabled;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  credentialsNonExpired
	 */
	@Column(name ="CREDENTIALS_NON_EXPIRED",nullable=true,precision=20,scale=0)
	public java.lang.Long getCredentialsNonExpired(){
		return this.credentialsNonExpired;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  credentialsNonExpired
	 */
	public void setCredentialsNonExpired(java.lang.Long credentialsNonExpired){
		this.credentialsNonExpired = credentialsNonExpired;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  accountNonLocked
	 */
	@Column(name ="ACCOUNT_NON_LOCKED",nullable=true,precision=20,scale=0)
	public java.lang.Long getAccountNonLocked(){
		return this.accountNonLocked;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  accountNonLocked
	 */
	public void setAccountNonLocked(java.lang.Long accountNonLocked){
		this.accountNonLocked = accountNonLocked;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  accountNonExpired
	 */
	@Column(name ="ACCOUNT_NON_EXPIRED",nullable=true,precision=20,scale=0)
	public java.lang.Long getAccountNonExpired(){
		return this.accountNonExpired;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  accountNonExpired
	 */
	public void setAccountNonExpired(java.lang.Long accountNonExpired){
		this.accountNonExpired = accountNonExpired;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  clientId
	 */
	@Column(name ="CLIENT_ID",nullable=true,precision=20,scale=0)
	public java.lang.Long getClientId(){
		return this.clientId;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  clientId
	 */
	public void setClientId(java.lang.Long clientId){
		this.clientId = clientId;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  驾校id
	 */
	@Column(name ="DRIVINGSCHOOL_ID",nullable=true,precision=20,scale=0)
	public java.lang.Long getDrivingschoolId(){
		return this.drivingschoolId;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  驾校id
	 */
	public void setDrivingschoolId(java.lang.Long drivingschoolId){
		this.drivingschoolId = drivingschoolId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件类型
	 */
	@Column(name ="IDENTITY_TYPE",nullable=true,length=50)
	public java.lang.String getIdentityType(){
		return this.identityType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件类型
	 */
	public void setIdentityType(java.lang.String identityType){
		this.identityType = identityType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号
	 */
	@Column(name ="IDENTITY_NUM",nullable=true,length=50)
	public java.lang.String getIdentityNum(){
		return this.identityNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号
	 */
	public void setIdentityNum(java.lang.String identityNum){
		this.identityNum = identityNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=50)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名族
	 */
	@Column(name ="RACE",nullable=true,length=50)
	public java.lang.String getRace(){
		return this.race;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名族
	 */
	public void setRace(java.lang.String race){
		this.race = race;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾校数据
	 */
	@Column(name ="COACH_DATA",nullable=true,length=50)
	public java.lang.String getCoachData(){
		return this.coachData;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾校数据
	 */
	public void setCoachData(java.lang.String coachData){
		this.coachData = coachData;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  机构
	 */
	@Column(name ="ORGANIZATION_ID",nullable=true,precision=20,scale=0)
	public java.lang.Long getOrganizationId(){
		return this.organizationId;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  机构
	 */
	public void setOrganizationId(java.lang.Long organizationId){
		this.organizationId = organizationId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  指纹特征码1
	 */
	@Column(name ="FINGER_FEATURES_ONE",nullable=true,length=2000)
	public java.lang.String getFingerFeaturesOne(){
		return this.fingerFeaturesOne;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  指纹特征码1
	 */
	public void setFingerFeaturesOne(java.lang.String fingerFeaturesOne){
		this.fingerFeaturesOne = fingerFeaturesOne;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  指纹特征码2
	 */
	@Column(name ="FINGER_FEATURES_TWO",nullable=true,length=2000)
	public java.lang.String getFingerFeaturesTwo(){
		return this.fingerFeaturesTwo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  指纹特征码2
	 */
	public void setFingerFeaturesTwo(java.lang.String fingerFeaturesTwo){
		this.fingerFeaturesTwo = fingerFeaturesTwo;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  学员id，学员唯一标示
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID",nullable=false,precision=20,scale=0)
	public java.lang.Long getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  学员id，学员唯一标示
	 */
	public void setId(java.lang.Long id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  uuid
	 */
	@Column(name ="UUID",nullable=true,length=50)
	public java.lang.String getUuid(){
		return this.uuid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  uuid
	 */
	public void setUuid(java.lang.String uuid){
		this.uuid = uuid;
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
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  版本
	 */
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  objectType
	 */
	@Column(name ="OBJECT_TYPE",nullable=true,length=50)
	public java.lang.String getObjectType(){
		return this.objectType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  objectType
	 */
	public void setObjectType(java.lang.String objectType){
		this.objectType = objectType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户名
	 */
	@Column(name ="USER_NAME",nullable=true,length=200)
	public java.lang.String getUserName(){
		return this.userName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名
	 */
	public void setUserName(java.lang.String userName){
		this.userName = userName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  登录名
	 */
	@Column(name ="LOGIN_NAME",nullable=true,length=100)
	public java.lang.String getLoginName(){
		return this.loginName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  登录名
	 */
	public void setLoginName(java.lang.String loginName){
		this.loginName = loginName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="USER_TEL",nullable=true,length=50)
	public java.lang.String getUserTel(){
		return this.userTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setUserTel(java.lang.String userTel){
		this.userTel = userTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机联系方式
	 */
	@Column(name ="USER_MOBILE_TEL",nullable=true,length=50)
	public java.lang.String getUserMobileTel(){
		return this.userMobileTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机联系方式
	 */
	public void setUserMobileTel(java.lang.String userMobileTel){
		this.userMobileTel = userMobileTel;
	}
}
