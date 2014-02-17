console.log('ActionlogList...');
Ext.define('Fes.view.ActionlogList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.actionloglist',
	title : '菜单列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	viewConfig : {
		loadingText : '正在加载列表'
	},
	columns : [{
				xtype : 'rownumberer',
				width : 40
			}, {
				text : '操作名称',
				width : 200,
				sortable : true,
				dataIndex : 'action'

			}, {
				text : '操作时间',
				width : 200,
				sortable : true,
				dataIndex : 'occurdate',
				renderer : Ext.util.Format.dateRenderer('Y-m-d H:i:s')
			}, {
				text : '操作用户',
				width : 150,
				sortable : true,
				dataIndex : 'user_id'

			}, {
				text : '操作结果',
				width : 100,
				sortable : true,
				dataIndex : 'status',
				renderer : function(v, m) {
					if (v == "F") {
						return '<span style="color:red;">' +"失败 ("+ v +")" + '</span>';
					} else {
						return '<span style="color:green;">' +"成功 ("+ v +")"+ '</span>';
					}

				}

			}, {
				text : '备注',
				flex : 1,
				sortable : true,
				dataIndex : 'comments'

			}],
	initComponent : function() {
		this.RESULT_STATUSStore = Ext.create('Ext.data.Store', {
					fields : ['value', 'text'],
					data : pageVar.RESULT_STATUSStore
				});
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
								'userID' : Ext.getCmp('userID')
										.getValue()
							});
					Ext.apply(store.proxy.extraParams, {
								'actions' : Ext.getCmp('actions').getValue()
							});
					Ext.apply(store.proxy.extraParams, {
								'result' : Ext.getCmp('result').getValue()
							});
					Ext.apply(store.proxy.extraParams, {
								'occurdates' : Ext.getCmp('occurdates').getValue()
							});
				}
			}
		};
		this.callParent();
	},
	/*	
	 viewConfig : {
	 forceFit : true,
	 getRowClass : function(record, rowIndex, rowParams, store) {
	 // 禁用数据显示红色
	 if (record.data.status == "失败") {
	 return 'x-grid-record-red';
	 } else {
	 return '';
	 }
	 }
	 },
	 */
	createStore : function() {
		var me = this;
		this.store = Ext.create('Fes.store.ActionlogStore');
	},
	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
			items : [{
						xtype : 'textfield',
						fieldLabel : '操作名称',
						labelWidth : 70,
						flex : 1,
						id : 'actions'
					}, '-', {
						xtype : 'textfield',
						fieldLabel : '操作用户',
						labelWidth : 70,
						flex : 1,
						id : 'userID'
					}, '-', {
						xtype : 'datefield',
						fieldLabel : '操作时间',
						labelWidth : 70,
						format : 'Y-m-d',
						flex : 1,
						value : new Date(),
						//						editable : false,
						id : 'occurdates'

					}, '-', {
						fieldLabel : '操作结果',
						labelWidth : 70,
						Width : 100,
						id : 'result',
						//						editable : false,
						store : this.RESULT_STATUSStore,
						queryMode : 'local',
						displayField : 'text',
						valueField : 'value',
						xtype : 'combobox',
						blankText : '请选择...',
						emptyText : "请选择..."

					}, '-', {
						xtype : 'button',
						text : '查询',
						iconCls : 'icon-search',
						handler : function() {
							me.getStore().load({
								params : {
									userID : Ext.getCmp('userID').getValue(),
									actions : Ext.getCmp('actions').getValue(),
									result : Ext.getCmp('result').getValue(),
									occurdates : Ext.getCmp('occurdates')
											.getValue(),
									page : 1,
									start : 0
								}
							})
						}
					}, '-', {
						xtype : 'button',
						text : '导出',
						iconCls : 'icon-download',
						scope : me,
						handler : function() {
							var vExportContent = getExcelUrl.getExcelUrl(me,
									"操作日志");
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

var pageVar = {};
pageVar.RESULT_STATUSStore = eval("[{'value':'S', 'text':'成功'},{'value':'F', 'text':'失败'}]");