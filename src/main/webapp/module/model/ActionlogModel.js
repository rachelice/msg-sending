Ext.define('Fes.model.ActionlogModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'action',type:'string'},
        {name : 'occurdate',type:'date',dateFormat:'time'},
        {name : 'user_id',type:'string'},
        {name : 'status',type:'string'},
        {name : 'comments',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'actionlogs',
/*	    actionMethods: {  
            read: 'POST'  
        }, */ 
		reader : {
			type : 'json',
			root : 'root',
			totalProperty : 'total'// 数据的总数
		},
		writer : {
			type : 'json'
		}
	}
});