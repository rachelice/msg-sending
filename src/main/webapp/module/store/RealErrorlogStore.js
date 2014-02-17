Ext.define('Fes.store.RealErrorlogStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.RealErrorlogModel',
			pageSize : 20,
			autoLoad: true,
			remoteSort: true,
			sorters: [{
				property: 'occurdate',
				direction: 'DESC'
			}]
		});