Ext.define("Fes.model.SysParameterModel",{
	extend:'Ext.data.Model',
	fields:[
			
			{name:'parName',type:'string'}	,	//参数名称
			
			{name:'parCode',type:'string'}	,	//参数代码
			
			{name:'parUpId',type:'string'}	,	//上级参数
			
			{name:'parUpName',type:'string'}	,	//上级参数名称
			
			{name:'icoUrl',type:'string'}	,	//图标路径
			
			{name:'isDir',type:'Boolean'}	,	//是否有子类
			
			{name:'parType',type:'string'}	,	//参数类型
			
			{name:'parLev',type:'string'}	,	//层级
			
			{name:'isExp',type:'Boolean'}	,	//是否默认展开
			
			{name:'sortIndex',type:'string'}	,	//排序序号
			
			{name:'isDef',type:'Boolean'}	,	//默认选中
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
    	 
        type : 'rest',
        url:'sysParameter',
        appendId:false,
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'sysParameter/create',
        	read:'sysParameter/list',
        	update:'sysParameter/update',
        	destroy:'sysParameter/delete' 
        	 
        },
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