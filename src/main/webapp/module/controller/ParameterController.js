/*
* ClassName 部门管理控制器
*/


Ext.define("Fes.controller.ParameterController",{
		extend:	'Ext.app.Controller',
		GridDoActionUtil:Ext.create("Fes.util.GridDoActionUtil"),
		init:function(){
			 return; 
		},
		views:[
		   
			'ParameterLayout',
			'ParameterTree'
		],
		stores:[
				'SysParameterStore' ,'ParameterStore4Tree'
		],
		models:[
				'SysParameterModel'
		]
});