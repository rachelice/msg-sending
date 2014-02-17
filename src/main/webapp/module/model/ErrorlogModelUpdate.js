 
Ext.define('Fes.model.ErrorlogModelUpdate', {
    extend: 'Ext.data.Model',
	fields: [
	         {name : 'id',type:'int'}/*,
	         {name : 'terminal',type:'string'},
	         {name : 'occurdate',type:'string' },
	         {name : 'user',type:'string'},
	         {name : 'responsedate',type:'string' },
	         {name : 'description',type:'string'},
	         {name : 'deptName',type:'string'},
	         {name : 'timestamp',type:'string'}*/
	        
	         ],
	proxy : {
		type : 'rest',
		url : 'errorlogs',
		
	 
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