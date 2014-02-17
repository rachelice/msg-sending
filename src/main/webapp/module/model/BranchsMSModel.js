Ext.define('Fes.model.BranchsMSModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'prodate',type:'string'},
        {name : 'probrc',type:'string'},
        {name : 'promode',type:'string'},
        {name : 'splitseq',type:'int'},
        {name : 'oppbrc',type:'string'},
        {name : 'modidate',type:'string'},
        {name : 'teller',type:'string'},
        {name : 'proflag',type:'string'},
        {name : 'splitflag',type:'string'},
        {name : 'subsys',type:'string'},
        {name : 'subctrlcode',type:'string'},
        {name : 'acctno',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'branchsms',
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