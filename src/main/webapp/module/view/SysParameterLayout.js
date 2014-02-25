/*
* ClassName 部门管理Main布局
*/

Ext.define("Fes.view.SysParameterLayout",{
		extend:'Ext.panel.Panel',
		alias:'widget.sysParameterLayout',
		defaults:{
			  split:true,//面板右边框中间出现一个小箭头，可以收起面板
				bodyStyle:'padding:1px'
		},
		layout:'border',
		items:[{
			title:'参数树形',
			region:'west',
			 
			xtype:'panel',
			margins:'5 2 5 5',
			width:200,
			collapsible:true,//面板是可以被折叠的
			id:'P_west-tree',
			layout:'fit',//充满整个面板
			items:[ {
				xtype:'parameterComboTree',
				//fieldLabel: '权限',
				//labelWidth: 40,   
				rootText : '功能',
				rootId:'0',
				expanded:true,
				storeUrl : 'sysParameter/getTreeNodeChildren',
				id:'tree_SysParameterComboTree',
				selectMode:'all',
				treeHeight:300,
				rootVisible:true
			}]
		},{
			title:'参数数据表格',
			 
			region:'center',
			xtype:'panel',
			 
			margins:'5 5 5 0',
			layout:'fit',//充满整个面板
			border:0,
			items:[{
					id:'parameter-grid',
					xtype:'sysParameterlist' 
						
						
			}]
		}]
});

 