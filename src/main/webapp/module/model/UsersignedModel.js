Ext.define('Fes.model.UsersignedModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'occurdate',type:'date',dateFormat:'time'},
        {name : 'user_id',type:'string'},
        {name : 'flag',type:'string'},    
        {name : 'scope',type:'string'}     
    ],
	proxy : {
		type : 'rest',
		url : 'loginUser/usersigned',
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