
Ext.define('Fes.view.TfunctionList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.tfunctionlist',
	title : '角色列表',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载人员列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
					{text : '图标ID',width : 120,sortable : true,dataIndex : 'iconid',field : {xtype : 'textfield',required : true}},
					{text : '父权限ID',width : 120,sortable : true,dataIndex : 'parentfunctionid',field : {xtype : 'textfield',required : true}},
					{text : '菜单名称',width : 120,sortable : true,dataIndex : 'functionname',field : {xtype : 'textfield',required : true}},
					{text : '菜单等级',width : 120,sortable : true,dataIndex : 'functionlevel',field : {xtype : 'textfield',required : true}},
					{text : '菜单地址',width : 120,sortable : true,dataIndex : 'functionurl',field : {xtype : 'textfield',required : true}},
					{text : '图标路径',width : 120,sortable : true,dataIndex : 'iconpath',field : {xtype : 'textfield',required : true}},
					{text : 'functionorder',width : 120,sortable : true,dataIndex : 'functionorder',field : {xtype : 'textfield',required : true}},
					{text : 'functioniframe',width : 120,sortable : true,dataIndex : 'functioniframe',field : {xtype : 'textfield',required : true}},
	 	 		{text:'id',dataIndex:'id',hidden:true}
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'tfunctionListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
					},
					startEdit:function(record, columnHeader ){
			
						this.editRecord=record;
					},
					edit : function(editor, e) {
					 
						e.record.save({
									success : function(tfunction, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											tfunction.set('id', data.extra);
										}
										tfunction.commit();
									}
								});
	
					}
				}
			});
		 
		;
		this.plugins = [this.rowEditor], this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true
		};
		this.callParent();
		
	},

	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.TfunctionStore');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.TfunctionModel({
			
		});

		if (records.length > 0){
			// record =	records[records.length-1];
			record= new Fes.model.TfunctionModel({
			
						iconid:records[records.length-1].data.iconid,
				 	
						parentfunctionid:records[records.length-1].data.parentfunctionid,
				 	
						functionname:records[records.length-1].data.functionname,
				 	
						functionlevel:records[records.length-1].data.functionlevel,
				 	
						functionurl:records[records.length-1].data.functionurl,
				 	
						iconpath:records[records.length-1].data.iconpath,
				 	
						functionorder:records[records.length-1].data.functionorder,
				 	
						functioniframe:records[records.length-1].data.functioniframe,
				 	
 
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个测试方法?',
					function(btn) {
						Ext.each(records, function(record) {
									if (Ext.Array.contains(me.getStore()
													.getNewRecords(), record)) {
										me.getStore().remove(record);
									} else {
										record.destroy({
													success : function() {
														me.store.remove(record);
													}
												});
									}
								});
					});
		}

	},

	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : 'ID',
								labelWidth : 40,
								flex : .6,
								id : 'tfunctionId'
							},{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											id : Ext.getCmp('tfunctionId').getValue()
										}
									});
								}
							}, '-', Ext.create('Ext.Button', {
										text : '添加',
										iconCls : 'icon-add',
										handler : me.addRecord,
										scope : me
									}),  '-', {
								xtype : 'button',
								text : '删除',
								iconCls : 'icon-del',
								handler : me.deleteRecord,
								scope : me
							}]
				});
	}
});