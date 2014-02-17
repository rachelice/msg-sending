Ext.define("Fes.model.CsCustomerInfoModel",{
	extend:'Ext.data.Model',
	fields:[
			
			{name:'area',type:'string'}	,	//area
			
			{name:'customerName',type:'string'}	,	//customerName
			
			{name:'customerType',type:'string'}	,	//customerType
			
			{name:'contractNumber',type:'string'}	,	//contractNumber
			
			{name:'contractName',type:'string'}	,	//contractName
			
			{name:'contractType',type:'string'}	,	//contractType
			
			{name:'projectNumber',type:'string'}	,	//projectNumber
			
			{name:'signDate',type:'string'}	,	//signDate
			
			{name:'endDate',type:'string'}	,	//endDate
			
			{name:'contractMoney',type:'string'}	,	//contractMoney
			
			{name:'settlementMoney',type:'string'}	,	//settlementMoney
			
			{name:'projectInfo',type:'string'}	,	//projectInfo
			
			{name:'firstPaymoney',type:'string'}	,	//firstPaymoney
			
			{name:'firstPaymoneyDate',type:'string'}	,	//firstPaymoneyDate
			
			{name:'secondPaymoney',type:'string'}	,	//secondPaymoney
			
			{name:'secondPaymoneyDate',type:'string'}	,	//secondPaymoneyDate
			
			{name:'endPaymoney',type:'string'}	,	//endPaymoney
			
			{name:'endPaymoneyDate',type:'string'}	,	//endPaymoneyDate
			
			{name:'otherPaymoney',type:'string'}	,	//otherPaymoney
			
			{name:'otherPaymoneyDate',type:'string'}	,	//otherPaymoneyDate
			
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
			
			{name:'remark19',type:'string'}	,	//remark19
			
			{name:'remark20',type:'string'}	,	//remark20
		{name:'id',type:'int'}
		 
	],
    proxy:{
   
        type : 'rest',
        url:'csCustomerInfos',
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