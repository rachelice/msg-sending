Ext.define('Fes.store.TellerSignOutStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.TellerSignOutModel',
			pageSize : 20,
			autoLoad : false,
			remoteSort : false,
			sorters: [{
				property: 'brccode',
				direction:'ASC'
			}]
		});