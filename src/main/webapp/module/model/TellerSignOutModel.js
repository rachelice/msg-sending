Ext.define('Fes.model.TellerSignOutModel', { 
    extend: 'Ext.data.Model',
	fields: [
	    {name : 'id',type:'int'},
        {name : 'tellercode',type:'string'},
        {name : 'tellername',type:'string'},
        {name : 'brccode',type:'string'},
        {name : 'status',type:'string'},
        {name : 'action',type:'string'},
        {name : 'workstate',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'tellersignouts',
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