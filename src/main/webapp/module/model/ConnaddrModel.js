Ext.define('Fes.model.ConnaddrModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'type',type:'string'},
        {name : 'ipaddress',type:'string'},
        {name : 'account',type:'string'},
        {name : 'password',type:'string'},
        {name : 'commands',type:'string'},
        {name : 'description',type:'string'},
        {name : 'parameters',type:'string'},
        {name : 'ipaddresschg',type:'boolean'},
        {name : 'accountchg',type:'boolean'},
        {name : 'passwordchg',type:'boolean'}
     ],
	proxy : {
		type : 'rest',
		url : 'connaddrs',
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