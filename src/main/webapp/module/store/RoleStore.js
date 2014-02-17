Ext.define('Fes.store.RoleStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.RoleModel',
			pageSize : 20,
			autoLoad : true,
			remoteSort : true
		});