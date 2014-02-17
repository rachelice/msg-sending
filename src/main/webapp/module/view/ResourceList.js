console.log('ResourceList...');
Ext.define('Fes.view.ResourceList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.resourcelist',
	title : '菜单列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载列表'
	},
	columns : [{
				xtype : 'rownumberer'
			}, {
				text : 'ID',
				width : 40,
				sortable : true,
				dataIndex : 'id',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '上一级ID',
				width : 60,
				sortable : true,
				dataIndex : 'parent_id',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '类型',
				width : 100,
				sortable : true,
				dataIndex : 'type',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '名称',
				width : 100,
				sortable : true,
				dataIndex : 'text',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '路径',
				width : 150,
				sortable : true,
				dataIndex : 'component',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '地址',
				width : 100,
				sortable : true,
				dataIndex : 'url',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '图标',
				width : 100,
				sortable : true,
				dataIndex : 'iconCls',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '顺序',
				width : 50,
				sortable : true,
				dataIndex : 'index',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '描述',
				flex : 1,
				sortable : true,
				dataIndex : 'description',
				field : {
					xtype : 'textarea'
				}
			}],
	initComponent : function() {
		this.createStore();
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
			id : 'resourceListRowEditor',
			listeners : {
				beforeedit : function(editor, e, eOpts) {

				},
				startEdit : function(record, columnHeader) {
					this.editRecord = record;
				},
				edit : function(editor, e) {
					e.record.save({
								success : function(resource, options) {
									var data = Ext
											.decode(options.response.responseText);
									if (data.extra) {
										resource.set('id', data.extra);
									}
									resource.commit();
								}
							});
				}
			}
		});
		this.plugins = [this.rowEditor];
		this.tbar = this.createToolbar();

		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true
		};
		this.callParent();
	},
	createStore : function() {
		var me = this;
		this.store = Ext.create('Fes.store.ResourceStore');
	},
	addRecord : function() {
		var record = new Fes.model.ResourceModel({
					text : '菜单名称'
				});

		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个菜单?',
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
		} else {
			Ext.MessageBox.alert("提示", "至少选择 一条记录!");
		}

	},
	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
			items : [{
						xtype : 'textfield',
						fieldLabel : '名称',
						labelWidth : 40,
						flex : 1,
						id : 'text'
					}, '-', {
						xtype : 'button',
						text : '查询',
						iconCls : 'icon-search',
						handler : function() {
							me.getStore().load({
										params : {
											text : Ext.getCmp('text')
													.getValue(),
											page : 1,
											start : 0
										}
									});
						}
					}, '-', {
						xtype : 'button',
						text : '添加',
						iconCls : 'icon-add',
						handler : me.addRecord,
						scope : me
					}, '-', {
						xtype : 'button',
						text : '删除',
						iconCls : 'icon-del',
						handler : me.deleteRecord,
						scope : me
					}, '-', {
						xtype : 'button',
						text : '导出',
						iconCls : 'icon-download',
						scope : me,
						handler : function() {
							var vExportContent = getExcelUrl.getExcelUrl(me,
									"系统资源");
							// window.location = url;
							if (Ext.isIE6 || Ext.isIE7 || Ext.isIE8
									|| Ext.isSafari) {
								var fd = Ext.get('frmDummy');
								if (!fd) {
									fd = Ext.DomHelper.append(Ext.getBody(), {
												tag : 'form',
												method : 'post',
												id : 'frmDummy',
												action : Ext.appPath
														+ '/exportexcel.jsp',
												target : '_blank',
												name : 'frmDummy',
												cls : 'x-hidden',
												cn : [{
															tag : 'input',
															name : 'exportContent',
															id : 'exportContent',
															type : 'hidden'
														}]
											}, true);
								}
								fd.child('#exportContent').set({
											value : vExportContent
										});
								fd.dom.submit();
							} else {
								document.location = 'data:application/vnd.ms-excel;base64,'
										+ Base64.encode(vExportContent);
							}

						}
					}]
		});
	}
});