Ext.define('Fes.store.UpdatelogStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.UpdatelogModel',
			pageSize : 20,
			autoLoad : true,
			remoteSort : true,
			sorters: [{
				property: 'occurdate',
				direction:'DESC'
			}]
		});