Ext.define("Fes.model.CsContractDetailInfoModel",{
	extend:'Ext.data.Model',
	fields:[
				{name:'contractNumber',type:'string'}	,	//合同/销单/签证编号
		 	    {name : 'customerName', type : 'string'},
			
				{name:'deviceName',type:'string'}	,	//设备名称
			
			
				{name:'deviceModel',type:'string'}	,	//设备型号
				{name:'deviceModelName',type:'string'},
			
				{name:'equipmentPrice',type:'string'}	,	//设备单价
			
			
				{name:'openDate',type:'auto'}	,	//SIM卡开始时间
			
				{name:'endDate',type:'auto'}	,	//SIM卡结束时间
			
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
			
			
				{name:'deviceNumber',type:'string'}	,	//设备数量
			
			
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
        url:'csContractDetailInfo',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'csContractDetailInfo/create',
        	read:'csContractDetailInfo/list',
        	update:'csContractDetailInfo/update',
        	destroy:'csContractDetailInfo/delete' 
        	 
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