console.log('CleanUpAccountList...');
Ext.define('Fes.view.CleanUpAccountList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.cleanupaccountlist',
	title : '信息列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	simpleSelect : true,
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
				text : '股金户名',
				flex : 1,
				sortable : true,
				dataIndex : 'custname'
			}, {
				text : '己关联结算账号',
				flex : 1,
				sortable : true,
				dataIndex : 'stlacctno',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '入账标志',
				flex : 1,
				sortable : true,
				dataIndex : 'stat'
			}],
	listeners : {
		itemclick : function(view, record, item, index, e, eOpts) {
			var records = this.getSelectionModel().getSelection();
			if (records.length > 0) {
				Ext.each(records, function(record) {
							if (!Ext.isEmpty(Ext.util.Format.trim(record
									.get('stlacctno')))) {
								Ext.getCmp('cleanupacct').setDisabled(0);
							} else {
								Ext.getCmp('cleanupacct').setDisabled(1);
							}
						});

			} else {
				Ext.getCmp('cleanupacct').setDisabled(1);
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
								'rschacctno' : Ext
										.getCmp('cleanupaccount_rschacctno')
										.getValue()
							});
					Ext.getCmp('cleanupacct').setDisabled(1);
				}
			}
		};

		this.callParent();
	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.CleanUpAccountStore');
	},
	searchRecord : function() {
		Ext.getCmp('cleanupacct').setDisabled(1);
		var me = this;
		var callstore = me.getStore();
		var mk = new Ext.LoadMask(document.body, {
					msg : '正在查詢，请稍候...'
				});
		if (Ext.isEmpty(Ext.util.Format.trim(Ext
				.getCmp('cleanupaccount_rschacctno').getValue()))) {
			Ext.Msg.show({
						title : '清除股金关联结算账号',
						msg : '股金结算账号不能为空！',
						buttons : Ext.Msg.OK,
						icon : 'x-message-box-warning'
					});
		} else {
			mk.show();
			me.getStore().load({
				params : {
					rschacctno : Ext.getCmp('cleanupaccount_rschacctno').getValue(),
					page : 1,
					start : 0
				},
				callback : function(r, options, success) {
					if (success && r.length != 1) {
						var response = callstore.getProxy().getReader().rawData;
						Ext.Msg.show({
									title : '清除股金关联结算账号',
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
	cleanup : function() {
		var me = this;
		Ext.Msg.show({
			title : '清除股金关联结算账号',
			msg : '是否清除股金关联结算账号？',
			buttons : Ext.Msg.YESNO,
			icon : 'x-message-box-question',

			fn : function(id) {
				if (id == 'yes') {
					var mk = new Ext.LoadMask(document.body, {
								msg : '正在清除股金关联结算账号，请稍候...'
							});
					mk.show();
					var acctlist = me.getSelectionModel().getSelection();
					Ext.each(acctlist, function(record) {
						Ext.Ajax.request({
									url : 'cleanupaccounts/cleanup',// 要跳转的url,此为属性必须要有
									method : 'get',
									params : {
										acctno : record.get('acctno')
									},
									success : function(response, options) {
										var responseArray = Ext
												.decode(response.responseText);
										if (responseArray.success == true) {
											Ext.Msg.show({
														title : '清除股金关联结算账号',
														msg : responseArray.text,
														buttons : Ext.Msg.OK,
														icon : 'x-message-box-ok'
													});

										} else {
											Ext.Msg.show({
														title : '清除股金关联结算账号',
														msg : responseArray.text,
														buttons : Ext.Msg.OK,
														icon : 'x-message-box-warning'
													});
										}
										mk.hide();
										Ext.apply(me.store.proxy.extraParams, {
													'rschacctno' : record
															.get('acctno')
												});
										Ext.getCmp('cleanupacct')
												.setDisabled(1);
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
								fieldLabel : '股金账号',
								blankText : '请输入查询条件',
								labelWidth : 80,
								allowBlank : false,
								width : 400,
								id : 'cleanupaccount_rschacctno'
							}, '-', {
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : me.searchRecord,
								scope : me
							}, '-', {
								xtype : 'button',
								text : '清除关联结算账号',
								id : 'cleanupacct',
								iconCls : 'icon-del',
								handler : me.cleanup,
								disabled : true,
								scope : me
							}]
				});
	}
});
