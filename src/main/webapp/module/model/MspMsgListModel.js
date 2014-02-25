Ext.define("Fes.model.MspMsgListModel",{
	extend:'Ext.data.Model',
	fields:[
				{name:'messagenum',type:'string'}	,	//messagenum
			
			
				{name:'content',type:'string'}	,	//content
			
			
				{name:'mobilenumber',type:'string'}	,	//mobilenumber
			
			
				{name:'status',type:'string'}	,	//status
			
			
				{name:'sendingtime',type:'auto'}	,	//sendingtime
			
				{name:'priority',type:'string'}	,	//priority
			
			
				{name:'count',type:'string'}	,	//count
			
			
				{name:'createtime',type:'auto'}	,	//createtime
			
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
	    appendId:false,
        type : 'rest',
        url:'mspMsgList',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'mspMsgList/create',
        	read:'mspMsgList/list',
        	update:'mspMsgList/update',
        	destroy:'mspMsgList/delete' 
        	 
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