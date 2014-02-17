Ext.define('Fes.model.AssoCustomModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'customid',type:'string'},
        {name : 'customname',type:'string'},
        {name : 'newcustomid',type:'string'},
        {name : 'idno',type:'string'},
        {name : 'idname',type:'string'},
        {name : 'subsys',type:'string'},
        {name : 'count',type:'int'},
        {name : 'tablename_en',type:'string'},
        {name : 'tablename_zh',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'assocustoms',
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