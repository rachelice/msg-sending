console.log('ActionlogList...');
Ext.define('Fes.view.UpdatelogList', {
	extend : 'Ext.grid.Panel',
	requires : ['Ext.ux.RowExpander'],
	alias : 'widget.updateloglist',
	title : '菜单列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	viewConfig : {
		loadingText : '正在加载列表'
	},
	plugins : [{
		ptype : 'rowexpander',
		selectRowOnExpand : true,
		rowBodyTpl : [
				'<p style=margin-left:70px;><span style=color:Teal;>更新表名</span><br><span>{table_name}</span></p>',
				'<p style=margin-left:70px;><span style=color:Teal;>Key字段名</span><br><span>{keys}</span></p>',
				'<p style=margin-left:70px;><span style=color:Teal;>Key值</span><br><span>{key_value}</span></p>',
				'<p style=margin-left:70px;><span style=color:Teal;>更新字段名</span><br><span>{columns}</span></p>',
				'<p style=margin-left:70px;><span style=color:Teal;>原值</span><br><span>{old_value}</span></p>',
				'<p style=margin-left:70px;><span style=color:Teal;>更新值</span><br><span style=color:red;>{new_value}</span></p>']
	}],
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
				width : 120,
				sortable : true,
				dataIndex : 'occurdate',
				renderer : Ext.util.Format.dateRenderer('Y-m-d H:i:s')
			}, {
				text : '操作用户',
				width : 100,
				sortable : true,
				dataIndex : 'user_id'

			}, {
				text : '更新表名',
				width : 100,
				sortable : true,
				dataIndex : 'table_name'
			}, {
				text : 'Key字段名',
				flex : 1,
				sortable : true,
				dataIndex : 'keys'

			}, {
				text : 'Key值',
				flex : 1,
				sortable : true,
				dataIndex : 'key_value'

			}, {
				text : '更新字段名',
				flex : 1,
				sortable : true,
				dataIndex : 'columns'

			}, {
				text : '原值',
				flex : 1,
				sortable : true,
				dataIndex : 'old_value',
				renderer : function(v, metadata, record, rowIndex, columnIndex,
						store) {
					metadata.attr = ' ext:qtip="' + v + '"';
					return v;
				}

			}, {
				text : '更新值',
				flex : 1,
				sortable : true,
				dataIndex : 'new_value'

			}],
	initComponent : function() {
		this.createStore();
		this.RESULT_PAGESIZEStore = Ext.create('Ext.data.Store', {
					fields : ['value', 'text'],
					data : pageVar.RESULT_PAGESIZEStore
				});
		this.tbar = this.createToolbar();

		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true,
			items : ['-', '&nbsp;&nbsp;', {
				id : 'bbarPagesize',
				store : this.RESULT_PAGESIZEStore,
				queryMode : 'local',
				displayField : 'text',
				valueField : 'value',
				xtype : 'combobox',
				value : '20',
				editable : false,
				width : 85,
				listeners : { // 为Combo添加select事件
					select : function(combo, record, index) { // 该事件会返回选中的项对应在
						// alert(combo.getValue());
						this.store.on('beforeload', function() {
									Ext.apply(store.proxy.baseParams, {
												'pageSize' : Ext
														.getCmp('bbarPagesize')
														.getValue()
											});
								})
					}
				}

			}],
			listeners : {
				"beforechange" : function(bbar) {
					var grid = bbar.ownerCt;
					var store = grid.getStore();
					Ext.apply(store.proxy.extraParams, {
								'userID' : Ext.getCmp('ulog_userID').getValue()
							});
					Ext.apply(store.proxy.extraParams, {
								'actions' : Ext.getCmp('ulog_actions')
										.getValue()
							});
					Ext.apply(store.proxy.extraParams, {
								'occurdates' : Ext.getCmp('ulog_occurdates')
										.getValue()
							});
					Ext.apply(store.proxy.extraParams, {
								'limit' : Ext.getCmp('bbarPagesize').getValue()
							});
				}
			}
		};
		this.callParent();
	},

	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.UpdatelogStore');
	},

	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
			items : [{
						xtype : 'textfield',
						fieldLabel : '操作名称',
						labelWidth : 70,
						flex : 1,
						id : 'ulog_actions'
					}, '-', {
						xtype : 'textfield',
						fieldLabel : '操作用户',
						labelWidth : 70,
						flex : 1,
						id : 'ulog_userID'
					}, '-', {
						xtype : 'datefield',
						fieldLabel : '操作时间',
						labelWidth : 70,
						format : 'Y-m-d',
						flex : 1,
						// value : new Date(),
						// editable : false,
						id : 'ulog_occurdates'

					}, '-', {
						xtype : 'button',
						text : '查询',
						iconCls : 'icon-search',
						handler : function() {
							me.getStore().load({
								params : {
									userID : Ext.getCmp('ulog_userID')
											.getValue(),
									actions : Ext.getCmp('ulog_actions')
											.getValue(),
									occurdates : Ext.getCmp('ulog_occurdates')
											.getValue(),
									page : 1,
									start : 0,
									limit : Ext.getCmp('bbarPagesize')
											.getValue()
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
									"更新日志");
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
pageVar.RESULT_PAGESIZEStore = eval("[{'value':'10', 'text':'10条/页'},{'value':'20', 'text':'20条/页'},{'value':'50', 'text':'50条/页'},{'value':'100', 'text':'100条/页'}]");

/*
 * var pagesize_combo = new Ext.form.ComboBox({ name : 'pagesize', hiddenName :
 * 'pagesize', typeAhead : true, triggerAction : 'all', lazyRender : true, mode :
 * 'local', store : new Ext.data.ArrayStore({ fields : ['value', 'text'], data :
 * [[10, '10条/页'], [20, '20条/页'], [50, '50条/页'], [100, '100条/页'], [250,
 * '250条/页'], [500, '500条/页']] }), valueField : 'value', displayField : 'text',
 * value : '20', editable : false, width : 85 }); var number =
 * parseInt(pagesize_combo.getValue()); // var store =
 * Ext.create('Fes.store.UpdatelogStore'); pagesize_combo.on("select",
 * function(comboBox) { number = parseInt(comboBox.getValue());
 * 
 * store.load({ params : { start : 0, limit : number } });
 * 
 * });
 */