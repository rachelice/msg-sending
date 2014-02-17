console.log('HistoryErrorlogList...');
Ext.require(['Fes.util.TerminalCombox']);
Ext.define('Fes.view.HistoryErrorlogList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.monitorhistorylist',
	title : '异常信息列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
//	multiSelect : true,
//	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载异常信息列表'
	},
	columns : [{
				xtype : 'rownumberer'
			}, {
				text : '终端系统',
				width : 150,
				sortable : true,
				dataIndex : 'terminal',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '发生时间',
				width : 150,
				sortable : true,
				dataIndex : 'occurdate',
				renderer : Ext.util.Format.dateRenderer('Y-m-d H:i:s')
			}, {
				text : '响应用户',
				width : 80,
				sortable : true,
				dataIndex : 'user_id',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '响应时间',
				width : 150,
				sortable : true,
				dataIndex : 'responsedate',
				renderer : Ext.util.Format.dateRenderer('Y-m-d H:i:s')
			}, {
				text : '异常信息描述',
				flex : 1,
				sortable : true,
				dataIndex : 'description',
				field : {
					xtype : 'textarea'
				}
			}],
	listeners : {
		hide : function(panel, o) {

		},
		itemdblclick : function(view, record, item, index, e, eOpts) {

			var info = '异常终端：'
					+ record.data.terminal
					+ '<br>'
					+ '<br>'
					+ '异常时间：'
					+ Ext.util.Format
							.date(record.data.occurdate, 'Y-m-d H:i:s');
			info += '<br>异常信息：<lable   style="width:10;overflow-x:visible;overflow-y:visible;"><br>'
					+ '&nbsp&nbsp&nbsp&nbsp'
					+ record.data.description
					+ '</label>';

			//	win.show();
			Ext.MessageBox.show({
						title : '异常信息详细情况',
						msg : info,
						width : 400,
						closable : false,
						icon : 'x-message-box-warning',
						buttons : Ext.MessageBox.OK,

						fn : function() {
							console.log('record1=' + Ext.encode(record.data));
						}

					});
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
								'monitor_terminal' : Ext
										.getCmp('monitor_terminal')
										.getTerminalValue()
							});
					Ext.apply(store.proxy.extraParams, {
								'monitor_starttime' : Ext
										.getCmp('monitor_starttime').getValue()
							});
					Ext.apply(store.proxy.extraParams, {
								'monitor_endtime' : Ext
										.getCmp('monitor_endtime').getValue()
							});
				}
			}
		};
		this.callParent();
	},
	showWin : function() {
		this.win.show();
	},
	hideWin : function() {
		this.win.hide();
	},
	createStore : function() {
		var me = this;
		this.store = Ext.create('Fes.store.HistoryErrorlogStore');
	},

	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
			items : [{
						xtype : 'terminalCombox',
						fieldLabel : '终端系统',
						labelWidth : 65,
						flex : 1,
						id : 'monitor_terminal'
					}, '-', {
						xtype : 'datefield',
						fieldLabel : '开始时间',
						format : 'Y-m-d',
						labelWidth : 65,
						flex : 1,
						id : 'monitor_starttime'
					}, '-', {
						xtype : 'datefield',
						fieldLabel : '结束时间',
						format : 'Y-m-d',
						labelWidth : 65,
						flex : 1,
						id : 'monitor_endtime'
					}, '-', {
						xtype : 'button',
						text : '查询',
						iconCls : 'icon-search',
						handler : function() {
							me.getStore().load({
								params : {
									terminal : Ext.getCmp('monitor_terminal')
											.getTerminalValue(),
									starttime : Ext.getCmp('monitor_starttime')
											.getValue(),
									endtime : Ext.getCmp('monitor_endtime')
											.getValue(),
									page : 1,
									start : 0
								}
							});
						}
					}, '-', {
						xtype : 'button',
						text : '导出',
						iconCls : 'icon-download',
						handler : function() {
							Ext.Msg.confirm('操作提示', '您确定要导出数据?',
									function(btn) {
										if ('yes' == btn) {
											var mk = new Ext.LoadMask(document.body, {  
                                        		msg: '正在准备数据中，请稍候...'
                                        	});
                                        	mk.show();
											Ext.Ajax.request({
												method : 'GET',
												url : 'historyerrorlogs/exports',
												params : {
													terminal : Ext
															.getCmp('monitor_terminal')
															.getTerminalValue(),
													starttime : Ext
															.getCmp('monitor_starttime')
															.getValue(),
													endtime : Ext
															.getCmp('monitor_endtime')
															.getValue()
												},
												success : function(response,
														options) {
													var rtn = Ext
															.decode(response.responseText);
													if (rtn.success) {
														window.location.href = Ext.appPath
																+ rtn.text;
													} else {
														Ext.Msg.show({
															title : '导出数据',
															msg : rtn.text,
															buttons : Ext.Msg.OK,
															icon : 'x-message-box-error'
														});
													}
													mk.hide();
												},
												failure : function(response,
														options) {
													mk.hide();
												},
												scope : this
											});
										}
									});
						}
					}]
		});
	}
});