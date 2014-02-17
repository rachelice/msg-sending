Ext.define('Fes.view.UpdateAccepInfo', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.updateaccepinfo',
	title : '菜单列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	allowDeselect : true,
	/* selType : 'cellmodel', */
	viewConfig : {
		loadingText : '正在加载列表'
	},
	columns : [{
				xtype : 'rownumberer'
			}, {
				text : '账号',
				width : 170,
				sortable : false,
				dataIndex : 'acctno'
			}, {
				text : '开户日期',
				width : 100,
				sortable : false,
				dataIndex : 'opendate',
				format : 'Y-m-d',
				// renderer : Ext.util.Format.dateRenderer('Y-m-d'),
				renderer : function(v, m) {
					if (v.indexOf('-') != 4) {
						return Ext.Date.format(new Date(v), 'Y-m-d');
					} else {
						return v;
					}
				},
				field : {
					xtype : 'datefield',
					format : 'Y-m-d'
				}
			}, {
				text : '还款卡号',
				width : 170,
				sortable : false,
				dataIndex : 'diacct',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '折号，还款账号',
				width : 170,
				sortable : false,
				dataIndex : 'dbacct',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '贴息标志',
				width : 80,
				sortable : false,
				dataIndex : 'discountflag',
				renderer : function(v, m) {
					if (v == '0') {
						return v + ' - ' + '否';
					}
					if (v == '1') {
						return v + ' - ' + '是';
					}
					return v + ' - ' + '其他';
				},
				field : {
					store : Ext.create('Ext.data.Store', {
						fields : ['value', 'text'],
						data : eval("[{'value':'0', 'text':'0 - 否'},{'value':'1', 'text':'1 - 是'}]")
					}),
					queryMode : 'local',
					displayField : 'text',
					valueField : 'value',
					xtype : 'combobox',
					triggerAction : 'all',
					editable : false,
					blankText : '请选择...',
					emptyText : "请选择..."

				}
			}, {
				text : '非应计标志',
				width : 100,
				sortable : false,
				dataIndex : 'noaccrualflag',
				renderer : function(v, m) {
					if (v == '0') {
						return v + ' - ' + '应计贷款';
					}
					if (v == '1') {
						return v + ' - ' + '非应计贷款';
					}
					return v + ' - ' + '其他';
				},
				field : {
					store : Ext.create('Ext.data.Store', {
						fields : ['value', 'text'],
						data : eval("[{'value':'0', 'text':'0 - 应计贷款'},{'value':'1', 'text':'1 - 非应计贷款'}]")
					}),
					queryMode : 'local',
					displayField : 'text',
					valueField : 'value',
					xtype : 'combobox',
					triggerAction : 'all',
					editable : false,
					blankText : '请选择...',
					emptyText : "请选择..."

				}
			}, {
				text : '当前到期日',
				width : 100,
				sortable : false,
				dataIndex : 'currduedate',
				renderer : function(v, m) {
					if (v.indexOf('-') != 4) {
						return Ext.Date.format(new Date(v), 'Y-m-d');
					} else {
						return v;
					}
				},
				field : {
					xtype : 'datefield',
					editable : false,
					format : 'Y-m-d'
				}
			}, {
				text : '贷款种类',
				flex : 1,
				sortable : false,
				dataIndex : 'loantype1',
				renderer : function(v, m) {
					if (v == '1') {
						return v + ' - ' + '普通';
					}
					if (v == '2') {
						return v + ' - ' + '按揭';
					}
					return v + ' - ' + '其他';
				},
				field : {
					store : Ext.create('Ext.data.Store', {
						fields : ['value', 'text'],
						data : eval("[{'value':'1', 'text':'1 - 普通'},{'value':'2', 'text':'2 - 按揭'}]")
					}),
					queryMode : 'local',
					displayField : 'text',
					valueField : 'value',
					xtype : 'combobox',
					triggerAction : 'all',
					editable : false,
					blankText : '请选择...',
					emptyText : "请选择..."

				}
			}, {
				text : '贷款状态',
				flex : 1,
				sortable : false,
				dataIndex : 'loanstat',
				renderer : function(v, m) {
					if (v == '01') {
						return v + ' - ' + '正常';
					}
					if (v == '02') {
						return v + ' - ' + '展期';
					}
					if (v == '04') {
						return v + ' - ' + '逾期';
					}
					if (v == '05') {
						return v + ' - ' + '呆滞';
					}
					if (v == '06') {
						return v + ' - ' + '呆账';
					}
					if (v == '07') {
						return v + ' - ' + '核销';
					}
					if (v == '08') {
						return v + ' - ' + '销户';
					}
					if (v == '12') {
						return v + ' - ' + '部分展期';
					}
					if (v == '14') {
						return v + ' - ' + '部分逾期';
					}
					if (v == '15') {
						return v + ' - ' + '部分呆滞';
					}
					if (v == '16') {
						return v + ' - ' + '部分呆帐';
					}
					if (v == '17') {
						return v + ' - ' + '部分核销';
					}
					if (v == '24') {
						return v + ' - ' + '逾期置换';
					}
					if (v == '25') {
						return v + ' - ' + '呆滞置换';
					}
					if (v == '26') {
						return v + ' - ' + '呆帐置换';
					}
					if (v == '27') {
						return v + ' - ' + '兑付';
					}
					return v + ' - ' + '其他';
				},
				field : {
					store : Ext.create('Ext.data.Store', {
						fields : ['value', 'text'],
						data : eval("[{'value':'01', 'text':'01 - 正常'},{'value':'04', 'text':'04 - 逾期'},{'value':'08', 'text':'08 - 销户'}]")
					}),
					queryMode : 'local',
					displayField : 'text',
					valueField : 'value',
					xtype : 'combobox',
					triggerAction : 'all',
					editable : false,
					blankText : '请选择...',
					emptyText : "请选择..."

				}
			}, {
				text : '基准利率',
				flex : 1,
				sortable : false,
				dataIndex : 'intrestres1',
				xtype : 'numbercolumn',
				renderer : Ext.util.Format.number('0.000000'),
				field : {
					xtype : 'numberfield',
					maxValue : 0.999999,
					minValue : 0,
					allowDecimals : true,
					decimalPrecision : 6,// 小数点后位数
					hideTrigger : true,
					keyNavEnabled : true
					// vtype : 'number'
				}
			}],
	selType : 'cellmodel',
	initComponent : function() {
		this.createStore();
		var me = this;
		var columns = me.columns;
		var callstore = me.getStore();
		this.rowEditor = Ext.create('Ext.grid.plugin.CellEditing', {
			id : 'accepinfoRowEditor',
			clicksToEdit : 2,
			listeners : {
				edit : function(editor, e) {
					Ext.apply(me.store.proxy.extraParams, {
								'rschvouno' : Ext.getCmp('rschvouno')
										.getValue()
							});
					if (e.colIdx == 2 || e.colIdx == 7) {
						e.value = Ext.Date.format(e.value, 'Y-m-d');
						if (e.colIdx == 2) {
							e.record.data.opendate = e.value;
						} else {
							e.record.data.currduedate = e.value;
						}

					}
					if (e.colIdx == 10) {
						if (e.value != e.originalValue) {
							e.record.data.intrestres1chged = true;
							e.record.data.originalValue = e.originalValue;
						} else {
							return;
						}
					} else {
						if (Ext.util.Format.trim(e.originalValue) != Ext.util.Format
								.trim(e.value)) {
							// alert(columns[e.colIdx].text);
							e.record.data.originalValue = e.originalValue;
							if (e.colIdx == 2) {
								e.record.data.opendatechged = true;
							}
							if (e.colIdx == 3) {
								if (Ext.util.Format.trim(e.value) == '') {
									e.record.data.diacctchged = true;
									e.record.data.originalValue = e.originalValue
											+ "|" + e.record.data.dbacct;
								} else {
									Ext.Msg.show({
												title : '修改贷款信息',
												msg : "&nbsp;&nbsp;还款账号只能更新为空！",
												buttons : Ext.Msg.OK,
												icon : 'x-message-box-warning'
											});
									me.store.load();
									return;

								}

							}
							if (e.colIdx == 4) {
								if (Ext.util.Format.trim(e.value) == '') {
									e.record.data.dbacctchged = true;
									e.record.data.originalValue = e.originalValue
											+ "|" + e.record.data.dbacct;
								} else {
									Ext.Msg.show({
												title : '修改贷款信息',
												msg : "&nbsp;&nbsp;还款账号只能更新为空！",
												buttons : Ext.Msg.OK,
												icon : 'x-message-box-warning'
											});
									me.store.load();
									return;

								}
							}
							if (e.colIdx == 5) {
								if (e.value - 1 == 0) {
									e.record.data.discountflagchged = true;
								} else {
									Ext.Msg.show({
												title : '修改贷款信息',
												msg : "&nbsp;&nbsp;贴息标志只能从0改成1！",
												buttons : Ext.Msg.OK,
												icon : 'x-message-box-warning'
											});
									me.store.load();
									return;
								}
							}
							if (e.colIdx == 6) {
								e.record.data.noaccrualflagchged = true;
								if (e.value - 1 != 0) {
									e.record.data.noaccrualflagchged = true;
								} else {
									Ext.Msg.show({
												title : '修改贷款信息',
												msg : "&nbsp;&nbsp;非应计标志只能从1改成0！",
												buttons : Ext.Msg.OK,
												icon : 'x-message-box-warning'
											});
									me.store.load();
									return;
								}

							}
							if (e.colIdx == 7) {
								e.record.data.currduedatechged = true;
							}
							if (e.colIdx == 8) {
								if (e.value - 1 == 0) {
									e.record.data.loantype1chged = true;
								} else {
									Ext.Msg.show({
												title : '修改贷款信息',
												msg : "&nbsp;&nbsp;只可把按揭贷款改为非按揭！",
												buttons : Ext.Msg.OK,
												icon : 'x-message-box-warning'
											});
									me.store.load();
									return;
								}
							}
							if (e.colIdx == 9) {
								e.record.data.loanstatchged = true;
								if (e.value != '01'
										|| (e.originalValue != '04' && e.originalValue != '08')) {
									Ext.Msg.show({
										title : '修改贷款信息',
										msg : "&nbsp;&nbsp;修改只能从04->01或08->01！",
										buttons : Ext.Msg.OK,
										icon : 'x-message-box-warning'
									});
									me.store.load();
									return;
								}
							}
							if (e.colIdx == 10) {
								e.record.data.intrestres1chged = true;
							}
						} else {
							if (e.colIdx == 2 || e.colIdx == 7) {
								me.store.load();
							}
							return;
						};
					};
					Ext.Msg.confirm('操作提示', '确定更新【' + columns[e.colIdx].text
									+ '】？', function(btn) {
								if ('yes' == btn) {
									e.record.save({
										success : function(record, options) {
											record.commit();
											var response = callstore.getProxy()
													.getReader().rawData;
											if (response.success) {
												Ext.Msg.show({
															title : '修改贷款信息',
															msg : "&nbsp;&nbsp;"
																	+ response.text
																	+ "！",
															buttons : Ext.Msg.OK,
															icon : 'x-message-box-ok'
														});
											} else {
												Ext.Msg.show({
													title : '修改贷款信息',
													msg : response.text + "！",
													buttons : Ext.Msg.OK,
													icon : 'x-message-box-warning'
												});
											}
											me.store.load();
										},
										failure : function() {
											Ext.Msg.show({
												title : '修改贷款信息',
												msg : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改失败！",
												buttons : Ext.Msg.OK,
												icon : 'x-message-box-warning'
											});
											me.store.load();
										}
									});

								} else {
									me.store.load();
								}

							});

				}
			}
		});
		this.plugins = [this.rowEditor];
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
								'rschvouno' : Ext.getCmp('rschvouno')
										.getValue()
							});
				}
			}
		};
		this.callParent();
	},
	createStore : function() {
		var me = this;
		this.store = Ext.create('Fes.store.UpdateAccepInfoStore');
	},
	searchRecord : function() {
		var me = this;
		var callstore = me.getStore();
		var mk = new Ext.LoadMask(document.body, {
					msg : '正在查詢，请稍候...'
				});
		if (Ext.isEmpty(Ext.util.Format.trim(Ext.getCmp('rschvouno')
				.getValue()))) {
			Ext.Msg.show({
						title : '修改贷款信息',
						msg : '账号不能为空！',
						buttons : Ext.Msg.OK,
						icon : 'x-message-box-warning'
					});
		} else {
			mk.show();
			me.getStore().load({
				params : {
					rschacctno : Ext.getCmp('rschvouno').getValue(),
					page : 1,
					start : 0
				},
				callback : function(r, options, success) {
					if (success) {
						var response = callstore.getProxy().getReader().rawData;
						if (response.failure) {
							Ext.Msg.show({
										title : '修改贷款信息',
										msg : response.text + "！",
										buttons : Ext.Msg.OK,
										icon : 'x-message-box-warning'
									});
							mk.hide();
						} else {
							mk.hide();
						}
					}
				}
			});

		};

	},
	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
			items : ['->', {
						xtype : 'textfield',
						fieldLabel : '账号',
						labelWidth : 40,
						width : 400,
						id : 'rschvouno'
					}, '-', {
						xtype : 'button',
						text : '查询',
						iconCls : 'icon-search',
						handler : me.searchRecord,
						scope : me
					}, '-']
		});
	}
});
