Ext.define('Fes.model.BrcSignOutModel', { 
    extend: 'Ext.data.Model',
	fields: [
	    {name : 'id',type:'int'},
        {name : 'brccode',type:'string'},
        {name : 'brcname',type:'string'},
        {name : 'phone',type:'string'},
        {name : 'status',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'brcsignouts',
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