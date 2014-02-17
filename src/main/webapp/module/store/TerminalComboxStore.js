Ext.define('Fes.store.TerminalComboxStore', {
	extend : 'Ext.data.Store',	    
	fields: [
	         {name : 'id',type:'int'},
             {name : 'name',type:'string'},
             {name : 'terminal',type:'string'},
             {name : 'description',type:'string'}
            ],
    proxy : {
        type : 'rest',
        url : 'historyerrorlogs/monitors',
        reader : {
            type : 'json',
            root : 'root'
        },
        writer : {
            type : 'json'
        }
    },
    autoLoad : true,
    remoteSort : true
});
