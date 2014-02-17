 
Ext.define('Fes.view.SysCustomSqlForm', {
	extend: 'Ext.form.Panel',
	xtype: 'syscustomsqlform',
	alias: 'widget.syscustomsqlform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'syscustomsqlform-id',
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
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'sql',name: 'sql'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'note',name: 'note'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'count',name: 'count'},
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'title',name: 'title'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'state',name: 'state'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'parentParamId',name: 'parentParamId'},
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'syb1',name: 'syb1'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'syb2',name: 'syb2'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'syb3',name: 'syb3'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'syb4',name: 'syb4'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'syb5',name: 'syb5'},
	      	 
//timestamp(6)
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: 'createDate',name: 'createDate'},
	      	 
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 