 
Ext.define('Fes.view.MspMsgTaskForm', {
	extend: 'Ext.form.Panel',
	xtype: 'mspmsgtaskform',
	alias: 'widget.mspmsgtaskform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'mspmsgtaskform-id',
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
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '短信任务编号',name: 'msgNum'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '短信内容',name: 'msgContent'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '短信类型',name: 'msgType'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '短信状态',name: 'status'},
	      	 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: '发送时间',name: 'sendingTime'}, 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '优先级',name: 'priority'},
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: '创建时间',name: 'createTime'}, 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: '提交时间',name: 'submitTime'}, 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '提交者代码',name: 'submitterCode'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '是否群发',name: 'groupSending'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '业务系统代码',name: 'businessCode'},
	      	 
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 