Ext.define('SimpleReports.store.Lists', {
    extend: 'Ext.data.TreeStore',
    model: 'SimpleReports.model.List',
    //autoLoad:true,
	nodeParam : 'id',	
	 root : {  
          id : 8003,  
          parName : '报表',
          expanded : true
      },
	 proxy: {
	        type: 'rest',
	        appendId:false,
	     	url: 'sysParameter/list',
	     	reader:{
	           type : 'json',
	            root:'root',
	           totalProperty : 'total'// 数据的总数
	       },
	        
	       api: {  
               create: 'sysParameter/createNode',  
               read: 'sysParameter/list',  
               update: 'sysParameter/updateNode',  
               destroy: 'sysParameter/delete'  
           },  
           writer: {  
               type: 'json',  
              allowSingle: false,  
               encode: true,  
               root: 'records'  
           }  
	    }, 

});