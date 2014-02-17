var _${entityName?uncap_first}Window=false;
Ext.define('Fes.view.${entityName}List', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.${entityName?uncap_first}list',
	title : '[${ftl_description}]列表',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载[${ftl_description}]列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
				<#list columns as po>
				 	<#if po.fieldType =="date" >	
					{text : '${po.filedComment}',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : '${po.fieldName}',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
						<#else>
						{text : '${po.filedComment}',width : 120,sortable : true,dataIndex : '${po.fieldName}',field : {xtype : 'textfield',required : true}},
		 	 		</#if>
		 	 		
	 	 		</#list>
	 	 		
	 	 		{text : 'id',width : 120,sortable : true,dataIndex : 'id',hidden:true}
	 	 		
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'${entityName?uncap_first}ListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
				 
					<#list columns as po>
					  
						<#if po.fieldType =='date' >
							var d= new Date();if(e.record.data.${po.fieldName}>0){ d.setTime(e.record.data.${po.fieldName}); e.record.data.${po.fieldName}=d;}
						</#if>
					</#list>
					},
					startEdit:function(record, columnHeader ){
			
						this.editRecord=record;
					},
					edit : function(editor, e) {
					 
						e.record.save({
									success : function(${entityName?uncap_first}, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											${entityName?uncap_first}.set('id', data.extra);
										}
										${entityName?uncap_first}.commit();
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
							var record = new Fes.model.${entityName}Model(
									records[records.length - 1].data);

							this.showWindow(record);
						} else {
							Ext.Msg.alert('提示：', '请先选择需要编辑的记录！');
						}

					},
	
saveRecode:function(obj){
		var record = new Fes.model.${entityName}Model(obj);
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
		me.store = Ext.create('Fes.store.${entityName}Store');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.${entityName}Model({
			
		});

		if (records.length > 0){
			// record =	records[records.length-1];
			record= new Fes.model.${entityName}Model({
			
					<#list columns as po>
						${po.fieldName}:records[records.length-1].data.${po.fieldName},
				 	
					</#list>
 
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个${ftl_description}?',
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
		if(!_${entityName?uncap_first}Window){
			_${entityName?uncap_first}Window= Ext.create('Fes.view.${entityName}Window', { 
			    closeAction:'hide',
				buttons : [
				            {
				                text: 'Save5',
				                handler: function(){
				                	  
				            		  
				            			//alert(_${entityName?uncap_first}Window.down('form').getValues());
				            			me.saveRecode(_${entityName?uncap_first}Window.down('form').getValues());
				            		 
				                }
				            },
				            {
				                text: 'Cancel',
				                scope: this,
				                handler: function(){
				                	_${entityName?uncap_first}Window.hide();
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
							_${entityName?uncap_first}Window.down('form').loadRecord(rec);
		}
		_${entityName?uncap_first}Window.show();
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : 'ID',
								labelWidth : 40,
								flex : .6,
								id : '${entityName?uncap_first}Id'
							},{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											id : Ext.getCmp('${entityName?uncap_first}Id').getValue()
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