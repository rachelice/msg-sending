Ext.define('Fes.model.BusiCodeModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'action',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'busicodes',
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