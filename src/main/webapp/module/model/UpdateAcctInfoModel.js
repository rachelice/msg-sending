Ext.define('Fes.model.UpdateAcctInfoModel', { 
    extend: 'Ext.data.Model',
	fields: [
        {name : 'id',type:'int'},
        {name : 'acctno',type:'string'},//账号
        {name : 'opendate',type:'string'},//开户日期
        {name : 'diacct',type:'string'},//还款卡号
        {name : 'dbacct',type:'string'},//折号，还款账号
        {name : 'discountflag',type:'string'},//贴息标志
        {name : 'noaccrualflag',type:'string'},//非应计标志
        {name : 'currduedate',type:'string'},//当前到期日
        {name : 'loantype1',type:'string'}, //贷款种类1
        {name : 'loanstat',type:'string'}, //贷款状态
        {name : 'intrestres1',type:'number'},//基准利率
        {name : 'opendatechged',type:'boolean'},
        {name : 'diacctchged',type:'boolean'},
        {name : 'dbacctchged',type:'boolean'},
        {name : 'discountflagchged',type:'boolean'},
        {name : 'noaccrualflagchged',type:'boolean'},
        {name : 'currduedatechged',type:'boolean'},
        {name : 'loantype1chged',type:'boolean'},
        {name : 'loanstatchged',type:'boolean'},
        {name : 'intrestres1chged',type:'boolean'},
        {name : 'originalValue',type:'string'},
        {name : 'authteller',type:'string'}
    ],
	proxy : {
		type : 'rest',
		url : 'updateacctinfo',
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