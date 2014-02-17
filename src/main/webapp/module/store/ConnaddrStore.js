Ext.define('Fes.store.ConnaddrStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.ConnaddrModel',
			pageSize : 20,
			autoLoad : true,
			remoteSort : true
		});