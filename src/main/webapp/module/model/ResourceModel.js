Ext.define('Fes.model.ResourceModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'parent_id',type:'int'},
        {name : 'type',type:'string'},
        {name : 'text',type:'string'},
        {name : 'component',type:'string'},
        {name : 'url',type:'string'},
        {name : 'description',type:'string'},
        {name : 'iconCls',type:'string'},
        {name : 'index',type:'int'} 
    ],
	proxy : {
		type : 'rest',
		url : 'resources',
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