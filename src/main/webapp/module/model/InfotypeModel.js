Ext.define("Fes.model.InfotypeModel",{
	extend:'Ext.data.Model',
	fields:[
			
			{name:'typename',type:'string'}	,	//类型名称
			
			{name:'description',type:'string'}	,	//备注
			
			{name:'note',type:'string'}	,	//note
		{name:'id',type:'int'}
		 
	],
    proxy:{   
        type : 'rest',
        url:'infotypes',
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