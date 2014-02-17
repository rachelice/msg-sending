Ext.define('Fes.store.ResourceStore', {
			extend : 'Ext.data.Store',
			model : 'Fes.model.ResourceModel',
			pageSize : 20,
			autoLoad : true,
			remoteSort : true,
			sorters: [{
				property: 'parent_id',
				direction: 'ASC'
			},{
				property: 'index',
				direction:'ASC'
			},{
				property: 'type',
				direction: 'DESC'
			}]
		});