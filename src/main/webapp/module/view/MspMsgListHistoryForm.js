 
Ext.define('Fes.view.MspMsgListHistoryForm', {
	extend: 'Ext.form.Panel',
	xtype: 'mspmsglisthistoryform',
	alias: 'widget.mspmsglisthistoryform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'mspmsglisthistoryform-id',
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
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'messagenum',name: 'messagenum'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'content',name: 'content'},
	      	 
//clob
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'mobilenumber',name: 'mobilenumber'},
	      	 
//nvarchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'status',name: 'status'},
	      	 
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'sendingtime',name: 'sendingtime'}, 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'priority',name: 'priority'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'count',name: 'count'},
//date
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: 'createtime',name: 'createtime'}, 
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 