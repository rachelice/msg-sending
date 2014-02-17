Ext.define('Fes.store.ActionlogStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.ActionlogModel',
			pageSize : 20,
			autoLoad : true,
			remoteSort : true,
			sorters: [{
				property: 'occurdate',
				direction:'DESC'
			}]
		});