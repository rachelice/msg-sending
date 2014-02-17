Ext.define('Fes.store.LoginUserStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.LoginUserModel',
			pageSize : 20,
			autoLoad : false,
			remoteSort : true
		});