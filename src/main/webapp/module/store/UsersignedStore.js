Ext.define('Fes.store.UsersignedStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.UsersignedModel',
			pageSize : 20,
			autoLoad : true,
			remoteSort : true
		});