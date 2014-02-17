Ext.define("Fes.model.TfunctionModel",{
	extend:'Ext.data.Model',
	fields:[

			{name:'id',type:'int'}	,	//图标ID
			{name:'iconid',type:'string'}	,	//图标ID
			
			{name:'parentfunctionid',type:'string'}	,	//父权限ID
			
			{name:'functionname',type:'string'}	,	//菜单名称
			
			{name:'functionlevel',type:'string'}	,	//菜单等级
			
			{name:'functionurl',type:'string'}	,	//菜单地址
			
			{name:'iconpath',type:'string'}	,	//图标路径
			
			{name:'functionorder',type:'string'}	,	//functionorder
			
			{name:'functioniframe',type:'string'}	,	//functioniframe
		{}
	],
    proxy:{
   
        type : 'rest',
        url:'tfunctions',
        reader:{
            type : 'json',
            root : 'root',
            totalProperty : 'total'// 数据的总数
        },
        writer:{
            type:'json'
        }
    }
});