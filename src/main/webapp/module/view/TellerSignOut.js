console.log('TellerSignOut...');
Ext.define('Fes.view.TellerSignOut', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.tellersignout',
	title : '菜单列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
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
								'tellercode' : Ext.getCmp('signout_tellercode')
										.getValue(),
								'workstate' : "0"
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
	
	tellerSignOut : function() {
		var me = this;
		var callstore = this.getStore();
		var records = this.getSelectionModel().getSelection();
		var length = records.length;
		var count = 0;
		if (length > 0) {
			Fes.MsgBox.confirm('确定签退这 ' + length + ' 个柜员？',
				function(btn) {
					Ext.each(records, function(record) {
						record.data.action = 'signout';
						record.save({
							success : function() {
								var response = callstore.getProxy().getReader().rawData;
				                if(response.success) {
				                	count++;
				                	if(count == length){
										Ext.Msg.show({  
											title: '柜员签退',  
											msg: "<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+response.text+"！", 
											buttons: Ext.Msg.OK,
											icon: 'x-message-box-ok'
										});
										me.getStore().load({
											params : {
												tellercode : Ext.getCmp('signout_tellercode').getValue(),
												workstate : "0",
												page : 1,
												start : 0
											}
										});
				                	}
				                }else{
				                	Ext.Msg.show({  
										title: '柜员签退',  
										msg: "<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签退失败！", 
										buttons: Ext.Msg.OK,
										icon: 'x-message-box-warning'
									});
				                }
							},
							failure : function(){
								Ext.Msg.show({  
									title: '柜员签退',  
									msg: "<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签退失败！", 
									buttons: Ext.Msg.OK,
									icon: 'x-message-box-warning'
								});
							}
						});
					});

				});
		} else {
			Ext.Msg.show({  
				title: '提示',  
				msg: "<br />&nbsp;&nbsp;&nbsp;至少选一条记录！", 
				buttons: Ext.Msg.INFO,
				icon: 'x-message-box-info'
			});
		}
	},
	
	tellerReset : function() {
		var me = this;
		var callstore = this.getStore();
		var records = this.getSelectionModel().getSelection();
		var length = records.length;
		var count = 0;
		if (length > 0) {
			Fes.MsgBox.confirm('确定重置这 ' + length + ' 个柜员？',
				function(btn) {
					Ext.each(records, function(record) {
						record.data.action = 'reset';
						record.save({
							success : function() {
								var response = callstore.getProxy().getReader().rawData;
				                if(response.success) {
				                	count++;
				                	if(count == length){
										Ext.Msg.show({  
											title: '柜员重置',  
											msg: "<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+response.text+"！", 
											buttons: Ext.Msg.OK,
											icon: 'x-message-box-ok'
										});
										me.getStore().load({
											params : {
												tellercode : Ext.getCmp('signout_tellercode').getValue(),
												workstate : "0",
												page : 1,
												start : 0
											}
										});
				                	}
				                }else{
				                	Ext.Msg.show({  
										title: '柜员重置',  
										msg: "<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;重置失败！", 
										buttons: Ext.Msg.OK,
										icon: 'x-message-box-warning'
									});
				                }
							},
							failure : function(){
								Ext.Msg.show({  
									title: '柜员重置',  
									msg: "<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;重置失败！", 
									buttons: Ext.Msg.OK,
									icon: 'x-message-box-warning'
								});
							}
						});
					});

				});
		} else {
			Ext.Msg.show({  
				title: '提示',  
				msg: "<br />&nbsp;&nbsp;&nbsp;至少选一条记录！", 
				buttons: Ext.Msg.INFO,
				icon: 'x-message-box-info'
			});
		}
	},
	
	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
			items : ['->', {
						xtype : 'textfield',
						fieldLabel : '柜员代码',
						labelWidth : 70,
						width : 400,
						id : 'signout_tellercode'
					}, '-', {
						xtype : 'button',
						text : '查询',
						iconCls : 'icon-search',
						handler : function() {
							me.getStore().load({
								params : {
									tellercode : Ext.getCmp('signout_tellercode').getValue(),
									workstate : "0",
									page : 1,
									start : 0
								}
							});
						}
					}, '-', {
						xtype : 'button',
						text : '签退',
						iconCls : 'icon-out',
						scope : me,
						handler : me.tellerSignOut
					}, '-', {
						xtype : 'button',
						text : '重置',
						iconCls : 'icon-reset',
						scope : me,
						handler : me.tellerReset
					}]
		});
	}
});