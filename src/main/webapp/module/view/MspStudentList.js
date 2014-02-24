var _mspStudentWindow=false;
Ext.define('Fes.view.MspStudentList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.mspStudentlist',
	title : '[学员表]列表',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载[学员表]列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
						{text : '驾校许可证号',width : 120,sortable : true,dataIndex : 'licenseCode',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '驾校名称',width : 120,sortable : true,dataIndex : 'enterpriseName',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '班期名称',width : 120,sortable : true,dataIndex : 'semesterName',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '电话',width : 120,sortable : true,dataIndex : 'userTel',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '驾校id',width : 120,sortable : true,dataIndex : 'enterpriseId',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '学员姓名',width : 120,sortable : true,dataIndex : 'learnerName',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '身份证号',width : 120,sortable : true,dataIndex : 'identityNumber',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '性别',width : 120,sortable : true,dataIndex : 'gender',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '班期id',width : 120,sortable : true,dataIndex : 'semesterId',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '手机号码',width : 120,sortable : true,dataIndex : 'mobileNumber',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '科目一已完成学时',width : 120,sortable : true,dataIndex : 'subjectOneThFinishtime',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '科目二理论已完成学时',width : 120,sortable : true,dataIndex : 'subjectTwoThFinishtime',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '科目二实操已完成学时',width : 120,sortable : true,dataIndex : 'subjectTwoOpFinishtime',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '科目三理论已完成学时',width : 120,sortable : true,dataIndex : 'subjectThreeThFinishtime',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '科目三实操已完成学时',width : 120,sortable : true,dataIndex : 'subjectThreeOpFinishtime',field : {xtype : 'textfield',required : true}},
		 	 		
					{text : '更新时间',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'updateTime',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
					{text : '创建时间',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'createTime',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
						{text : '备注',width : 120,sortable : true,dataIndex : 'remark',field : {xtype : 'textfield',required : true}},
		 	 		
	 	 		
	 	 		{text : 'id',width : 120,sortable : true,dataIndex : 'id',hidden:true}
	 	 		
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'mspStudentListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
				 
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
							var d= new Date();if(e.record.data.updateTime>0){ d.setTime(e.record.data.updateTime); e.record.data.updateTime=d;}
					  
							var d= new Date();if(e.record.data.createTime>0){ d.setTime(e.record.data.createTime); e.record.data.createTime=d;}
					  
					},
					startEdit:function(record, columnHeader ){
			
						this.editRecord=record;
					},
					edit : function(editor, e) {
					 
						e.record.save({
									success : function(mspStudent, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											mspStudent.set('id', data.extra);
										}
										mspStudent.commit();
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
							var record = new Fes.model.MspStudentModel(
									records[records.length - 1].data);

							this.showWindow(record);
						} else {
							Ext.Msg.alert('提示：', '请先选择需要编辑的记录！');
						}

					},
	
saveRecode:function(obj){
		var record = new Fes.model.MspStudentModel(obj);
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
		me.store = Ext.create('Fes.store.MspStudentStore');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.MspStudentModel({
			
		});

		if (records.length > 0){
			// record =	records[records.length-1];
			record= new Fes.model.MspStudentModel({
			
						licenseCode:records[records.length-1].data.licenseCode,
				 	
						enterpriseName:records[records.length-1].data.enterpriseName,
				 	
						semesterName:records[records.length-1].data.semesterName,
				 	
						userTel:records[records.length-1].data.userTel,
				 	
						enterpriseId:records[records.length-1].data.enterpriseId,
				 	
						learnerName:records[records.length-1].data.learnerName,
				 	
						identityNumber:records[records.length-1].data.identityNumber,
				 	
						gender:records[records.length-1].data.gender,
				 	
						semesterId:records[records.length-1].data.semesterId,
				 	
						mobileNumber:records[records.length-1].data.mobileNumber,
				 	
						subjectOneThFinishtime:records[records.length-1].data.subjectOneThFinishtime,
				 	
						subjectTwoThFinishtime:records[records.length-1].data.subjectTwoThFinishtime,
				 	
						subjectTwoOpFinishtime:records[records.length-1].data.subjectTwoOpFinishtime,
				 	
						subjectThreeThFinishtime:records[records.length-1].data.subjectThreeThFinishtime,
				 	
						subjectThreeOpFinishtime:records[records.length-1].data.subjectThreeOpFinishtime,
				 	
						updateTime:records[records.length-1].data.updateTime,
				 	
						createTime:records[records.length-1].data.createTime,
				 	
						remark:records[records.length-1].data.remark,
				 	
 
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个学员表?',
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
		if(!_mspStudentWindow){
			_mspStudentWindow= Ext.create('Fes.view.MspStudentWindow', { 
			    closeAction:'hide',
				buttons : [
				            {
				                text: 'Save5',
				                handler: function(){
				                	  
				            		  
				            			//alert(_mspStudentWindow.down('form').getValues());
				            			me.saveRecode(_mspStudentWindow.down('form').getValues());
				            		 
				                }
				            },
				            {
				                text: 'Cancel',
				                scope: this,
				                handler: function(){
				                	_mspStudentWindow.hide();
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
							_mspStudentWindow.down('form').loadRecord(rec);
		}
		_mspStudentWindow.show();
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : 'ID',
								labelWidth : 40,
								flex : .6,
								id : 'mspStudentId'
							},{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											id : Ext.getCmp('mspStudentId').getValue()
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