Ext.define('Fes.model.UpdateBonusFlagModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'acctno',type:'string'},
        {name : 'year',type:'number'},
        {name : 'clsamt',type:'number'},
        {name : 'flag',type:'string'},
        {name : 'originalValue',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'updatebonusflags',
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