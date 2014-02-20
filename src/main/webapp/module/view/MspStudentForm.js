 
Ext.define('Fes.view.MspStudentForm', {
	extend: 'Ext.form.Panel',
	xtype: 'mspstudentform',
	alias: 'widget.mspstudentform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'mspstudentform-id',
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
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '驾校许可证号',name: 'licenseCode'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '驾校名称',name: 'enterpriseName'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '班期名称',name: 'semesterName'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '电话',name: 'userTel'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '驾校id',name: 'enterpriseId'},
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '学员姓名',name: 'learnerName'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '身份证号',name: 'identityNumber'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '性别',name: 'gender'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '班期id',name: 'semesterId'},
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '手机号码',name: 'mobileNumber'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '科目一已完成学时',name: 'subjectOneThFinishtime'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '科目二理论已完成学时',name: 'subjectTwoThFinishtime'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '科目二实操已完成学时',name: 'subjectTwoOpFinishtime'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '科目三理论已完成学时',name: 'subjectThreeThFinishtime'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '科目三实操已完成学时',name: 'subjectThreeOpFinishtime'},
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: '更新时间',name: 'updateTime'}, 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: '创建时间',name: 'createTime'}, 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '备注',name: 'remark'},
	      	 
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 