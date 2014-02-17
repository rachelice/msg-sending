Ext.define('Fes.model.LoginUserModel', {
    extend: 'Ext.data.Model',
	fields: [
	         {name : 'id',type:'int'},
	         {name : 'username',type:'string'},
	         {name : 'email',type:'string'},
	         {name : 'password',type:'string'},
	         {name : 'roleId',type:'string'},
	         {name : 'deptId',type:'string'},
	         {name : 'roleName',type:'string'},
	         {name : 'deptName',type:'string'},
	         {name : 'loginName',type:'string'}
	         ],
	proxy : {
		type : 'rest',
		url : 'loginUser',
		
	 
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