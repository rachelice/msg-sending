var _sysParameterWindow = false;
Ext.define('Fes.view.SysParameterList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.sysParameterList',
	title : '全部参数-列表1',

	requires : [ "Fes.util.ParameterComboTree", 'Ext.toolbar.Paging' ],
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载[参数]列表'
	},
	createRoleCombox : function() {

	},
	columns : [ {
		xtype : 'rownumberer'
	}, {
		text : '参数名称',
		width : 120,
		sortable : true,
		dataIndex : 'parName',
		field : {
			xtype : 'textfield',
			required : true
		}
	},

	{
		text : '参数代码',
		width : 120,
		sortable : true,
		dataIndex : 'parCode',
		field : {
			xtype : 'textfield',
			required : true
		}
	},

	{
		text : '上级参数',
		width : 120,
		renderer : function(v, c, r) {
			return r.data.parUpName;
		},
		sortable : true,
		dataIndex : 'parUpName',
		field : {
			xtype : 'parameterComboTree',
			// fieldLabel: '权限',
			// labelWidth: 40,
			rootText : '功能',

			rootId : '1',

			storeUrl : 'sysParameter/getTreeNodeChildren',
			id : 'sysParameterlist' + 'SysParameterComboTree',
			selectMode : 'all',
			treeHeight : 300,
			rootVisible : true
		}
	},

	{
		text : '图标路径',
		width : 120,
		sortable : true,
		dataIndex : 'icoUrl',
		field : {
			xtype : 'textfield'
		}
	},

	{
		text : '是否有子类',
		width : 120,
		sortable : true,
		dataIndex : 'isDir',
		field : {
			xtype : 'textfield'
		}
	},

	{
		text : '参数类型',
		width : 120,
		sortable : true,
		dataIndex : 'parType',
		field : {
			xtype : 'textfield'
		}
	},

	{
		text : '层级',
		width : 120,
		sortable : true,
		dataIndex : 'parLev',
		field : {
			xtype : 'textfield'
		}
	},

	{
		text : '是否默认展开',
		width : 120,
		sortable : true,
		dataIndex : 'isExp',
		field : {
			xtype : 'textfield'
		}
	},

	{
		text : '排序序号',
		width : 120,
		sortable : true,
		dataIndex : 'sortIndex',
		field : {
			xtype : 'textfield'
		}
	},

	{
		text : '默认选中',
		width : 120,
		sortable : true,
		dataIndex : 'isDef',
		field : {
			xtype : 'textfield'
		}
	},

	{
		text : 'id',
		width : 120,
		sortable : true,
		dataIndex : 'id',
		hidden : true
	}

	],

	initComponent : function() {

		this.createStore();

		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
			id : 'sysParameterListRowEditor',
			listeners : {
				beforeedit : function(editor, e, eOpts) {
					Ext.getCmp('sysParameterlist' + 'SysParameterComboTree')
							.setLocalValue(e.record.data.parUpId,
									e.record.data.parUpName);

				},
				startEdit : function(record, columnHeader) {

					this.editRecord = record;
				},
				edit : function(editor, e) {
					var me = this;
					e.record.data.parUpId = Ext.getCmp(
							'sysParameterlist' + 'SysParameterComboTree')
							.getValue();
					e.record.data.parUpName = Ext.getCmp(
							'sysParameterlist' + 'SysParameterComboTree')
							.getTextValue();
					e.record.save({
						success : function(sysParameter, options) {

							var data = Ext
									.decode(options.response.responseText);
							if (data.extra) {
								sysParameter.set('id', data.extra);
							}
							// alert(Ext.JSON.encode(sysParameter.data));
							sysParameter.data.parUpName = Ext.getCmp(
									'sysParameterlist'
											+ 'SysParameterComboTree')
									.getTextValue();
							sysParameter.commit();

						}
					});

				}
			}
		});

		;
		this.plugins = [ this.rowEditor ], this.tbar = this.createToolbar();

		this.callParent();

	},
	saveRecode : function(obj) {
		var record = new Fes.model.SysParameterModel(obj);
		this.getStore().add(record);
		record.save({
			success : function(vo, options) {
				var data = Ext.decode(options.response.responseText);
				if (data.extra) {
					vo.set('id', data.extra);
				}
				vo.commit();
			}
		});
	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.SysParameterStore');

		me.bbar = Ext.create('Ext.PagingToolbar', {

			store : me.store,
			displayInfo : true
		});
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.SysParameterModel({

		});

		if (records.length > 0) {
			// record = records[records.length-1];
			record = new Fes.model.SysParameterModel({

				parName : records[records.length - 1].data.parName,

				parCode : records[records.length - 1].data.parCode,

				parUpId : records[records.length - 1].data.parUpId,

				icoUrl : records[records.length - 1].data.icoUrl,

				isDir : records[records.length - 1].data.isDir,

				parType : records[records.length - 1].data.parType,

				parLev : records[records.length - 1].data.parLev,

				isExp : records[records.length - 1].data.isExp,

				sortIndex : records[records.length - 1].data.sortIndex,

				isDef : records[records.length - 1].data.isDef

			});
		}

		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个参数?',
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
	showWindow : function(rec) {
		var me = this;
		if (!_sysParameterWindow) {
			_sysParameterWindow = Ext.create('Fes.view.SysParameterWindow', {
				buttons : [
						{
							text : 'Save5',
							handler : function() {

								// alert(_sysParameterWindow.down('form').getValues());
								me.saveRecode(_sysParameterWindow.down('form')
										.getValues());

							}
						}, {
							text : 'Cancel',
							scope : this,
							handler : function() {
								_sysParameterWindow.hide();
							}
						} ]
			});

		}
		_sysParameterWindow.show();
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
			items : [
					{
						xtype : 'textfield',
						fieldLabel : ' ',
						labelWidth : 40,
						emptyText : '输入参数名称/代码/类型',
						labelSeparator : '',
						flex : .6,
						id : 'sysParameterId'
					},
					{
						xtype : 'button',
						text : '查询',
						iconCls : 'icon-search',
						handler : function() {
							me.getStore().load(
									{
										params : {
											params : Ext.getCmp(
													'sysParameterId')
													.getValue(),
											start : 0

										},
										callback : function(re, options,
												success) {

											me.setTitle('查询[参数名称/代码/类型]条件为： :"'
													+ Ext.getCmp(
															'sysParameterId')
															.getValue()
													+ '" 的结果列表');
										}
									});
						}
					}, '-', Ext.create('Ext.Button', {
						text : '添加1',
						iconCls : 'icon-add',
						handler : me.showWindow,
						scope : me
					}), Ext.create('Ext.Button', {
						text : '添加',
						iconCls : 'icon-add',
						handler : me.addRecord,
						scope : me
					}), '-', {
						xtype : 'button',
						text : '删除',
						iconCls : 'icon-del',
						handler : me.deleteRecord,
						scope : me
					} ]
		});
	}
});
