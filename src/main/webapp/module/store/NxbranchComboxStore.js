Ext.define('Fes.store.NxbranchComboxStore', {
	extend : 'Ext.data.Store',	    
	fields: [
	         {name : 'id',type:'int'},
	         {name : 'brccode',type:'string'},
	         {name : 'brcname',type:'string'} 
            ],
    proxy : {
        type : 'rest',
        url : 'users/nxbranchs',
        reader : {
            type : 'json',
            root : 'root'
        },
        writer : {
            type : 'json'
        }
    },
    pageSize : 20,
    autoLoad : false,
    remoteSort : true
});
