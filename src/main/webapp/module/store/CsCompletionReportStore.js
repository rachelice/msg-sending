	Ext.define('Fes.store.CsCompletionReportStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.CsCompletionReportModel',
			pageSize : 20,
			autoLoad : true,
			remoteSort : true/*,
			listeners : {
				load:function(s,records,success,e){

					
				},
				beforeload:function(store,operation,success,e){
				//	alert(Ext.JSON.encode(operation));
					
				}
			}*/
		});