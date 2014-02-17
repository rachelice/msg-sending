Ext.define('SimpleReports.model.Task', {
    extend: 'Ext.data.Model',
   
    fields: [

            {name: 'id', type: 'int' },
			{name:'sql',type:'string'}	,	//sql
			{name:'note',type:'string'}	,	//not
			{name:'count',type:'string'}	,	//count
			{name:'title',type:'string',defaultValue:'无标题'}	,	//title
			{name:'state',type:'boolean',defaultValue:false}	,	//state
			{name:'parentParamId',type:'int'}	,	//parentParamId 
			{name:'parentParamName',type:'string'}	,	//parentParamId parentParamName
			{name:'syb1',type:'string'}	,	//syb1
			{name:'syb2',type:'string'}	,	//syb2
			{name:'syb3',type:'string'}	,	//syb3
			{name:'syb4',type:'string'}	,	//syb4
			{name:'syb5',type:'string'}	,	//syb5
			{name:'createDate',type:'date',dateFormat: 'time'}	 	//createDate

 /*
        { name: 'title' },
        { name: 'list_id', type: 'int' },
        { name: 'due', type: 'date', dateFormat: 'c' },
        { name: 'reminder', type: 'date', dateFormat: 'c' },
        { name: 'done', type: 'boolean', defaultValue: false },
        { name: 'note' }*/
    ],
    proxy:{
   	 
        type : 'rest',
        url:'sysCustomSql/list',
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
 
/*
    proxy: SimpleReportsSettings.useLocalStorage ? {
        type: 'localstorage',
        id: 'SimpleReports-Task'
    } : {
        type: 'ajax',
        api: {
            create: 'php/task/create.php',
            read: 'php/task/read.php',
            update: 'php/task/update.php',
            destroy: 'php/task/delete.php'
        },
        reader: {
            type: 'json',
            root: 'tasks',
            messageProperty: 'message'
        }
    }
*/
});