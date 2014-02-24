Ext.define("Fes.model.MspEnterpriseModel",{
	extend:'Ext.data.Model',
	fields:[
				{name:'uuid',type:'string'}	,	//uuid
			
			
				{name:'updateTime',type:'auto'}	,	//updateTime
			
				{name:'createTime',type:'auto'}	,	//createTime
			
				{name:'version',type:'string'}	,	//version
			
			
				{name:'objectType',type:'string'}	,	//objectType
			
			
				{name:'enterpriseName',type:'string'}	,	//enterpriseName
			
			
				{name:'regionCode',type:'string'}	,	//regionCode
			
			
				{name:'licenseCode',type:'string'}	,	//licenseCode
			
			
				{name:'companyType',type:'string'}	,	//companyType
			
			
				{name:'orgnizationCode',type:'string'}	,	//orgnizationCode
			
			
				{name:'legalRepresentativeName',type:'string'}	,	//legalRepresentativeName
			
			
				{name:'businessHeadName',type:'string'}	,	//businessHeadName
			
			
				{name:'transactorName',type:'string'}	,	//transactorName
			
			
				{name:'legalIdentity',type:'string'}	,	//legalIdentity
			
			
				{name:'chinaOperators',type:'string'}	,	//chinaOperators
			
			
				{name:'chinaRegisterSum',type:'string'}	,	//chinaRegisterSum
			
			
				{name:'foreignOperators',type:'string'}	,	//foreignOperators
			
			
				{name:'foreignRegisterSum',type:'string'}	,	//foreignRegisterSum
			
			
				{name:'openAccountBank',type:'string'}	,	//openAccountBank
			
			
				{name:'bankAccount',type:'string'}	,	//bankAccount
			
			
				{name:'orgCode',type:'string'}	,	//orgCode
			
			
				{name:'addressId',type:'string'}	,	//addressId
			
			
				{name:'telephone',type:'string'}	,	//telephone
			
			
				{name:'fax',type:'string'}	,	//fax
			
			
				{name:'mobilePhone',type:'string'}	,	//mobilePhone
			
			
				{name:'postcode',type:'string'}	,	//postcode
			
			
				{name:'email',type:'string'}	,	//email
			
			
				{name:'enterpriseNetAddress',type:'string'}	,	//enterpriseNetAddress
			
			
				{name:'superiorLicense',type:'string'}	,	//superiorLicense
			
			
				{name:'employeesNum',type:'string'}	,	//employeesNum
			
			
				{name:'managersNum',type:'string'}	,	//managersNum
			
			
				{name:'practionersNum',type:'string'}	,	//practionersNum
			
			
				{name:'anyOthersNum',type:'string'}	,	//anyOthersNum
			
			
				{name:'flagOfLicense',type:'string'}	,	//flagOfLicense
			
			
				{name:'periodOfValidityStart',type:'auto'}	,	//periodOfValidityStart
			
				{name:'periodOfValidityEnd',type:'auto'}	,	//periodOfValidityEnd
			
				{name:'issueDate',type:'auto'}	,	//issueDate
			
				{name:'operateDate',type:'auto'}	,	//operateDate
			
				{name:'operator',type:'string'}	,	//operator
			
			
				{name:'oldEnterprisebaseinfoid',type:'string'}	,	//oldEnterprisebaseinfoid
			
			
				{name:'userId',type:'string'}	,	//userId
			
			
				{name:'enterpriseCategory',type:'string'}	,	//驾校数据
			
			
				{name:'islock',type:'string'}	,	//是否锁定
			
			
				{name:'isSignLock',type:'string'}	,	//isSignLock
			
			
				{name:'miaxisNum',type:'string'}	,	//miaxisNum
			
			
				{name:'safeluckNum',type:'string'}	,	//安运单位编号
			
			
				{name:'wellcomNum',type:'string'}	,	//维尔单位编号
			
			
				{name:'fingerModifyFit',type:'string'}	,	//允许指纹修改设置
			
			
				{name:'fingerModifyFlag',type:'string'}	,	//指纹修改设置标记
			
			
				{name:'yuweiCorpId',type:'string'}	,	//有为企业id，有为企业的唯一标示，制卡时可能会用到
			
			
				{name:'enterpriseShortenName',type:'string'}	,	//驾校简称
			
			
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
    	 
        type : 'rest',
        url:'mspEnterprise',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'mspEnterprise/create',
        	read:'mspEnterprise/list',
        	update:'mspEnterprise/update',
        	destroy:'mspEnterprise/delete' 
        	 
        },
        reader:{
            type : 'json',
            root : 'root',
            totalProperty : 'total'// 数据的总数
        },
        writer:{
            type:'json'
            
        }
    }
 
});