console.log('BranchsMS...');
Ext.require(['Fes.view.SplitResultList']);
Ext.define('Fes.view.BranchsMS', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.branchsms',
	title : '机构撤并拆分申请列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	allowDeselect : true,
	// simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载机构撤并拆分申请列表'
	},
	columns : [{
				xtype : 'rownumberer'
			}, {
				text : '处理日期',
				flex : 1,
				sortable : true,
				dataIndex : 'prodate',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '处理机构',
				flex : 1,
				sortable : true,
				dataIndex : 'probrc',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '撤并方式',
				flex : 1,
				sortable : true,
				dataIndex : 'promode',
				renderer : function(v, m) {
					if (v == '1') {
						return '撤并';
					}
					if (v == '2') {
						return '拆分';
					}
				}
			}, {
				text : '并入机构',
				flex : 1,
				sortable : true,
				dataIndex : 'oppbrc',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '维护日期',
				flex : 1,
				sortable : true,
				dataIndex : 'modidate',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '操作员',
				flex : 1,
				sortable : true,
				dataIndex : 'teller',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '处理标志',
				flex : 1,
				sortable : true,
				dataIndex : 'proflag',
				renderer : function(v, m) {
					if (v == '0') {
						return '未处理';
					}
					if (v == '1') {
						return '已处理';
					}
				}
			}],
	listeners : {
		itemdblclick : function(view, record, item, index, e, eOpts) {
			showWindow(record);
		}
	},
	initComponent : function() {
		this.createStore();
		this.store.load();

		this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true,
			doRefresh : function() {
				return false;
			}
		};

		this.callParent();
	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.BranchsMSStore');
	},
	deleteRecord : function() {
		var me = this;
		alert('删除');

	},
	createToolbar : function() {
		var me = this;
		pageVar.PROMODEStore = eval("[{'value':'1', 'text':'撤并'},{'value':'2', 'text':'拆分'}]");
		this.PROMODEStore = Ext.create('Ext.data.Store', {
					fields : ['value', 'text'],
					data : pageVar.PROMODEStore
				});
		return Ext.create('Ext.toolbar.Toolbar', {
					items : ['->', {
								xtype : 'datefield',
								format : 'Y-m-d',
								fieldLabel : '处理日期',
								blankText : '请选择日期',
								id : 'branchms_prodate',
								labelWidth : 60,
								width : 200
							}, '-', {
								xtype : 'textfield',
								fieldLabel : '处理机构',
								blankText : '请输入处理机构',
								id : 'branchms_probrc',
								labelWidth : 60,
								width : 200
							}, '-', {
								store : this.PROMODEStore,
								queryMode : 'local',
								displayField : 'text',
								valueField : 'value',
								xtype : 'combobox',
								fieldLabel : '撤并方式',
								blankText : '请选择...',
								emptyText : "请选择...",
								id : 'branchms_promode',
								labelWidth : 60,
								width : 200
							}, '-', {
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											prodate : Ext
													.getCmp('branchms_prodate')
													.getValue(),
											probrc : Ext
													.getCmp('branchms_probrc')
													.getValue(),
											promode : Ext
													.getCmp('branchms_promode')
													.getValue(),
											page : 1,
											start : 0
										}
									});
								},
								scope : me
							}, '-', {
								xtype : 'button',
								text : '删除',
								iconCls : 'icon-del',
								handler : me.deleteRecord,
								scope : me
							}, '-', {
								xtype : 'button',
								text : '申请',
								iconCls : 'icon-apply',
								handler : function() {
									showWindow(null);
								}
							}, '-']
				});
	}
});

var pageVar = {};
pageVar.vPanelW = 440;
pageVar.vPanelH = 400;
pageVar.alertPanelTitle = '农信银撤并拆分申请';

