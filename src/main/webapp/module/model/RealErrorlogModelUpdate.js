 
Ext.define('Fes.model.RealErrorlogModelUpdate', {
    extend: 'Ext.data.Model',
	fields: [
	         {name : 'id',type:'int'}
	         ],
	proxy : {
		type : 'rest',
		url : 'realerrorlogs',
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