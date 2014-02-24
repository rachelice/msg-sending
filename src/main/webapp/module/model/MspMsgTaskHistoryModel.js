Ext.define("Fes.model.MspMsgTaskHistoryModel",{
	extend:'Ext.data.Model',
	fields:[
				{name:'msgNum',type:'string'}	,	//msgNum
			
			
				{name:'msgContent',type:'string'}	,	//msgContent
			
			
				{name:'msgType',type:'string'}	,	//msgType
			
			
				{name:'status',type:'string'}	,	//status
			
			
				{name:'sendingTime',type:'auto'}	,	//sendingTime
			
				{name:'priority',type:'string'}	,	//priority
			
			
				{name:'createTime',type:'auto'}	,	//createTime
			
				{name:'submitTime',type:'auto'}	,	//submitTime
			
				{name:'submitterCode',type:'string'}	,	//submitterCode
			
			
				{name:'groupSending',type:'string'}	,	//groupSending
			
			
				{name:'businessCode',type:'string'}	,	//businessCode
			
			
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
    	 
        type : 'rest',
        url:'mspMsgTaskHistory',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'mspMsgTaskHistory/create',
        	read:'mspMsgTaskHistory/list',
        	update:'mspMsgTaskHistory/update',
        	destroy:'mspMsgTaskHistory/delete' 
        	 
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