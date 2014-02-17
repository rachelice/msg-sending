Ext.define("Fes.model.SysCustomSqlModel",{
	extend:'Ext.data.Model',
	fields:[
				{name:'sql',type:'string'}	,	//sql
			
			
				{name:'note',type:'string'}	,	//note
			
			
				{name:'count',type:'string'}	,	//count
			
			
				{name:'title',type:'string'}	,	//title
			
			
				{name:'state',type:'string'}	,	//state
			
			
				{name:'parentParamId',type:'string'}	,	//parentParamId
			
			
				{name:'syb1',type:'string'}	,	//syb1
			
			
				{name:'syb2',type:'string'}	,	//syb2
			
			
				{name:'syb3',type:'string'}	,	//syb3
			
			
				{name:'syb4',type:'string'}	,	//syb4
			
			
				{name:'syb5',type:'string'}	,	//syb5
			
			
				{name:'createDate',type:'string'}	,	//createDate
			
			
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
    	 
        type : 'rest',
        url:'sysCustomSql',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'sysCustomSql/create',
        	read:'sysCustomSql/list',
        	update:'sysCustomSql/update',
        	destroy:'sysCustomSql/delete' 
        	 
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