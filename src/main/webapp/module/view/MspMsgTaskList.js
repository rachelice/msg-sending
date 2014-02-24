var _mspMsgTaskWindow=false;
Ext.define('Fes.view.MspMsgTaskList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.mspMsgTasklist',
	title : '[短信任务]列表',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载[短信任务]列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
						{text : 'msgNum',width : 120,sortable : true,dataIndex : 'msgNum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'msgContent',width : 120,sortable : true,dataIndex : 'msgContent',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'msgType',width : 120,sortable : true,dataIndex : 'msgType',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'status',width : 120,sortable : true,dataIndex : 'status',field : {xtype : 'textfield',required : true}},
		 	 		
					{text : 'sendingTime',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'sendingTime',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
						{text : 'priority',width : 120,sortable : true,dataIndex : 'priority',field : {xtype : 'textfield',required : true}},
		 	 		
					{text : 'createTime',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'createTime',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
					{text : 'submitTime',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'submitTime',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
						{text : 'submitterCode',width : 120,sortable : true,dataIndex : 'submitterCode',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'groupSending',width : 120,sortable : true,dataIndex : 'groupSending',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'businessCode',width : 120,sortable : true,dataIndex : 'businessCode',field : {xtype : 'textfield',required : true}},
		 	 		
	 	 		
	 	 		{text : 'id',width : 120,sortable : true,dataIndex : 'id',hidden:true}
	 	 		
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'mspMsgTaskListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
				 
					  
					  
					  
					  
					  
							var d= new Date();if(e.record.data.sendingTime>0){ d.setTime(e.record.data.sendingTime); e.record.data.sendingTime=d;}
					  
					  
							var d= new Date();if(e.record.data.createTime>0){ d.setTime(e.record.data.createTime); e.record.data.createTime=d;}
					  
							var d= new Date();if(e.record.data.submitTime>0){ d.setTime(e.record.data.submitTime); e.record.data.submitTime=d;}
					  
					  
					  
					},
					startEdit:function(record, columnHeader ){
			
						this.editRecord=record;
					},
					edit : function(editor, e) {
					 
						e.record.save({
									success : function(mspMsgTask, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											mspMsgTask.set('id', data.extra);
										}
										mspMsgTask.commit();
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
							var record = new Fes.model.MspMsgTaskModel(
									records[records.length - 1].data);

							this.showWindow(record);
						} else {
							Ext.Msg.alert('提示：', '请先选择需要编辑的记录！');
						}

					},
	
saveRecode:function(obj){
		var record = new Fes.model.MspMsgTaskModel(obj);
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
		me.store = Ext.create('Fes.store.MspMsgTaskStore');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.MspMsgTaskModel({
			
		});

		if (records.length > 0){
			// record =	records[records.length-1];
			record= new Fes.model.MspMsgTaskModel({
			
						msgNum:records[records.length-1].data.msgNum,
				 	
						msgContent:records[records.length-1].data.msgContent,
				 	
						msgType:records[records.length-1].data.msgType,
				 	
						status:records[records.length-1].data.status,
				 	
						sendingTime:records[records.length-1].data.sendingTime,
				 	
						priority:records[records.length-1].data.priority,
				 	
						createTime:records[records.length-1].data.createTime,
				 	
						submitTime:records[records.length-1].data.submitTime,
				 	
						submitterCode:records[records.length-1].data.submitterCode,
				 	
						groupSending:records[records.length-1].data.groupSending,
				 	
						businessCode:records[records.length-1].data.businessCode,
				 	
 
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个短信任务?',
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
		if(!_mspMsgTaskWindow){
			_mspMsgTaskWindow= Ext.create('Fes.view.MspMsgTaskWindow', { 
			    closeAction:'hide',
				buttons : [
				            {
				                text: 'Save5',
				                handler: function(){
				                	  
				            		  
				            			//alert(_mspMsgTaskWindow.down('form').getValues());
				            			me.saveRecode(_mspMsgTaskWindow.down('form').getValues());
				            		 
				                }
				            },
				            {
				                text: 'Cancel',
				                scope: this,
				                handler: function(){
				                	_mspMsgTaskWindow.hide();
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
							_mspMsgTaskWindow.down('form').loadRecord(rec);
		}
		_mspMsgTaskWindow.show();
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : 'ID',
								labelWidth : 40,
								flex : .6,
								id : 'mspMsgTaskId'
							},{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											id : Ext.getCmp('mspMsgTaskId').getValue()
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