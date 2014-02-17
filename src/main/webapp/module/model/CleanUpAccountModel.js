Ext.define('Fes.model.CleanUpAccountModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'acctno',type:'string'},
        {name : 'custname',type:'string'},
        {name : 'stlacctno',type:'string'},
        {name : 'stat',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'cleanupaccounts',
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