Ext.define('Fes.store.BrcSignOutStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.BrcSignOutModel',
			pageSize : 20,
			autoLoad : false,
			remoteSort : false,
			sorters: [{
				property: 'brccode',
				direction:'DESC'
			}]
		});