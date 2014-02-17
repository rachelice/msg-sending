Ext.define("Fes.model.CsContractInfoModel",{
	extend:'Ext.data.Model',
	fields:[
				{name:'area',type:'string'}	,	//区域
				{name:'areaName', type:'string'},
			
				{name:'customerName',type:'string'}	,	//客户名称
			
			
				{name:'customerType',type:'string'}	,	//客户类型
				{name:'customerTypeName', type:'string'},
			
				{name:'contractNumber',type:'string'}	,	//合同/销单/签证编号
			
			
				{name:'contractName',type:'string'}	,	//合同名称
			
			
				{name:'contractType',type:'string'}	,	//合同类型
				{name:'contractTypeName', type:'string'},
			
				{name:'projectNumber',type:'string'}	,	//项目编号
			
			
				{name:'signDate',type:'auto'}	,	//签订时间
			
				{name:'endDate',type:'auto'}	,	//到期时间
			
				{name:'contractMoney',type:'string'}	,	//合同额
			
			
				{name:'settlementMoney',type:'string'}	,	//结算凭证金额
			
			
				{name:'projectInfo',type:'string'}	,	//是否立项
			
			
				{name:'firstPaymoney',type:'string'}	,	//首付款金额
			
			
				{name:'firstPaymoneyDate',type:'auto'}	,	//首付款回款时间
			
				{name:'secondPaymoney',type:'string'}	,	//第二笔金额
			
			
				{name:'secondPaymoneyDate',type:'auto'}	,	//第二笔回款时间
			
				{name:'endPaymoney',type:'string'}	,	//尾款金额
			
			
				{name:'endPaymoneyDate',type:'auto'}	,	//尾款回款时间
			
				{name:'otherPaymoney',type:'string'}	,	//其他回款金额
			
			
				{name:'otherPaymoneyDate',type:'auto'}	,	//其他回款时间
			
				{name:'remark1',type:'string'}	,	//备用字段1
			
			
				{name:'remark2',type:'string'}	,	//备用字段2
			
			
				{name:'remark3',type:'string'}	,	//备用字段3
			
			
				{name:'remark4',type:'string'}	,	//备用字段4
			
			
				{name:'remark5',type:'string'}	,	//备用字段5
			
			
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
    	 
        type : 'rest',
        appendId:false,
        url:'csContractInfo',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'csContractInfo/create',
        	read:'csContractInfo/list',
        	update:'csContractInfo/update',
        	destroy:'csContractInfo/delete' 
        	 
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