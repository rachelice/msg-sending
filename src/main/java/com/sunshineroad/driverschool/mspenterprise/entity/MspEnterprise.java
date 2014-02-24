package com.sunshineroad.driverschool.mspenterprise.entity;
 

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
 * @Description: 企业表
 * @author  
 * @date 2014-02-24 12:45:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "msp_enterprise", schema = "")
public class MspEnterprise extends BaseEntity {
	/**id*/
	private java.lang.Long id;
	/**uuid*/
	private java.lang.String uuid;
	/**updateTime*/
	private java.util.Date updateTime;
	/**createTime*/
	private java.util.Date createTime;
	/**version*/
	private java.lang.Long version;
	/**objectType*/
	private java.lang.String objectType;
	/**enterpriseName*/
	private java.lang.String enterpriseName;
	/**regionCode*/
	private java.lang.String regionCode;
	/**licenseCode*/
	private java.lang.String licenseCode;
	/**companyType*/
	private java.lang.String companyType;
	/**orgnizationCode*/
	private java.lang.String orgnizationCode;
	/**legalRepresentativeName*/
	private java.lang.String legalRepresentativeName;
	/**businessHeadName*/
	private java.lang.String businessHeadName;
	/**transactorName*/
	private java.lang.String transactorName;
	/**legalIdentity*/
	private java.lang.String legalIdentity;
	/**chinaOperators*/
	private java.lang.String chinaOperators;
	/**chinaRegisterSum*/
	private java.lang.String chinaRegisterSum;
	/**foreignOperators*/
	private java.lang.String foreignOperators;
	/**foreignRegisterSum*/
	private java.lang.String foreignRegisterSum;
	/**openAccountBank*/
	private java.lang.String openAccountBank;
	/**bankAccount*/
	private java.lang.String bankAccount;
	/**orgCode*/
	private java.lang.String orgCode;
	/**addressId*/
	private java.lang.Long addressId;
	/**telephone*/
	private java.lang.String telephone;
	/**fax*/
	private java.lang.String fax;
	/**mobilePhone*/
	private java.lang.String mobilePhone;
	/**postcode*/
	private java.lang.String postcode;
	/**email*/
	private java.lang.String email;
	/**enterpriseNetAddress*/
	private java.lang.String enterpriseNetAddress;
	/**superiorLicense*/
	private java.lang.String superiorLicense;
	/**employeesNum*/
	private java.lang.Long employeesNum;
	/**managersNum*/
	private java.lang.Long managersNum;
	/**practionersNum*/
	private java.lang.Long practionersNum;
	/**anyOthersNum*/
	private java.lang.Long anyOthersNum;
	/**flagOfLicense*/
	private java.lang.String flagOfLicense;
	/**periodOfValidityStart*/
	private java.util.Date periodOfValidityStart;
	/**periodOfValidityEnd*/
	private java.util.Date periodOfValidityEnd;
	/**issueDate*/
	private java.util.Date issueDate;
	/**operateDate*/
	private java.util.Date operateDate;
	/**operator*/
	private java.lang.String operator;
	/**oldEnterprisebaseinfoid*/
	private java.lang.Long oldEnterprisebaseinfoid;
	/**userId*/
	private java.lang.Long userId;
	/**驾校数据*/
	private java.lang.String enterpriseCategory;
	/**是否锁定*/
	private java.lang.Long islock;
	/**isSignLock*/
	private java.lang.Long isSignLock;
	/**miaxisNum*/
	private java.lang.Long miaxisNum;
	/**安运单位编号*/
	private java.lang.Long safeluckNum;
	/**维尔单位编号*/
	private java.lang.String wellcomNum;
	/**允许指纹修改设置*/
	private java.lang.Long fingerModifyFit;
	/**指纹修改设置标记*/
	private java.lang.String fingerModifyFlag;
	/**有为企业id，有为企业的唯一标示，制卡时可能会用到*/
	private java.lang.String yuweiCorpId;
	/**驾校简称*/
	private java.lang.String enterpriseShortenName;
	
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  id
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
	@SequenceGenerator(name="sequence",sequenceName="msp_enterprise_seq",allocationSize=1)
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
	 *@return: java.util.Date  updateTime
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updateTime
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createTime
	 */
	@Column(name ="CREATE_TIME",nullable=true)
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
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  version
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
	 *@return: java.lang.String  enterpriseName
	 */
	@Column(name ="ENTERPRISE_NAME",nullable=true,length=100)
	public java.lang.String getEnterpriseName(){
		return this.enterpriseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  enterpriseName
	 */
	public void setEnterpriseName(java.lang.String enterpriseName){
		this.enterpriseName = enterpriseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  regionCode
	 */
	@Column(name ="REGION_CODE",nullable=true,length=50)
	public java.lang.String getRegionCode(){
		return this.regionCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  regionCode
	 */
	public void setRegionCode(java.lang.String regionCode){
		this.regionCode = regionCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  licenseCode
	 */
	@Column(name ="LICENSE_CODE",nullable=true,length=50)
	public java.lang.String getLicenseCode(){
		return this.licenseCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  licenseCode
	 */
	public void setLicenseCode(java.lang.String licenseCode){
		this.licenseCode = licenseCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  companyType
	 */
	@Column(name ="COMPANY_TYPE",nullable=true,length=50)
	public java.lang.String getCompanyType(){
		return this.companyType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  companyType
	 */
	public void setCompanyType(java.lang.String companyType){
		this.companyType = companyType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  orgnizationCode
	 */
	@Column(name ="ORGNIZATION_CODE",nullable=true,length=50)
	public java.lang.String getOrgnizationCode(){
		return this.orgnizationCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  orgnizationCode
	 */
	public void setOrgnizationCode(java.lang.String orgnizationCode){
		this.orgnizationCode = orgnizationCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  legalRepresentativeName
	 */
	@Column(name ="LEGAL_REPRESENTATIVE_NAME",nullable=true,length=50)
	public java.lang.String getLegalRepresentativeName(){
		return this.legalRepresentativeName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  legalRepresentativeName
	 */
	public void setLegalRepresentativeName(java.lang.String legalRepresentativeName){
		this.legalRepresentativeName = legalRepresentativeName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  businessHeadName
	 */
	@Column(name ="BUSINESS_HEAD_NAME",nullable=true,length=50)
	public java.lang.String getBusinessHeadName(){
		return this.businessHeadName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  businessHeadName
	 */
	public void setBusinessHeadName(java.lang.String businessHeadName){
		this.businessHeadName = businessHeadName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  transactorName
	 */
	@Column(name ="TRANSACTOR_NAME",nullable=true,length=50)
	public java.lang.String getTransactorName(){
		return this.transactorName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  transactorName
	 */
	public void setTransactorName(java.lang.String transactorName){
		this.transactorName = transactorName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  legalIdentity
	 */
	@Column(name ="LEGAL_IDENTITY",nullable=true,length=50)
	public java.lang.String getLegalIdentity(){
		return this.legalIdentity;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  legalIdentity
	 */
	public void setLegalIdentity(java.lang.String legalIdentity){
		this.legalIdentity = legalIdentity;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chinaOperators
	 */
	@Column(name ="CHINA_OPERATORS",nullable=true,length=50)
	public java.lang.String getChinaOperators(){
		return this.chinaOperators;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chinaOperators
	 */
	public void setChinaOperators(java.lang.String chinaOperators){
		this.chinaOperators = chinaOperators;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  chinaRegisterSum
	 */
	@Column(name ="CHINA_REGISTER_SUM",nullable=true,length=50)
	public java.lang.String getChinaRegisterSum(){
		return this.chinaRegisterSum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  chinaRegisterSum
	 */
	public void setChinaRegisterSum(java.lang.String chinaRegisterSum){
		this.chinaRegisterSum = chinaRegisterSum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  foreignOperators
	 */
	@Column(name ="FOREIGN_OPERATORS",nullable=true,length=50)
	public java.lang.String getForeignOperators(){
		return this.foreignOperators;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  foreignOperators
	 */
	public void setForeignOperators(java.lang.String foreignOperators){
		this.foreignOperators = foreignOperators;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  foreignRegisterSum
	 */
	@Column(name ="FOREIGN_REGISTER_SUM",nullable=true,length=50)
	public java.lang.String getForeignRegisterSum(){
		return this.foreignRegisterSum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  foreignRegisterSum
	 */
	public void setForeignRegisterSum(java.lang.String foreignRegisterSum){
		this.foreignRegisterSum = foreignRegisterSum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  openAccountBank
	 */
	@Column(name ="OPEN_ACCOUNT_BANK",nullable=true,length=50)
	public java.lang.String getOpenAccountBank(){
		return this.openAccountBank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  openAccountBank
	 */
	public void setOpenAccountBank(java.lang.String openAccountBank){
		this.openAccountBank = openAccountBank;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  bankAccount
	 */
	@Column(name ="BANK_ACCOUNT",nullable=true,length=50)
	public java.lang.String getBankAccount(){
		return this.bankAccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  bankAccount
	 */
	public void setBankAccount(java.lang.String bankAccount){
		this.bankAccount = bankAccount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  orgCode
	 */
	@Column(name ="ORG_CODE",nullable=true,length=50)
	public java.lang.String getOrgCode(){
		return this.orgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  orgCode
	 */
	public void setOrgCode(java.lang.String orgCode){
		this.orgCode = orgCode;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  addressId
	 */
	@Column(name ="ADDRESS_ID",nullable=true,precision=20,scale=0)
	public java.lang.Long getAddressId(){
		return this.addressId;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  addressId
	 */
	public void setAddressId(java.lang.Long addressId){
		this.addressId = addressId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  telephone
	 */
	@Column(name ="TELEPHONE",nullable=true,length=50)
	public java.lang.String getTelephone(){
		return this.telephone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  telephone
	 */
	public void setTelephone(java.lang.String telephone){
		this.telephone = telephone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fax
	 */
	@Column(name ="FAX",nullable=true,length=50)
	public java.lang.String getFax(){
		return this.fax;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fax
	 */
	public void setFax(java.lang.String fax){
		this.fax = fax;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  mobilePhone
	 */
	@Column(name ="MOBILE_PHONE",nullable=true,length=50)
	public java.lang.String getMobilePhone(){
		return this.mobilePhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  mobilePhone
	 */
	public void setMobilePhone(java.lang.String mobilePhone){
		this.mobilePhone = mobilePhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  postcode
	 */
	@Column(name ="POSTCODE",nullable=true,length=50)
	public java.lang.String getPostcode(){
		return this.postcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  postcode
	 */
	public void setPostcode(java.lang.String postcode){
		this.postcode = postcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  email
	 */
	@Column(name ="EMAIL",nullable=true,length=50)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  email
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  enterpriseNetAddress
	 */
	@Column(name ="ENTERPRISE_NET_ADDRESS",nullable=true,length=50)
	public java.lang.String getEnterpriseNetAddress(){
		return this.enterpriseNetAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  enterpriseNetAddress
	 */
	public void setEnterpriseNetAddress(java.lang.String enterpriseNetAddress){
		this.enterpriseNetAddress = enterpriseNetAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  superiorLicense
	 */
	@Column(name ="SUPERIOR_LICENSE",nullable=true,length=50)
	public java.lang.String getSuperiorLicense(){
		return this.superiorLicense;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  superiorLicense
	 */
	public void setSuperiorLicense(java.lang.String superiorLicense){
		this.superiorLicense = superiorLicense;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  employeesNum
	 */
	@Column(name ="EMPLOYEES_NUM",nullable=true,precision=20,scale=0)
	public java.lang.Long getEmployeesNum(){
		return this.employeesNum;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  employeesNum
	 */
	public void setEmployeesNum(java.lang.Long employeesNum){
		this.employeesNum = employeesNum;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  managersNum
	 */
	@Column(name ="MANAGERS_NUM",nullable=true,precision=20,scale=0)
	public java.lang.Long getManagersNum(){
		return this.managersNum;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  managersNum
	 */
	public void setManagersNum(java.lang.Long managersNum){
		this.managersNum = managersNum;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  practionersNum
	 */
	@Column(name ="PRACTIONERS_NUM",nullable=true,precision=20,scale=0)
	public java.lang.Long getPractionersNum(){
		return this.practionersNum;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  practionersNum
	 */
	public void setPractionersNum(java.lang.Long practionersNum){
		this.practionersNum = practionersNum;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  anyOthersNum
	 */
	@Column(name ="ANY_OTHERS_NUM",nullable=true,precision=20,scale=0)
	public java.lang.Long getAnyOthersNum(){
		return this.anyOthersNum;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  anyOthersNum
	 */
	public void setAnyOthersNum(java.lang.Long anyOthersNum){
		this.anyOthersNum = anyOthersNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  flagOfLicense
	 */
	@Column(name ="FLAG_OF_LICENSE",nullable=true,length=50)
	public java.lang.String getFlagOfLicense(){
		return this.flagOfLicense;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  flagOfLicense
	 */
	public void setFlagOfLicense(java.lang.String flagOfLicense){
		this.flagOfLicense = flagOfLicense;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  periodOfValidityStart
	 */
	@Column(name ="PERIOD_OF_VALIDITY_START",nullable=true)
	public java.util.Date getPeriodOfValidityStart(){
		return this.periodOfValidityStart;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  periodOfValidityStart
	 */
	public void setPeriodOfValidityStart(java.util.Date periodOfValidityStart){
		this.periodOfValidityStart = periodOfValidityStart;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  periodOfValidityEnd
	 */
	@Column(name ="PERIOD_OF_VALIDITY_END",nullable=true)
	public java.util.Date getPeriodOfValidityEnd(){
		return this.periodOfValidityEnd;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  periodOfValidityEnd
	 */
	public void setPeriodOfValidityEnd(java.util.Date periodOfValidityEnd){
		this.periodOfValidityEnd = periodOfValidityEnd;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  issueDate
	 */
	@Column(name ="ISSUE_DATE",nullable=true)
	public java.util.Date getIssueDate(){
		return this.issueDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  issueDate
	 */
	public void setIssueDate(java.util.Date issueDate){
		this.issueDate = issueDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  operateDate
	 */
	@Column(name ="OPERATE_DATE",nullable=true)
	public java.util.Date getOperateDate(){
		return this.operateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  operateDate
	 */
	public void setOperateDate(java.util.Date operateDate){
		this.operateDate = operateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  operator
	 */
	@Column(name ="OPERATOR",nullable=true,length=50)
	public java.lang.String getOperator(){
		return this.operator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  operator
	 */
	public void setOperator(java.lang.String operator){
		this.operator = operator;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  oldEnterprisebaseinfoid
	 */
	@Column(name ="OLD_ENTERPRISEBASEINFOID",nullable=true,precision=20,scale=0)
	public java.lang.Long getOldEnterprisebaseinfoid(){
		return this.oldEnterprisebaseinfoid;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  oldEnterprisebaseinfoid
	 */
	public void setOldEnterprisebaseinfoid(java.lang.Long oldEnterprisebaseinfoid){
		this.oldEnterprisebaseinfoid = oldEnterprisebaseinfoid;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  userId
	 */
	@Column(name ="USER_ID",nullable=true,precision=20,scale=0)
	public java.lang.Long getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  userId
	 */
	public void setUserId(java.lang.Long userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾校数据
	 */
	@Column(name ="ENTERPRISE_CATEGORY",nullable=true,length=50)
	public java.lang.String getEnterpriseCategory(){
		return this.enterpriseCategory;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾校数据
	 */
	public void setEnterpriseCategory(java.lang.String enterpriseCategory){
		this.enterpriseCategory = enterpriseCategory;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  是否锁定
	 */
	@Column(name ="ISLOCK",nullable=false,precision=20,scale=0)
	public java.lang.Long getIslock(){
		return this.islock;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  是否锁定
	 */
	public void setIslock(java.lang.Long islock){
		this.islock = islock;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  isSignLock
	 */
	@Column(name ="IS_SIGN_LOCK",nullable=true,precision=20,scale=0)
	public java.lang.Long getIsSignLock(){
		return this.isSignLock;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  isSignLock
	 */
	public void setIsSignLock(java.lang.Long isSignLock){
		this.isSignLock = isSignLock;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  miaxisNum
	 */
	@Column(name ="MIAXIS_NUM",nullable=true,precision=20,scale=0)
	public java.lang.Long getMiaxisNum(){
		return this.miaxisNum;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  miaxisNum
	 */
	public void setMiaxisNum(java.lang.Long miaxisNum){
		this.miaxisNum = miaxisNum;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  安运单位编号
	 */
	@Column(name ="SAFELUCK_NUM",nullable=true,precision=20,scale=0)
	public java.lang.Long getSafeluckNum(){
		return this.safeluckNum;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  安运单位编号
	 */
	public void setSafeluckNum(java.lang.Long safeluckNum){
		this.safeluckNum = safeluckNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维尔单位编号
	 */
	@Column(name ="WELLCOM_NUM",nullable=true,length=50)
	public java.lang.String getWellcomNum(){
		return this.wellcomNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维尔单位编号
	 */
	public void setWellcomNum(java.lang.String wellcomNum){
		this.wellcomNum = wellcomNum;
	}
	/**
	 *方法: 取得java.lang.Long
	 *@return: java.lang.Long  允许指纹修改设置
	 */
	@Column(name ="FINGER_MODIFY_FIT",nullable=false,precision=20,scale=0)
	public java.lang.Long getFingerModifyFit(){
		return this.fingerModifyFit;
	}

	/**
	 *方法: 设置java.lang.Long
	 *@param: java.lang.Long  允许指纹修改设置
	 */
	public void setFingerModifyFit(java.lang.Long fingerModifyFit){
		this.fingerModifyFit = fingerModifyFit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  指纹修改设置标记
	 */
	@Column(name ="FINGER_MODIFY_FLAG",nullable=true,length=50)
	public java.lang.String getFingerModifyFlag(){
		return this.fingerModifyFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  指纹修改设置标记
	 */
	public void setFingerModifyFlag(java.lang.String fingerModifyFlag){
		this.fingerModifyFlag = fingerModifyFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  有为企业id，有为企业的唯一标示，制卡时可能会用到
	 */
	@Column(name ="YUWEI_CORP_ID",nullable=true,length=20)
	public java.lang.String getYuweiCorpId(){
		return this.yuweiCorpId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  有为企业id，有为企业的唯一标示，制卡时可能会用到
	 */
	public void setYuweiCorpId(java.lang.String yuweiCorpId){
		this.yuweiCorpId = yuweiCorpId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  驾校简称
	 */
	@Column(name ="ENTERPRISE_SHORTEN_NAME",nullable=true,length=100)
	public java.lang.String getEnterpriseShortenName(){
		return this.enterpriseShortenName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驾校简称
	 */
	public void setEnterpriseShortenName(java.lang.String enterpriseShortenName){
		this.enterpriseShortenName = enterpriseShortenName;
	}
}
