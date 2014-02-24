Ext.define('Fes.store.MsgReceiverStore', {
			extend : 'Ext.data.Store',
			fields: [
			         {name : 'id',type:'int'},
			         {name : 'learnerName',type:'string'},
			         {name : 'mobileNumber',type:'string'} 
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