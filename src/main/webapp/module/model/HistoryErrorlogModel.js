Ext.define('Fes.model.HistoryErrorlogModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'terminal',type:'string'},
        {name : 'occurdate',type:'date',dateFormat:'time'},
        {name : 'responsedate',type:'date',dateFormat:'time'},
        {name : 'user_id',type:'string'},
        {name : 'description',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'historyerrorlogs',
		extraParams:{
	    	'terminal':'',
	    	'starttime':'',
	    	'endtime':''},
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