	Ext.define('Fes.store.TfunctionStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.TfunctionModel',
			pageSize : 20,
			autoLoad : true,
			remoteSort : true,
			listeners : {
				load:function(s,records,success,e){
					console.log(Ext.JSON.encode(success));
					
				},
				beforeload:function(store,operation,success,e){
				//	alert(Ext.JSON.encode(operation));
					
				}
			} 
		});