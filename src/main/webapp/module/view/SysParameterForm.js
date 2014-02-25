 
Ext.define('Fes.view.SysParameterForm', {
	extend: 'Ext.form.Panel',
	xtype: 'sysparameterform',
	alias: 'widget.sysparameterform',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: 'sysparameterform-id',
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
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '参数名称',name: 'parName'},
	      	 
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '参数代码',name: 'parCode'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '上级参数',name: 'parUpId'},
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '图标路径',name: 'icoUrl'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '是否有子类',name: 'isDir'},
//varchar2
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '参数类型',name: 'parType'},
	      	 
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '层级',name: 'parLev'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '是否默认展开',name: 'isExp'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '排序序号',name: 'sortIndex'},
//number
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '默认选中',name: 'isDef'},
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 