var _mspMsgListHistoryWindow=false;
Ext.define('Fes.view.MspMsgListHistoryList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.mspMsgListHistorylist',
	title : '[短信清单历史记录]列表',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载[短信清单历史记录]列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
						{text : 'messagenum',width : 120,sortable : true,dataIndex : 'messagenum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'content',width : 120,sortable : true,dataIndex : 'content',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'mobilenumber',width : 120,sortable : true,dataIndex : 'mobilenumber',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'status',width : 120,sortable : true,dataIndex : 'status',field : {xtype : 'textfield',required : true}},
		 	 		
					{text : 'sendingtime',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'sendingtime',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
						{text : 'priority',width : 120,sortable : true,dataIndex : 'priority',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'count',width : 120,sortable : true,dataIndex : 'count',field : {xtype : 'textfield',required : true}},
		 	 		
					{text : 'createtime',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'createtime',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
	 	 		
	 	 		{text : 'id',width : 120,sortable : true,dataIndex : 'id',hidden:true}
	 	 		
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'mspMsgListHistoryListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
				 
					  
					  
					  
					  
					  
							var d= new Date();if(e.record.data.sendingtime>0){ d.setTime(e.record.data.sendingtime); e.record.data.sendingtime=d;}
					  
					  
					  
							var d= new Date();if(e.record.data.createtime>0){ d.setTime(e.record.data.createtime); e.record.data.createtime=d;}
					},
					startEdit:function(record, columnHeader ){
			
						this.editRecord=record;
					},
					edit : function(editor, e) {
					 
						e.record.save({
									success : function(mspMsgListHistory, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											mspMsgListHistory.set('id', data.extra);
										}
										mspMsgListHistory.commit();
									}
								});
	
					}
				}
			});
		 
		;
		this.plugins = [this.rowEditor], this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true
		};
		this.callParent();
		
	},
	
						editRecord : function() {
						var records = this.getSelectionModel().getSelection();
						if (records && records.length > 0) {
							var record = new Fes.model.MspMsgListHistoryModel(
									records[records.length - 1].data);

							this.showWindow(record);
						} else {
							Ext.Msg.alert('提示：', '请先选择需要编辑的记录！');
						}

					},
	
saveRecode:function(obj){
		var record = new Fes.model.MspMsgListHistoryModel(obj);
		this.getStore().add(record);
		record.save({
			success : function(vo, options) {
				var data = Ext
						.decode(options.response.responseText);
				if (data.extra) {
					vo.set('id', data.extra);
				}
				vo.commit();
			}
		}); 
	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.MspMsgListHistoryStore');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.MspMsgListHistoryModel({
			
		});

		if (records.length > 0){
			// record =	records[records.length-1];
			record= new Fes.model.MspMsgListHistoryModel({
			
						messagenum:records[records.length-1].data.messagenum,
				 	
						content:records[records.length-1].data.content,
				 	
						mobilenumber:records[records.length-1].data.mobilenumber,
				 	
						status:records[records.length-1].data.status,
				 	
						sendingtime:records[records.length-1].data.sendingtime,
				 	
						priority:records[records.length-1].data.priority,
				 	
						count:records[records.length-1].data.count,
				 	
						createtime:records[records.length-1].data.createtime,
				 	
 
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个短信清单历史记录?',
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
		}

	},
	showWindow:function(rec){ 
		var me = this;
		if(!_mspMsgListHistoryWindow){
			_mspMsgListHistoryWindow= Ext.create('Fes.view.MspMsgListHistoryWindow', { 
			    closeAction:'hide',
				buttons : [
				            {
				                text: 'Save5',
				                handler: function(){
				                	  
				            		  
				            			//alert(_mspMsgListHistoryWindow.down('form').getValues());
				            			me.saveRecode(_mspMsgListHistoryWindow.down('form').getValues());
				            		 
				                }
				            },
				            {
				                text: 'Cancel',
				                scope: this,
				                handler: function(){
				                	_mspMsgListHistoryWindow.hide();
				                }
				            }
				        ]
			})
			}
			 						if (rec&&rec.data) {
							if (rec.data.signDate > 0) {
								var d = new Date();
								d.setTime(rec.data.signDate);
								rec.data.signDate = d;
							}
							_mspMsgListHistoryWindow.down('form').loadRecord(rec);
		}
		_mspMsgListHistoryWindow.show();
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : 'ID',
								labelWidth : 40,
								flex : .6,
								id : 'mspMsgListHistoryId'
							},{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											id : Ext.getCmp('mspMsgListHistoryId').getValue()
										}
									});
								}
							}, '-', Ext.create('Ext.Button', {
								text : '弹窗添加',
								iconCls : 'icon-add',
								handler : me.showWindow,
								scope : me
							}),Ext.create('Ext.Button', {
										text : '页面添加',
										iconCls : 'icon-add',
										handler : me.addRecord,
										scope : me
									}),'-',Ext.create('Ext.Button', {
										text : '编辑',
										iconCls : 'icon-edit',
										handler : me.editRecord,
										scope : me
									}),'-', {
								xtype : 'button',
								text : '删除',
								iconCls : 'icon-del',
								handler : me.deleteRecord,
								scope : me
							}]
				});
	}
});