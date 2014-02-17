/*
* ClassName 部门管理Main布局
*/

Ext.define("Fes.view.ParameterLayout",{
		extend:'Ext.panel.Panel',
		alias:'widget.parameterLayout',
		  requires : ["Fes.view.ParameterTree",'Fes.view.SysParameterList'],  
		defaults:{
			  split:true,//面板右边框中间出现一个小箭头，可以收起面板
				bodyStyle:'padding:1px'
		}, 
		layout:'border',
		items:[{
			 
			region:'west',
			iconCls:'parameter_table',
			xtype:'panel',
			margins:'5 2 5 5',
			width:200,
			collapsible:true,//面板是可以被折叠的
			id:'west-parameter-tree',
			layout:'fit',//充满整个面板
			items:[{
				xtype:'parameterTree', 
				rootId : 1,  
				rootText : '参数',
				expanded : false,
				listeners:{
					itemclick:function( view, record,  item,  index,  e,  eOpts ){
					 	 
						   
						if(record.data.leaf) return ;
						Ext.getCmp('parameter-grid').setTitle('['+record.data.text+']的所属参数列表');
						Ext.getCmp('parameter-grid').getStore().load( 
								{
									
									params : {
										 id:record.data.id ,
										 start:0
									}
								 
								}
						);
					}
				},
				id:'parameter-tree'
			}]
		},{
			id:'parameter-grid',
			xtype:'sysParameterList',
			iconCls:'parameter_table',
			region:'center',
		 
			 
			margins:'5 5 5 0',
			layout:'fit',//充满整个面板
			border:0,
			 
			layout:'fit',//充满整个面板
				listeners:{
					beforeload:function(store, operation, eOpts ){
						
					}
				}
				
				
	}]
});

