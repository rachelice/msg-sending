Ext.define("Fes.store.DeptStore4ComboxTree", {
	extend : 'Ext.data.TreeStore',
	defaultRootId : 'root',
	autoLoad : true,
	root : {
		id : 0,
		leaf : false,
		text : '总行',
		expanded : true
	},
	api : { 
		update : ''
	},
	extraParams : {
		times : 1
	},
	nodeParam : 'id' 
});