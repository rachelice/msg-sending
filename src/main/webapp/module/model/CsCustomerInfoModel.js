Ext.define("Fes.model.CsCustomerInfoModel",{
	extend:'Ext.data.Model',
	fields:[
				{name:'area',type:'string'}	,	//区域
				{name:'areaName',type:'string'},// add here 区域名
			
				{name:'customerName',type:'string'}	,	//客户名称
			
			
				{name:'customerType',type:'string'}	,	//客户类型
				{name:'customerTypeName',type:'string'},
			
				{name:'customerTel',type:'string'}	,	//联系电话
			
			
				{name:'customerPeople',type:'string'}	,	//客户联系人
			
			
				{name:'customerAddress',type:'string'}	,	//详细地址
			
			
				{name:'unitNumber',type:'string'}	,	//单位税号
			
			
				{name:'accountNumber',type:'string'}	,	//开户行账号
			
			
				{name:'postalNumber',type:'string'}	,	//邮政编码
			
			
				{name:'remark1',type:'string'}	,	//remark1
			
			
				{name:'remark2',type:'string'}	,	//remark2
			
			
				{name:'remark3',type:'string'}	,	//remark3
			
			
				{name:'remark4',type:'string'}	,	//remark4
			
			
				{name:'remark5',type:'string'}	,	//remark5
			
			
				{name:'remark6',type:'string'}	,	//remark6
			
			
				{name:'remark7',type:'string'}	,	//remark7
			
			
				{name:'remark8',type:'string'}	,	//remark8
			
			
				{name:'remark9',type:'string'}	,	//remark9
			
			
				{name:'remark10',type:'string'}	,	//remark10
			
			
				{name:'remark11',type:'string'}	,	//remark11
			
			
				{name:'remark12',type:'string'}	,	//remark12
			
			
				{name:'remark13',type:'string'}	,	//remark13
			
			
				{name:'remark14',type:'string'}	,	//remark14
			
			
				{name:'remark15',type:'string'}	,	//remark15
			
			
				{name:'remark16',type:'string'}	,	//remark16
			
			
				{name:'remark17',type:'string'}	,	//remark17
			
			
				{name:'remark18',type:'string'}	,	//remark18
			
			
				{name:'remark19',type:'auto'}	,	//remark19
			
				{name:'remark20',type:'auto'}	,	//remark20
			
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
    	 
        type : 'rest',
		appendId:false,
        url:'csCustomerInfo',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'csCustomerInfo/create',
        	read:'csCustomerInfo/list',
        	update:'csCustomerInfo/update',
        	destroy:'csCustomerInfo/delete' 
        	 
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