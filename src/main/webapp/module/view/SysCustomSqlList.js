var _sysCustomSqlWindow=false;
Ext.define('Fes.view.SysCustomSqlList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.sysCustomSqllist',
	title : '[报表]列表',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载[报表]列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
						{text : 'sql',width : 120,sortable : true,dataIndex : 'sql',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'note',width : 120,sortable : true,dataIndex : 'note',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'count',width : 120,sortable : true,dataIndex : 'count',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'title',width : 120,sortable : true,dataIndex : 'title',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'state',width : 120,sortable : true,dataIndex : 'state',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'parentParamId',width : 120,sortable : true,dataIndex : 'parentParamId',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'syb1',width : 120,sortable : true,dataIndex : 'syb1',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'syb2',width : 120,sortable : true,dataIndex : 'syb2',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'syb3',width : 120,sortable : true,dataIndex : 'syb3',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'syb4',width : 120,sortable : true,dataIndex : 'syb4',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'syb5',width : 120,sortable : true,dataIndex : 'syb5',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'createDate',width : 120,sortable : true,dataIndex : 'createDate',field : {xtype : 'textfield',required : true}},
		 	 		
	 	 		
	 	 		{text : 'id',width : 120,sortable : true,dataIndex : 'id',hidden:true}
	 	 		
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'sysCustomSqlListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
				 
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					},
					startEdit:function(record, columnHeader ){
			
						this.editRecord=record;
					},
					edit : function(editor, e) {
					 
						e.record.save({
									success : function(sysCustomSql, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											sysCustomSql.set('id', data.extra);
										}
										sysCustomSql.commit();
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
							var record = new Fes.model.SysCustomSqlModel(
									records[records.length - 1].data);

							this.showWindow(record);
						} else {
							Ext.Msg.alert('提示：', '请先选择需要编辑的记录！');
						}

					},
	
saveRecode:function(obj){
		var record = new Fes.model.SysCustomSqlModel(obj);
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
		me.store = Ext.create('Fes.store.SysCustomSqlStore');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.SysCustomSqlModel({
			
		});

		if (records.length > 0){
			// record =	records[records.length-1];
			record= new Fes.model.SysCustomSqlModel({
			
						sql:records[records.length-1].data.sql,
				 	
						note:records[records.length-1].data.note,
				 	
						count:records[records.length-1].data.count,
				 	
						title:records[records.length-1].data.title,
				 	
						state:records[records.length-1].data.state,
				 	
						parentParamId:records[records.length-1].data.parentParamId,
				 	
						syb1:records[records.length-1].data.syb1,
				 	
						syb2:records[records.length-1].data.syb2,
				 	
						syb3:records[records.length-1].data.syb3,
				 	
						syb4:records[records.length-1].data.syb4,
				 	
						syb5:records[records.length-1].data.syb5,
				 	
						createDate:records[records.length-1].data.createDate
				 	
 
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个报表?',
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
		if(!_sysCustomSqlWindow){
			_sysCustomSqlWindow= Ext.create('Fes.view.SysCustomSqlWindow', { 
			    closeAction:'hide',
				buttons : [
				            {
				                text: 'Save5',
				                handler: function(){
				                	  
				            		  
				            			//alert(_sysCustomSqlWindow.down('form').getValues());
				            			me.saveRecode(_sysCustomSqlWindow.down('form').getValues());
				            		 
				                }
				            },
				            {
				                text: 'Cancel',
				                scope: this,
				                handler: function(){
				                	_sysCustomSqlWindow.hide();
				                }
				            }
				        ]
			});
			}
			 						if (rec&&rec.data) {
							if (rec.data.signDate > 0) {
								var d = new Date();
								d.setTime(rec.data.signDate);
								rec.data.signDate = d;
							}
							_sysCustomSqlWindow.down('form').loadRecord(rec);
		}
		_sysCustomSqlWindow.show();
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : 'ID',
								labelWidth : 40,
								flex : .6,
								id : 'sysCustomSqlId'
							},{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											id : Ext.getCmp('sysCustomSqlId').getValue()
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