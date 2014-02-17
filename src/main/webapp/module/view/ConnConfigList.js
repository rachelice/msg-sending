console.log('ConnConfigList...');
Ext.define('Fes.view.ConnConfigList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.connconfiglist',
	title : '终端连接设置',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
//	simpleSelect : true,
	id : 'connconfiglist',
	allowDeselect : true,

	viewConfig : {
		loadingText : '正在加载列表'
	},
	columns : [{
				xtype : 'rownumberer'
			}, {
				text : '链接类型',
				width : 60,
				sortable : true,
				dataIndex : 'type',
				field : {
					xtype : 'textfield',
					required : true
				}
			}, {
				text : 'IP地址',
				width : 150,
				sortable : true,
				dataIndex : 'ipaddress',
				field : {
					xtype : 'textfield',
					required : true
				}

			}, {
				text : '登陆账户',
				width : 150,
				sortable : true,
				dataIndex : 'account',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '登陆密码',
				width : 150,
				sortable : true,
				dataIndex : 'password',
				inputType : 'password',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '核心参数（命令、收件人等）',
				width : 150,
				sortable : true,
				dataIndex : 'commands',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '其他参数',
				width : 200,
				sortable : true,
				dataIndex : 'parameters',
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

	// store : [Ext.create('Fes.system.role.Store')],
	initComponent : function() {

		this.createStore();
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
			listeners : {
				edit : function(editor, e) {

					if (e.originalValues.ipaddress != e.record.data.ipaddress) {
						e.record.data.ipaddresschg = true;
					};
					if (e.originalValues.account != e.record.data.account) {
						e.record.data.accountchg = true;
					};
					if (e.originalValues.password != e.record.data.password) {
						e.record.data.passwordchg = true;
					};

					e.record.save({
								success : function(connaddr, options) {
									var data = Ext
											.decode(options.response.responseText);
									if (data.extra) {
										connaddr.set('id', data.extra);
									}
									connaddr.commit();
									this.store.load();
								}
							});

				}
			}
		});
		this.plugins = [this.rowEditor], this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			title : 'test',
			displayInfo : true
		};
		this.callParent();
	},

	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.ConnaddrStore');
	},

	addRecord : function() {
		var record = new Fes.model.ConnaddrModel({
					name : '新建连接'
				});
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '条记录?',
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
			items : ['-',

					Ext.create('Ext.Button', {
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
					}, '-', {
						xtype : 'button',
						text : '上传',
						iconCls : 'icon-upload',
						scope : me,
						handler : function() {
							win_upload.show();
						}
					}, '-', {
						xtype : 'button',
						text : '导出',
						iconCls : 'icon-download',
						scope : me,
						handler : function() {
							var vExportContent = getExcelUrl.getExcelUrl(me,
									"链接设置");
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

var form = new Ext.form.FormPanel({
			labelWidth : 60,
			labelHeight : 150,
			fileUpload : true,
			defaultType : 'textfield',
			width : 400,
			bodyPadding : 15,
			frame : true,
			layout : "form",
			items : [{
						xtype : 'filefield',
						name : 'userfile',
						id : 'userfile',
						width : 300,
						fieldLabel : '文件',
						labelWidth : 50,
						msgTarget : 'side',
						allowBlank : false,
						blankText : '请选择上传的文件！',
						// regex : '^.+\\.(?i)((xls)|(xlsx))$',
						anchor : '95%',
						buttonText : '请选择...'
					}]
		});

var win_upload = new Ext.Window({
	title : '文件上传',
	width : 450,
	height : 180,
	// modal : true,
	// constrain:true,
	/*
	 * x : 100, y : 50,
	 */
	layout : 'form',
	autoScroll : false,
	bodyStyle : 'padding:10px 10px 10px 10px;',
	html : '&nbsp&nbsp<font color="red">*只允许上载文件格式为Excel且文件大小小于10M的文件！</font>',
	items : form,
	buttons : [{
				text : '确认上传',
				handler : function() {
					if (form.form.isValid()) {
						/*
						 * if(Ext.getCmp('userfile').getValue() == ''){
						 * Ext.Msg.alert('温馨提示','请选择要上传的文件'); return; }
						 */
						/*
						 * Ext.MessageBox.show({ title : '稍后....', msg :
						 * '文件正在上传中....', progressText : '', width : 300,
						 * progress : true, closable : false, animEl : 'loding'
						 * });
						 */
						form.getForm().submit({
									url : 'fileupload/connconfig',
									params : {
										id : 12
									},
									waitMsg : '正在上传文件...',
									success : function(form, action) {
										// alert(action.response.responseText);
										Ext.Msg.show({
													title : '文件上传',
													// msg : '文件上传成功！',
													msg : action.result.msg,
													buttons : Ext.Msg.OK,
													icon : 'x-message-box-ok'
												});
										win_upload.hide();
									},
									failure : function(form, action) {
										Ext.Msg.show({
													title : '文件上传',
													// msg :
													// '1.文件格式必须是Excel;</br>2.且文件大小必须小于10M;',
													msg : action.result.msg,
													buttons : Ext.Msg.OK,
													icon : 'x-message-box-warning'
												});
									}
								});
					}
				}
			}, {
				text : '取消',
				handler : function() {
					win_upload.hide();
				}
			}],
	closable : false,
	// draggable: false,
	resizable : false
});