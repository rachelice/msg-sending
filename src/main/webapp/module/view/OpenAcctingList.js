Ext.define('Fes.view.OpenAcctingList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.openacctlist',
	title : '客户信息列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	simpleSelect : true,
	allowDeselect : true,
	viewConfig : {
		loadingText : '正在加载客户信息列表'
	},
	columns : [{
				xtype : 'rownumberer'
			}, {
				text : '账号',
				flex : 1,
				sortable : true,
				dataIndex : 'acctno'

			}, {
				text : '账类',
				flex : 1,
				sortable : true,
				dataIndex : 'acckind',
				renderer : function(v, m) {
					if (v == '0') {
						return v + ' - ' + '表外';
					}
					if (v == '1') {
						return v + ' - ' + '存款';
					}
					if (v == '2') {
						return v + ' - ' + '贷款';
					}
					if (v == '3') {
						return v + ' - ' + '内部';
					}
					if (v == '4') {
						return v + ' - ' + '拨款';
					}
					if (v == '5') {
						return v + ' - ' + '销账';
					}
					if (v == '6') {
						return v + ' - ' + '固定资产';
					}
					if (v == '7') {
						return v + ' - ' + '现金';
					}
				}

			}, {
				text : '账页种类',
				flex : 1,
				sortable : true,
				dataIndex : 'accpagetype',
				renderer : function(v, m) {
					if (v == '3') {
						return v + ' - ' + '内部';
					}
					if (v == '5') {
						return v + ' - ' + '销账';
					}
					return v + '-' + '其他';
				}
			}, {
				text : '传票记账控制标志',
				flex : 1,
				sortable : true,
				dataIndex : 'accctrlflag',
				renderer : function(v, metadata, record, rowIndex, columnIndex,
						store) {
					if (v == '1' && record.get('acckind') != '5') {
						return v + ' - ' + '允许（只能关闭）';
					} else if (v == '1') {
						return v + ' - ' + '允许（只能打开）';
					} else {
						return v + ' - ' + '不允许（只能打开）';
					}
					/*
					 * if (v == '0' || (v == '1' && record.get('acckind') ==
					 * '5')) { alert(record.get('acckind')); return v + ' - ' +
					 * '不允许（只能打开）'; }
					 */
					return v + ' - ' + '其他';
				}
			}],
	listeners : {
		itemclick : function(view, record, item, index, e, eOpts) {
			var records = this.getSelectionModel().getSelection();
			if (records.length > 0) {
				Ext.each(records, function(record) {
							if (record.get('accctrlflag') == '0'
									|| (record.get('accctrlflag') == '1' && record
											.get('acckind') == '5')) {
								Ext.getCmp('openaccting').setDisabled(0);
							} else {
								Ext.getCmp('closeaccting').setDisabled(0);
							}
						});

			} else {
				Ext.getCmp('openaccting').setDisabled(1);
				Ext.getCmp('closeaccting').setDisabled(1);
			}
		}
	},
	initComponent : function() {
		this.createStore();
		this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true,
			listeners : {
				"beforechange" : function(bbar) {
					var grid = bbar.ownerCt;
					var store = grid.getStore();
					Ext.apply(store.proxy.extraParams, {
								'rschacctno' : Ext.getCmp('openacct_rschacctno')
										.getValue()
							});
				Ext.getCmp('openaccting').setDisabled(1);
				Ext.getCmp('closeaccting').setDisabled(1);
				}
			}
		};

		this.callParent();
	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.OpenAcctingStore');
	},
	searchRecord : function() {
		Ext.getCmp('openaccting').setDisabled(1);
		Ext.getCmp('closeaccting').setDisabled(1);
		var me = this;
		var callstore = me.getStore();
		var mk = new Ext.LoadMask(document.body, {
					msg : '正在查詢，请稍候...'
				});
		if (Ext.isEmpty(Ext.util.Format.trim(Ext.getCmp('openacct_rschacctno')
				.getValue()))) {
			Ext.Msg.show({
						title : '打开手动记账',
						msg : '账号不能为空！',
						buttons : Ext.Msg.OK,
						icon : 'x-message-box-warning'
					});
		} else {
			mk.show();
			me.getStore().load({
				params : {
					rschacctno : Ext.getCmp('openacct_rschacctno').getValue(),
					page : 1,
					start : 0
				},
				callback : function(r, options, success) {
					/*
					 * if (r.length != 1) { Ext.Msg.show({ title : '打开手动记账', msg :
					 * '账户信息不存在，或多于一条；<br>请确认账号是否正确！', buttons : Ext.Msg.OK,
					 * icon : 'x-message-box-warning' }); mk.hide(); }
					 */
					if (success && r.length != 1) {
						var response = callstore.getProxy().getReader().rawData;
						Ext.Msg.show({
									title : '打开手动记账',
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
	openacct : function() {
		var me = this;
		Ext.Msg.show({
			title : '打开手动记账',
			msg : '是否打开手动记账？',
			buttons : Ext.Msg.YESNO,
			icon : 'x-message-box-question',

			fn : function(id) {
				if (id == 'yes') {
					var mk = new Ext.LoadMask(document.body, {
								msg : '正在打开手动记账，请稍候...'
							});
					mk.show();
					var acctlist = me.getSelectionModel().getSelection();
					Ext.each(acctlist, function(record) {
						Ext.Ajax.request({
									url : 'openaccting/openacct',// 要跳转的url,此为属性必须要有
									method : 'get',
									params : {
										acctno : record.get('acctno'),
										acckind : record.get('acckind'),
										accpagetype : record.get('accpagetype'),
										accctrlflag : record.get('accctrlflag')
									},
									success : function(response, options) {
										var responseArray = Ext
												.decode(response.responseText);
										if (responseArray.success == true) {
											Ext.Msg.show({
														title : '打开手动记账',
														msg : responseArray.text,
														buttons : Ext.Msg.OK,
														icon : 'x-message-box-ok'
													});

										} else {
											Ext.Msg.show({
														title : '打开手动记账',
														msg : responseArray.text,
														buttons : Ext.Msg.OK,
														icon : 'x-message-box-warning'
													});
										}
										mk.hide();
										Ext.apply(me.store.proxy.extraParams, {
													'rschacctno' : Ext
															.getCmp('openacct_rschacctno')
															.getValue()
												});
										Ext.getCmp('closeaccting').setDisabled(1);		
										Ext.getCmp('openaccting').setDisabled(1);												
										me.store.load();
									},

									failure : function(response, options) {
										mk.hide();
										Ext.Msg
												.alert(
														'警告',
														"'数据处理错误原因\'"
																+ response.responseText);
									}

								});
					});
				}
			}
		});
	},
	closeacct : function() {
		var me = this;
		Ext.Msg.show({
			title : '打开手动记账',
			msg : '是否关闭手动记账？',
			buttons : Ext.Msg.YESNO,
			icon : 'x-message-box-question',

			fn : function(id) {
				if (id == 'yes') {
					var mk = new Ext.LoadMask(document.body, {
								msg : '正在关闭手动记账，请稍候...'
							});
					mk.show();
					var acctlist = me.getSelectionModel().getSelection();
					Ext.each(acctlist, function(record) {
						Ext.Ajax.request({
									url : 'openaccting/closeacct',// 要跳转的url,此为属性必须要有
									method : 'get',
									params : {
										acctno : record.get('acctno'),
										acckind : record.get('acckind'),
										accpagetype : record.get('accpagetype'),
										accctrlflag : record.get('accctrlflag')

									}, // 提交参数
									success : function(response, options) {
										var responseArray = Ext
												.decode(response.responseText);
										if (responseArray.success == true) {
											Ext.Msg.show({
														title : '打开手动记账',
														msg : responseArray.text,
														buttons : Ext.Msg.OK,
														icon : 'x-message-box-ok'
													});

										} else {
											Ext.Msg.show({
														title : '打开手动记账',
														msg : responseArray.text,
														buttons : Ext.Msg.OK,
														icon : 'x-message-box-warning'
													});
										}
										mk.hide();
										Ext.apply(me.store.proxy.extraParams, {
													'rschacctno' : Ext
															.getCmp('openacct_rschacctno')
															.getValue()
												});
										Ext.getCmp('closeaccting').setDisabled(1);		
										Ext.getCmp('openaccting').setDisabled(1);
										me.store.load();
									},

									failure : function(response, options) {
										mk.hide();
										Ext.Msg
												.alert(
														'警告',
														"'数据处理错误原因\'"
																+ response.responseText);
									}

								});
					});
				}
			}
		});
	},
	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
					items : ['->', {
								xtype : 'textfield',
								fieldLabel : '账号',
								blankText : '请输入账号',
								labelWidth : 40,
								allowBlank : false,
								width : 400,
								id : 'openacct_rschacctno'
							}, '-', {
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : me.searchRecord,
								scope : me
							}, '-', {
								xtype : 'button',
								text : '打开',
								id : 'openaccting',
								iconCls : 'icon-ok',
								handler : me.openacct,
								disabled : true,
								scope : me
							}, '-', {
								xtype : 'button',
								text : '关闭',
								id : 'closeaccting',
								iconCls : 'icon-tip',
								handler : me.closeacct,
								disabled : true,
								scope : me
							}, '-']
				});
	}
});
