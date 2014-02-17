console.log('FundsSumList...');
Ext.define('Fes.view.FundsSumList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.fundssumlist',
	title : '客户信息列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
//	simpleSelect : true,
	allowDeselect : true,
	viewConfig : {
		loadingText : '正在加载客户信息列表'
	},
	columns : [{
				xtype : 'rownumberer'
			}, {
				text : '文件名',
				// flex : 1,
				width : 250,
				sortable : true,
				dataIndex : 'filename',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '文件大小',
				// flex : 1,
				width : 250,
				sortable : true,
				dataIndex : 'filesize',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '文件创建时间',
				flex : 1,
				sortable : true,
				dataIndex : 'filetime',
				renderer : Ext.util.Format.dateRenderer('Y-m-d H:i:s')
			}],
	listeners : {
		itemclick : function(view, record, item, index, e, eOpts) {
			var records = this.getSelectionModel().getSelection();
			if (records.length > 0) {
				Ext.getCmp('downloadButton').setDisabled(0);
				Ext.getCmp('sendmailButton').setDisabled(0);
			} else {
				Ext.getCmp('downloadButton').setDisabled(1);
				Ext.getCmp('sendmailButton').setDisabled(1);
			}
		}
	},
	initComponent : function() {
		this.createStore();
		this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			// store : this.store,
			displayInfo : true,
			doRefresh : function() {
				return false;
			}
		};

		this.callParent();
	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.FundsSumStore');
	},
	searchRecord : function() {
		Ext.getCmp('downloadButton').setDisabled(1);
		Ext.getCmp('sendmailButton').setDisabled(1);
		var me = this;
		var mk = new Ext.LoadMask(document.body, {
					msg : '正在查詢，请稍候...'
				});
		if (Ext.getCmp('sum_get_time').getValue() == null) {
			Ext.Msg.show({
						title : '存贷款取数',
						msg : '取数时间不能为空！',
						buttons : Ext.Msg.OK,
						icon : 'x-message-box-warning'
					});
		} else if (Ext.getCmp('sum_get_time').getValue() > new Date()) {
			Ext.Msg.show({
						title : '存贷款取数',
						msg : '取数时间不能晚于今天！',
						buttons : Ext.Msg.OK,
						icon : 'x-message-box-warning'
					});
		} else {
			mk.show();
			me.getStore().load({
						params : {
							get_time : Ext.getCmp('sum_get_time').getValue(),
							page : 1,
							start : 0
						}
					});

		};
		var callstore = me.store;
		me.store.on("load", function(callstore) {
					mk.hide();
					if (callstore.getCount() == 0) {
						Ext.Msg.show({
									title : '存贷款取数',
									msg : '所选取数时间文件不存在！',
									buttons : Ext.Msg.OK,
									icon : 'x-message-box-warning'
								});

					}
				});
	},
	commitJob : function() {
		Ext.Msg.show({
			title : '存贷款取数',
			msg : '是否提交手动存贷款取数操作？',
			buttons : Ext.Msg.YESNO,
			icon : 'x-message-box-question',

			fn : function(id) {
				var mk = new Ext.LoadMask(document.body, {
							msg : '正在提交操作，请稍候...'
						});
				mk.show();
				if (id == 'yes') {
					Ext.Ajax.request({
								url : 'fundssums/commitjob',// 要跳转的url,此为属性必须要有
								method : 'get',
								// params:{}, // 提交参数
								success : function(response, options) {
									var responseArray = Ext
											.decode(response.responseText);
									if (responseArray.success == true) {
										Ext.Msg.show({
													title : '存贷款取数',
													msg : responseArray.text,
													buttons : Ext.Msg.OK,
													icon : 'x-message-box-ok'
												});
									} else {
										Ext.Msg.show({
													title : '存贷款取数',
													msg : responseArray.text,
													buttons : Ext.Msg.OK,
													icon : 'x-message-box-warning'
												});
									}
									mk.hide();
								},

								failure : function(response, options) {
									mk.hide();
									Ext.Msg.alert('警告', "'数据处理错误原因\'"
													+ response.responseText);
								}

							});
				}
			}
		});
	},
	download : function() {
		var me = this;
		Ext.Msg.show({
			title : '存贷款取数',
			msg : '是否下载文件？',
			buttons : Ext.Msg.YESNO,
			icon : 'x-message-box-question',

			fn : function(id) {
				if (id == 'yes') {
					var mk = new Ext.LoadMask(document.body, {
								msg : '正在准备文件中，请稍候...'
							});
					mk.show();
					var filelist = me.getSelectionModel().getSelection();
					Ext.each(filelist, function(record) {
						Ext.Ajax.request({
									url : 'fundssums/download',// 要跳转的url,此为属性必须要有
									method : 'get',
									params : {
										filename : record.get('filename')

									}, // 提交参数
									success : function(response, options) {
										var responseArray = Ext
												.decode(response.responseText);
										if (responseArray.success == true) {
											window.location.href = responseArray.text;
										} else {
											Ext.Msg.show({
														title : '存贷款取数',
														msg : responseArray.text,
														buttons : Ext.Msg.OK,
														icon : 'x-message-box-warning'
													});
										}
										mk.hide();
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
	sendemail : function() {
		var me = this;
		// var filelist = me.getSelectionModel().getSelection();
		Ext.Msg.show({
			title : '存贷款取数',
			msg : '是否补寄文件？',
			buttons : Ext.Msg.YESNO,
			icon : 'x-message-box-question',

			fn : function(id) {
				if (id == 'yes') {
					var mk = new Ext.LoadMask(document.body, {
								msg : '正在发送邮件中，请稍候...'
							});
					mk.show();
					var filelist = me.getSelectionModel().getSelection();
					Ext.each(filelist, function(record) {
						Ext.Ajax.request({
									url : 'fundssums/sendmail',// 要跳转的url,此为属性必须要有
									method : 'get',
									params : {
										filename : record.get('filename')

									}, // 提交参数
									success : function(response, options) {
										var responseArray = Ext
												.decode(response.responseText);
										if (responseArray.success == true) {
											Ext.Msg.show({
														title : '存贷款取数',
														msg : responseArray.text,
														buttons : Ext.Msg.OK,
														icon : 'x-message-box-ok'
													});
										} else {
											Ext.Msg.show({
														title : '存贷款取数',
														msg : responseArray.text,
														buttons : Ext.Msg.OK,
														icon : 'x-message-box-warning'
													});
										}
										mk.hide();
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
	updatetrandate : function() {
		Ext.Msg.show({
			title : '存贷款取数',
			msg : '是否更新Transaction Date为明天？',
			buttons : Ext.Msg.YESNO,
			icon : 'x-message-box-question',

			fn : function(id) {
				var mk = new Ext.LoadMask(document.body, {
							msg : '正在提交操作，请稍候...'
						});
				mk.show();
				if (id == 'yes') {
					Ext.Ajax.request({
								url : 'fundssums/updatetrandate',// 要跳转的url,此为属性必须要有
								method : 'put',
								// params:{}, // 提交参数
								success : function(response, options) {
									var responseArray = Ext
											.decode(response.responseText);
									if (responseArray.success == true) {
										Ext.Msg.show({
													title : '存贷款取数',
													msg : responseArray.text,
													buttons : Ext.Msg.OK,
													icon : 'x-message-box-ok'
												});
									} else {
										Ext.Msg.show({
													title : '存贷款取数',
													msg : responseArray.text,
													buttons : Ext.Msg.OK,
													icon : 'x-message-box-warning'
												});
									}
									mk.hide();
								},

								failure : function(response, options) {
									mk.hide();
									Ext.Msg.alert('警告', "'数据处理错误原因\'"
													+ response.responseText);
								}

							});
				}
			}
		});
	},
	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
					items : ['->',{
								xtype : 'datefield',
								fieldLabel : '取数时间',
								format : 'Y-m-d',
								labelWidth : 65,
								Width : 80,
								editable : false,
								id : 'sum_get_time'
							}, '-', {
								xtype : 'button',
								text : '查询存贷款取数',
								iconCls : 'icon-search',
								handler : me.searchRecord,
								scope : me
							}, '-', {
								xtype : 'button',
								text : '提交存贷款取数',
								iconCls : 'icon-note',
								handler : me.commitJob,
								scope : me
							}, '-', {
								xtype : 'button',
								text : '下载',
								id : 'downloadButton',
								iconCls : 'icon-download',
								handler : me.download,
								disabled : true,
								scope : me
							}, '-', {
								xtype : 'button',
								text : '补寄',
								id : 'sendmailButton',
								iconCls : 'icon-email-list',
								handler : me.sendemail,
								disabled : true,
								scope : me
							}, '-', {
								xtype : 'button',
								text : '测试（更新日切日期）',
								id : 'updatetrandate',
								iconCls : 'icon-nav',
								handler : me.updatetrandate,
								scope : me
							}, '-']
				});
	}
});
