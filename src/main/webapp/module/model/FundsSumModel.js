Ext.define('Fes.model.FundsSumModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'filename',type:'string'},
        {name : 'filetime',type:'date',dateFormat:'time'},
        {name : 'filesize',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'fundssums',
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