var modifyWin = null; // 弹出窗口
// 创建弹出表单
ModifyWin = Ext.extend(Ext.util.Observable, {
	extend : Ext.util.Observable,
	alertWin : null,
	alertPanel : null,
	field : null, // 放置弹出窗口需要的变量

	constructor : function() {
		this.alertPanel = new Fes.view.SplitResultList;

		this.alertWin = Ext.create('Ext.window.Window', {
					modal : true,
					title : pageVar.alertPanelTitle,
					layout : 'fit',
					width : pageVar.vPanelW,
					height : pageVar.vPanelH,
					items : this.alertPanel,
					constrain : true,
					shrinkWrap : 3,
					closeAction : 'destroy',
					buttons : [ // 在窗口中增加按钮
					{
								text : '提交',
								minWidth : 70,
								id : 'split_savaButton',
								scope : this,
								handler : this.save
							}, {
								text : '取消',
								minWidth : 70,
								scope : this,
								id : 'split_cancelButton',
								handler : this.cancel
							}]
				});
	},

	cancel : function() {
		this.alertWin.destroy();
	},

	show : function() {
		this.alertWin.show();
		return this.alertPanel;
	},

	save : function() {
		var mk = new Ext.LoadMask(document.body, {
					msg : '正在提交，请稍候...'
				});
		var SplitRecords = new Array();
		var count = this.alertPanel.store.getCount();
		var prodate_t = Ext.getCmp('SPLIT_PRODATE');
		var probrc_t = Ext.getCmp('SPLIT_PROBRC');
		var promode_t = Ext.getCmp('SPLIT_PROMODE');
		var splitseq_t = Ext.getCmp('SPLIT_SEQ');
		var oppbrc_t = Ext.getCmp('SPLIT_OPPBRC');
		var modidate_t = Ext.getCmp('SPLIT_MODIDATE');
		var teller_t = Ext.getCmp('SPLIT_TELLER');
		var proflag_t = Ext.getCmp('SPLIT_PROFLAG');

		if (!prodate_t.isValid() || !probrc_t.isValid() || !promode_t.isValid()
				|| !oppbrc_t.isValid() || !modidate_t.isValid()) {
			Ext.Msg.show({
						title : '提示',
						msg : '以上均为必填项，请根据提示正确填写！',
						buttons : Ext.Msg.OK,
						icon : 'x-message-box-warning'
					});
			return;
		} else {
			if (promode_t.getValue() == 2) {
				if (count == 0) {
					Ext.Msg.show({
								title : '提示',
								msg : '拆分列表不能为空！',
								buttons : Ext.Msg.OK,
								icon : 'x-message-box-warning'
							});
					return;
				} else {
					var repeat_count = 0;
					var split_store = this.alertPanel.store;
					split_store.each(function(record) {
						SplitRecords.push(record.data);
						split_store.each(function(record_s) {
							if (record.data.splitflag == record_s.data.splitflag
									&& record.data.subsys == record_s.data.subsys
									&& record.data.subctrlcode == record_s.data.subctrlcode
									&& record.data.acctno == record_s.data.acctno) {
								repeat_count++;
								if (repeat_count == 2) {
									return false;
								}
							}
						});
						if (repeat_count == 2) {
							return false;
						} else {
							repeat_count = 0;
						}
					});

					if (repeat_count == 2) {
						Ext.Msg.show({
									title : '提示',
									msg : '拆分记录不能重复，请检查！',
									buttons : Ext.Msg.OK,
									icon : 'x-message-box-warning'
								});
						return;
					}
				}
			}
		}

		mk.show();

		Ext.Ajax.request({
					method : 'POST',
					url : 'branchsms',
					success : function(response, option) {
						var rs = Ext.decode(response.responseText);
						// Ext.MessageBox.alert('提示', rs.text);
						Ext.Msg.show({
									title : '提示',
									msg : "&nbsp;&nbsp;" + rs.text + "！",
									buttons : Ext.Msg.OK,
									icon : 'x-message-box-ok'
								});
						if (rs.success) {
							this.alertWin.destroy();
							mk.hide();
						}
					},
					failure : function(response) {
						Ext.MessageBox.alert('提示', '网络错误或连不到服务!');
						mk.hide();
					},
					scope : this,
					params : {
						prodate : prodate_t.getValue(),
						probrc : probrc_t.getValue(),
						promode : promode_t.getValue(),
						splitseq : splitseq_t.getValue(),
						oppbrc : oppbrc_t.getValue(),
						modidate : modidate_t.getValue(),
						teller : teller_t.getValue(),
						proflag : proflag_t.getValue(),
						strJson : Ext.encode(SplitRecords)
					}
				});
	}
});

var showWindow = function(record) {
	if (modifyWin != null) {
		Ext.util.Observable.releaseCapture(modifyWin);
	}
	modifyWin = new ModifyWin();
	var split_store = modifyWin.show().store;
	if (record != null) {
		Ext.getCmp('SPLIT_PRODATE').setValue(record.data.prodate);
		Ext.getCmp('SPLIT_PROBRC').setValue(record.data.probrc);
		Ext.getCmp('SPLIT_PROMODE').setValue(record.data.promode);
		Ext.getCmp('SPLIT_SEQ').setValue(record.data.splitseq);
		Ext.getCmp('SPLIT_OPPBRC').setValue(record.data.oppbrc);
		Ext.getCmp('SPLIT_MODIDATE').setValue(record.data.modidate);
		Ext.getCmp('SPLIT_TELLER').setValue(record.data.teller);
		Ext.getCmp('SPLIT_PROFLAG').setValue(record.data.proflag);
		if (record.data.promode == '2') {
			Ext.getCmp('splitresult_addButton').setDisabled(0);
			Ext.getCmp('splitresult_delButton').setDisabled(0);
			split_store.load({
						params : {
							probrc : record.data.probrc,
							oppbrc : record.data.oppbrc,
							action : 'splitlist',
							page : 1,
							start : 0
						}
					});
		}
		Ext.getCmp('SPLIT_PRODATE').setReadOnly(1);
		Ext.getCmp('SPLIT_PROBRC').setReadOnly(1);
		Ext.getCmp('SPLIT_PROMODE').setReadOnly(1);
		Ext.getCmp('SPLIT_OPPBRC').setReadOnly(1);
		if (record.data.proflag == '1') {		
			Ext.getCmp('SPLIT_MODIDATE').setReadOnly(1);
			Ext.getCmp('split_savaButton').setVisible(false);
			Ext.getCmp('split_cancelButton').setText('确定');
		}

	}

};