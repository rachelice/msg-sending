 
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
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'msgNum',name: 'msgNum'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'msgContent',name: 'msgContent'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'msgType',name: 'msgType'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'status',name: 'status'},
	      	 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'sendingTime',name: 'sendingTime'}, 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'priority',name: 'priority'},
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'createTime',name: 'createTime'}, 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'submitTime',name: 'submitTime'}, 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'submitterCode',name: 'submitterCode'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'groupSending',name: 'groupSending'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'businessCode',name: 'businessCode'},
	      	 
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 