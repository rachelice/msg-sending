/*
* ClassName 部门管理Main布局
*/

Ext.define("Fes.view.DeptLayout",{
		extend:'Ext.panel.Panel',
		alias:'widget.mainlayout',
		defaults:{
			  split:true,//面板右边框中间出现一个小箭头，可以收起面板
				bodyStyle:'padding:1px'
		},
		layout:'border',
		items:[{
			title:'部门树形',
			region:'west',
			iconCls:'dept_table',
			xtype:'panel',
			margins:'5 2 5 5',
			width:200,
			collapsible:true,//面板是可以被折叠的
			id:'west-tree',
			layout:'fit',//充满整个面板
			items:[{
				xtype:'deptTree', 
				id:'DeptLayoutDeptTree',
				listeners:{
					itemclick:function( view, record,  item,  index,  e,  eOpts ){
					//	Ext.getCmp('dept-grid').getStore().setBaseParam({'id':'1'});
						 
						//Ext.JSON.encode(Ext.getCmp('dept-grid').getStore().getBaseParam());
						Ext.getCmp('dept-grid').getStore().load(
								{
									
									params : {
										 id:record.data.id,
										 deptName:record.data.text
									}
								 
								}
						);
					}
				},
				id:'dept-tree'
			}]
		},{
			title:'部门数据表格',
			iconCls:'dept_table',
			region:'center',
			xtype:'panel',
			id:'center-grid',
			margins:'5 5 5 0',
			layout:'fit',//充满整个面板
			border:0,
			items:[{
					id:'dept-grid',
					xtype:'deptList',
						listeners:{
							beforeload:function(store, operation, eOpts ){
								
							}
						}
						
						
			}]
		}]
});


console.log('mmmeptList...');