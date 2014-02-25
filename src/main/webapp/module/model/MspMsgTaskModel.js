Ext.define("Fes.model.MspMsgTaskModel",{
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
	    appendId:false,    	 
        type : 'rest',
        url:'mspMsgTask',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'mspMsgTask/create',
        	read:'mspMsgTask/list',
        	update:'mspMsgTask/update',
        	destroy:'mspMsgTask/delete' 
        	 
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