 
Ext.define('Fes.view.MspEnterpriseForm', {
	extend: 'Ext.form.Panel',
	xtype: 'mspenterpriseform',
	alias: 'widget.mspenterpriseform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'mspenterpriseform-id',
    fieldDefaults: {
        labelAlign: 'right',
        anchor: '99%',
        labelWidth: 110
    },
    defaults:{layout:'anchor',
    		  defaults:{anchor:'100%'}
    },
    layout: 'column',
    items: [
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'uuid',name: 'uuid'},
	      	 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'updateTime',name: 'updateTime'}, 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'createTime',name: 'createTime'}, 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'version',name: 'version'},
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'objectType',name: 'objectType'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'enterpriseName',name: 'enterpriseName'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'regionCode',name: 'regionCode'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'licenseCode',name: 'licenseCode'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'companyType',name: 'companyType'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'orgnizationCode',name: 'orgnizationCode'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'legalRepresentativeName',name: 'legalRepresentativeName'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'businessHeadName',name: 'businessHeadName'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'transactorName',name: 'transactorName'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'legalIdentity',name: 'legalIdentity'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'chinaOperators',name: 'chinaOperators'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'chinaRegisterSum',name: 'chinaRegisterSum'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'foreignOperators',name: 'foreignOperators'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'foreignRegisterSum',name: 'foreignRegisterSum'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'openAccountBank',name: 'openAccountBank'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'bankAccount',name: 'bankAccount'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'orgCode',name: 'orgCode'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'addressId',name: 'addressId'},
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'telephone',name: 'telephone'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'fax',name: 'fax'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'mobilePhone',name: 'mobilePhone'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'postcode',name: 'postcode'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'email',name: 'email'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'enterpriseNetAddress',name: 'enterpriseNetAddress'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'superiorLicense',name: 'superiorLicense'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'employeesNum',name: 'employeesNum'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'managersNum',name: 'managersNum'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'practionersNum',name: 'practionersNum'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'anyOthersNum',name: 'anyOthersNum'},
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'flagOfLicense',name: 'flagOfLicense'},
	      	 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'periodOfValidityStart',name: 'periodOfValidityStart'}, 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'periodOfValidityEnd',name: 'periodOfValidityEnd'}, 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'issueDate',name: 'issueDate'}, 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'operateDate',name: 'operateDate'}, 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'operator',name: 'operator'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'oldEnterprisebaseinfoid',name: 'oldEnterprisebaseinfoid'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'userId',name: 'userId'},
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '驾校数据',name: 'enterpriseCategory'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '是否锁定',name: 'islock'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'isSignLock',name: 'isSignLock'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'miaxisNum',name: 'miaxisNum'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '安运单位编号',name: 'safeluckNum'},
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '维尔单位编号',name: 'wellcomNum'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '允许指纹修改设置',name: 'fingerModifyFit'},
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '指纹修改设置标记',name: 'fingerModifyFlag'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '有为企业id，有为企业的唯一标示，制卡时可能会用到',name: 'yuweiCorpId'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '驾校简称',name: 'enterpriseShortenName'},
	      	 
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 