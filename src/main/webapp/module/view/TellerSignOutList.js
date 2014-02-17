console.log('TellerSignOutList...');
Ext.define('Fes.view.TellerSignOutList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.tellersignoutlist',
	title : '菜单列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
/*	multiSelect : true,
	simpleSelect : true,*/
	viewConfig : {
		loadingText : '正在加载列表'
	},
	columns : [{
				xtype : 'rownumberer',
				width : 40
			}, {
				text : '柜员代码',
				width : 150,
				sortable : true,
				dataIndex : 'tellercode'

			}, {
				text : '柜员名称',
				width: 200,
				sortable : true,
				dataIndex : 'tellername'
			}, {
				text : '机构代码',
				flex : 1,
				sortable : true,
				dataIndex : 'brccode'

			}, {
				text : '系统状态',
				flex : 1,
				sortable : true,
				dataIndex : 'status'

			}, {
				text : '工作状态',
				flex : 1,
				sortable : true,
				dataIndex : 'workstate',
				renderer : function(v, m) {
					if ( v == '5' ) {
						return '<span style="color:green;">' +"已签退" + '</span>';
					} else {
						return '<span style="color:red;">' +"未签退"+ '</span>';
					}

				}
			}],
	initComponent : function() {
		this.TELLER_WORKSTATEStore = Ext.create('Ext.data.Store', {
			fields : ['value', 'text'],
			data : pageVar.TELLER_WORKSTATEStore
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
						'tellercode' : Ext.getCmp('signoutlist_tellercode')
										.getValue()
							});
					Ext.apply(store.proxy.extraParams, {
						'workstate' : Ext.getCmp('signoutlist_tellerworkstate')
										.getValue()
					});
				}
			}
		};
		this.callParent();
	},

	createStore : function() {
		var me = this;
		this.store = Ext.create('Fes.store.TellerSignOutStore');
	},
	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
			items : ['->', {
						xtype : 'textfield',
						fieldLabel : '柜员代码',
						labelWidth : 70,
						width : 400,
						id : 'signoutlist_tellercode'
					}, '-',  {
						fieldLabel : '签退状态',
						labelWidth : 70,
						Width : 100,
						id : 'signoutlist_tellerworkstate',
						store : this.TELLER_WORKSTATEStore,
						queryMode : 'local',
						displayField : 'text',
						valueField : 'value',
						xtype : 'combobox',
						blankText : '请选择...',
						emptyText : "请选择..."
					}, '-',{
						xtype : 'button',
						text : '查询',
						iconCls : 'icon-search',
						handler : function() {
							me.getStore().load({
								params : {
									tellercode : Ext.getCmp('signoutlist_tellercode').getValue(),
									workstate : Ext.getCmp('signoutlist_tellerworkstate').getValue(),
									page : 1,
									start : 0
								}
							});
						}
					}]
		});
	}
});

var pageVar = {};
pageVar.TELLER_WORKSTATEStore = eval("[{'value':'1', 'text':'已签退'},{'value':'0', 'text':'未签退'}]");