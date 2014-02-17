console.log('BrcSignOutList...');
Ext.define('Fes.view.BrcSignOutList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.brcsignoutlist',
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
				text : '机构代码',
				width : 150,
				sortable : true,
				dataIndex : 'brccode'

			}, {
				text : '机构名称',
				width : 300,
				sortable : true,
				dataIndex : 'brcname'
			}, {
				text : '电话',
				flex : 1,
				sortable : true,
				dataIndex : 'phone'

			}, {
				text : '状态',
				flex : 1,
				sortable : true,
				dataIndex : 'status',
				renderer : function(v, m) {
					if (v == '4') {
						return '<span style="color:green;">' + "已签退"
								+ '</span>';
					} else if (v == '1') {
						return '<span style="color:red;">' + "未签到" + '</span>';
					} else {
						return '<span style="color:red;">' + "未签退" + '</span>';
					}

				}
			}],
	initComponent : function() {
		this.BRANCH_STATUSStore = Ext.create('Ext.data.Store', {
					fields : ['value', 'text'],
					data : pageVar.BRANCH_STATUSStore
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
								'brccode' : Ext.getCmp('signoutlist_brccode')
										.getValue()
							});
					Ext.apply(store.proxy.extraParams, {
								'status' : Ext.getCmp('signoutlist_brcstatus')
										.getValue()
							});
				}
			}
		};
		this.callParent();
	},

	createStore : function() {
		var me = this;
		this.store = Ext.create('Fes.store.BrcSignOutStore');
	},
	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
					items : ['->', {
								xtype : 'textfield',
								fieldLabel : '机构代码',
								labelWidth : 70,
								width : 400,
								id : 'signoutlist_brccode'
							}, '-', {
								fieldLabel : '签退状态',
								labelWidth : 70,
								Width : 100,
								id : 'signoutlist_brcstatus',
								store : this.BRANCH_STATUSStore,
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
											brccode : Ext
													.getCmp('signoutlist_brccode')
													.getValue(),
											status : Ext
													.getCmp('signoutlist_brcstatus')
													.getValue(),
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
pageVar.BRANCH_STATUSStore = eval("[{'value':'1', 'text':'已签退'},{'value':'0', 'text':'未签退'}]");