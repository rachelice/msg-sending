Ext.define('Fes.store.UpdateAcctInfoStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.UpdateAcctInfoModel',
			pageSize : 20,
			autoLoad : false,
			remoteSort : true
		});