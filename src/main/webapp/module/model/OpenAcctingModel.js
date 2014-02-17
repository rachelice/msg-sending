Ext.define('Fes.model.OpenAcctingModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'acctno',type:'string'},
        {name : 'acckind',type:'string'},
        {name : 'accpagetype',type:'string'},
        {name : 'accctrlflag',type:'string'},
        {name : 'subctrlcode',type:'string'},
        {name : 'seqno',type:'int'}
    ],
	proxy : {
		type : 'rest',
		url : 'openaccting',
/*	    actionMethods: {  
            read: 'POST'  
        }, */ 
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