Ext.define('Fes.util.RaceCombox', {
	extend : 'Ext.form.field.ComboBox',
	alias : 'widget.raceCombox',
	//   multiSelect: true,
	allSelector : false,
	addAllSelector : false,
	valueField : 'value',
	displayField : 'name',
	value : 1,
	forceSelection : true, //只允许从下拉列表中进行选择，不能输入文本

	queryMode : "local",
	editable : false,
	//allText:'【全选】',//默认字符是All
	// addAllSelector: true,

	store : Ext.create('Fes.store.RaceStore', {

	}),
	listeners : {
		scope : this,
		"select" : function(comboBox, record, index) {
			Ext.Array.each(record, function(item) {
				console.log(item.get("name"));
			});
			console.log(comboBox.getValue()); //这个是获取value的不是获取到显示在哪里的值
		}
	}
});
