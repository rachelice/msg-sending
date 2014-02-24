Ext.define('Fes.model.MsgReceiverModel', { 
	extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'name',type:'string'},
        {name : 'mobileNumber',type:'string'},
        {name : 'semester',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'msgreceiver',
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