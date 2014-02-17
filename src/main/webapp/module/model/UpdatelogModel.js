Ext.define('Fes.model.UpdatelogModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'action',type:'string'},
        {name : 'occurdate',type:'date',dateFormat:'time'},
        {name : 'user_id',type:'string'},
        {name : 'table_name',type:'string'},
        {name : 'keys',type:'string'},
        {name : 'key_value',type:'string'},
        {name : 'columns',type:'string'},
        {name : 'old_value',type:'string'},
        {name : 'new_value',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'updatelogs',
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