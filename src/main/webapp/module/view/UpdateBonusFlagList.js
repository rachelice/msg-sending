console.log('UpdateBonusFlagList...');
Ext.define('Fes.view.UpdateBonusFlagList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.updatebonusflaglist',
	title : '信息列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	allowDeselect : true,
	viewConfig : {
		loadingText : '正在信息列表'
	},
	columns : [{
				xtype : 'rownumberer'
			}, {
				text : '股金账号',
				flex : 1,
				sortable : true,
				dataIndex : 'acctno'
			}, {
				text : '分红挂账年份',
				flex : 1,
				sortable : true,
				dataIndex : 'year'
			}, {
				text : '入账标志',
				flex : 1,
				sortable : true,
				id : 'flag',
				dataIndex : 'flag',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '挂账金额',
				flex : 1,
				sortable : true,
				dataIndex : 'clsamt'
			}],
	initComponent : function() {
		this.createStore();
		var me = this;
		var callstore = me.getStore();
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
			listeners : {
				beforeedit : function(editor, e, opt) {
					if (Ext.util.Format.trim(e.record.data.flag) == '11') {
						Ext.Msg.show({
									title : '修改红利入账标志',
									msg : "&nbsp;&nbsp;入账标志只能从'12'更新为'11'！",
									buttons : Ext.Msg.OK,
									icon : 'x-message-box-warning'
								});
						editor.getForm().findField('flag').enable(false);
						return false;
						
					}
				},
				edit : function(editor, e) {
					Ext.apply(me.store.proxy.extraParams, {
								'rschacctno' : e.originalValues.acctno
							});
					if (Ext.util.Format.trim(e.originalValues.flag) == Ext.util.Format
							.trim(e.record.data.flag)) {
						me.store.load();
						return
					} else if (Ext.util.Format.trim(e.originalValues.flag) != '12') {
						Ext.Msg.show({
									title : '修改红利入账标志',
									msg : "&nbsp;&nbsp;入账标志只能从'12'更新为'11'！",
									buttons : Ext.Msg.OK,
									icon : 'x-message-box-warning'
								});
						me.store.load();
						return;
					}

					if (Ext.util.Format.trim(e.originalValues.flag) == '12'
							&& Ext.util.Format.trim(e.record.data.flag) != '11') {
						Ext.Msg.show({
									title : '修改红利入账标志',
									msg : "&nbsp;&nbsp;入账标志只能从'12'更新为'11'！",
									buttons : Ext.Msg.OK,
									icon : 'x-message-box-warning'
								});
						me.store.load();
						return;
					};
					e.record.data.originalValue = e.originalValues.flag;

					Ext.Msg.confirm('操作提示', '确定更新' + e.originalValues.year
									+ '年入账标志为【' + e.record.data.flag + '】？',
							function(btn) {
								if ('yes' == btn) {
									e.record.save({
										success : function(record, options) {
											record.commit();
											var response = callstore.getProxy()
													.getReader().rawData;
											if (response.success) {
												Ext.Msg.show({
															title : '修改红利入账标志',
															msg : "&nbsp;&nbsp;"
																	+ response.text
																	+ "！",
															buttons : Ext.Msg.OK,
															icon : 'x-message-box-ok'
														});
											} else {
												Ext.Msg.show({
													title : '修改红利入账标志',
													msg : response.text + "！",
													buttons : Ext.Msg.OK,
													icon : 'x-message-box-warning'
												});
											}
											me.store.load();
										},
										failure : function() {
											Ext.Msg.show({
												title : '修改红利入账标志',
												msg : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改失败！",
												buttons : Ext.Msg.OK,
												icon : 'x-message-box-warning'
											});
											me.store.load();
										}
									});

								} else {
									me.store.load();
								}

							});

				}
			}
		});
		this.plugins = [this.rowEditor], this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true,
			listeners : {
				"beforechange" : function(bbar) {
					var grid = bbar.ownerCt;
					var store = grid.getStore();
					Ext.apply(store.proxy.extraParams, {
								'rschacctno' : Ext
										.getCmp('updatebonusflag_searce')
										.getValue()
							});
				}
			}
		};

		this.callParent();
	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.UpdateBonusFlagStore');
	},
	searchRecord : function() {
		var me = this;
		var callstore = me.getStore();
		var mk = new Ext.LoadMask(document.body, {
					msg : '正在查詢，请稍候...'
				});
		if (Ext.isEmpty(Ext.util.Format.trim(Ext
				.getCmp('updatebonusflag_searce').getValue()))) {
			Ext.Msg.show({
						title : '功能描述',
						msg : '股金账号不能为空！',
						buttons : Ext.Msg.OK,
						icon : 'x-message-box-warning'
					});
		} else {
			mk.show();
			me.getStore().load({
				params : {
					rschacctno : Ext.getCmp('updatebonusflag_searce')
							.getValue(),
					page : 1,
					start : 0
				},
				callback : function(r, options, success) {
					if (success && r.length < 1) {
						var response = callstore.getProxy().getReader().rawData;
						Ext.Msg.show({
									title : '功能描述',
									msg : response.text + "！",
									buttons : Ext.Msg.OK,
									icon : 'x-message-box-warning'
								});
						mk.hide();
					} else {
						mk.hide();
					}
				}
			});

		};
	},
	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
					items : ['->', {
								xtype : 'textfield',
								fieldLabel : '股金账号',
								blankText : '请输入查询条件',
								labelWidth : 80,
								allowBlank : false,
								width : 400,
								id : 'updatebonusflag_searce'
							}, '-', {
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								id : 'updatebonusflag_searchButton',
								handler : me.searchRecord,
								scope : me
							}]
				});
	}
});
