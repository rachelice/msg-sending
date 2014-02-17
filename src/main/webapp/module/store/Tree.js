
Ext.define('Fes.store.Tree', {
		extend : 'Ext.data.TreeStore',
		model : 'Fes.model.TreeNode', 
	 
		clearOnLoad : true,
		nodeParam : "id"// 设置传递给后台的参数名,值是树节点的id属性
	});
