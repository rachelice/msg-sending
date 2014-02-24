var _mspEnterpriseWindow=false;
Ext.define('Fes.view.MspEnterpriseList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.mspEnterpriselist',
	title : '[企业表]列表',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载[企业表]列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
						{text : 'uuid',width : 120,sortable : true,dataIndex : 'uuid',field : {xtype : 'textfield',required : true}},
		 	 		
					{text : 'updateTime',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'updateTime',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
					{text : 'createTime',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'createTime',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
						{text : 'version',width : 120,sortable : true,dataIndex : 'version',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'objectType',width : 120,sortable : true,dataIndex : 'objectType',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'enterpriseName',width : 120,sortable : true,dataIndex : 'enterpriseName',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'regionCode',width : 120,sortable : true,dataIndex : 'regionCode',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'licenseCode',width : 120,sortable : true,dataIndex : 'licenseCode',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'companyType',width : 120,sortable : true,dataIndex : 'companyType',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'orgnizationCode',width : 120,sortable : true,dataIndex : 'orgnizationCode',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'legalRepresentativeName',width : 120,sortable : true,dataIndex : 'legalRepresentativeName',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'businessHeadName',width : 120,sortable : true,dataIndex : 'businessHeadName',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'transactorName',width : 120,sortable : true,dataIndex : 'transactorName',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'legalIdentity',width : 120,sortable : true,dataIndex : 'legalIdentity',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'chinaOperators',width : 120,sortable : true,dataIndex : 'chinaOperators',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'chinaRegisterSum',width : 120,sortable : true,dataIndex : 'chinaRegisterSum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'foreignOperators',width : 120,sortable : true,dataIndex : 'foreignOperators',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'foreignRegisterSum',width : 120,sortable : true,dataIndex : 'foreignRegisterSum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'openAccountBank',width : 120,sortable : true,dataIndex : 'openAccountBank',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'bankAccount',width : 120,sortable : true,dataIndex : 'bankAccount',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'orgCode',width : 120,sortable : true,dataIndex : 'orgCode',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'addressId',width : 120,sortable : true,dataIndex : 'addressId',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'telephone',width : 120,sortable : true,dataIndex : 'telephone',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'fax',width : 120,sortable : true,dataIndex : 'fax',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'mobilePhone',width : 120,sortable : true,dataIndex : 'mobilePhone',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'postcode',width : 120,sortable : true,dataIndex : 'postcode',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'email',width : 120,sortable : true,dataIndex : 'email',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'enterpriseNetAddress',width : 120,sortable : true,dataIndex : 'enterpriseNetAddress',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'superiorLicense',width : 120,sortable : true,dataIndex : 'superiorLicense',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'employeesNum',width : 120,sortable : true,dataIndex : 'employeesNum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'managersNum',width : 120,sortable : true,dataIndex : 'managersNum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'practionersNum',width : 120,sortable : true,dataIndex : 'practionersNum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'anyOthersNum',width : 120,sortable : true,dataIndex : 'anyOthersNum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'flagOfLicense',width : 120,sortable : true,dataIndex : 'flagOfLicense',field : {xtype : 'textfield',required : true}},
		 	 		
					{text : 'periodOfValidityStart',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'periodOfValidityStart',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
					{text : 'periodOfValidityEnd',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'periodOfValidityEnd',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
					{text : 'issueDate',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'issueDate',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
					{text : 'operateDate',width : 120,sortable : true,renderer:function(v){if(!v||v==''){return;}var d= new Date();d.setTime(v); return Ext.util.Format.date(d,'Y-m-d');},dataIndex : 'operateDate',field : {xtype : 'datefield', format:'Y-m-d'}},
		 	 		
		 	 		
						{text : 'operator',width : 120,sortable : true,dataIndex : 'operator',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'oldEnterprisebaseinfoid',width : 120,sortable : true,dataIndex : 'oldEnterprisebaseinfoid',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'userId',width : 120,sortable : true,dataIndex : 'userId',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '驾校数据',width : 120,sortable : true,dataIndex : 'enterpriseCategory',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '是否锁定',width : 120,sortable : true,dataIndex : 'islock',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'isSignLock',width : 120,sortable : true,dataIndex : 'isSignLock',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : 'miaxisNum',width : 120,sortable : true,dataIndex : 'miaxisNum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '安运单位编号',width : 120,sortable : true,dataIndex : 'safeluckNum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '维尔单位编号',width : 120,sortable : true,dataIndex : 'wellcomNum',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '允许指纹修改设置',width : 120,sortable : true,dataIndex : 'fingerModifyFit',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '指纹修改设置标记',width : 120,sortable : true,dataIndex : 'fingerModifyFlag',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '有为企业id，有为企业的唯一标示，制卡时可能会用到',width : 120,sortable : true,dataIndex : 'yuweiCorpId',field : {xtype : 'textfield',required : true}},
		 	 		
						{text : '驾校简称',width : 120,sortable : true,dataIndex : 'enterpriseShortenName',field : {xtype : 'textfield',required : true}},
		 	 		
	 	 		
	 	 		{text : 'id',width : 120,sortable : true,dataIndex : 'id',hidden:true}
	 	 		
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'mspEnterpriseListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
				 
					  
					  
							var d= new Date();if(e.record.data.updateTime>0){ d.setTime(e.record.data.updateTime); e.record.data.updateTime=d;}
					  
							var d= new Date();if(e.record.data.createTime>0){ d.setTime(e.record.data.createTime); e.record.data.createTime=d;}
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
							var d= new Date();if(e.record.data.periodOfValidityStart>0){ d.setTime(e.record.data.periodOfValidityStart); e.record.data.periodOfValidityStart=d;}
					  
							var d= new Date();if(e.record.data.periodOfValidityEnd>0){ d.setTime(e.record.data.periodOfValidityEnd); e.record.data.periodOfValidityEnd=d;}
					  
							var d= new Date();if(e.record.data.issueDate>0){ d.setTime(e.record.data.issueDate); e.record.data.issueDate=d;}
					  
							var d= new Date();if(e.record.data.operateDate>0){ d.setTime(e.record.data.operateDate); e.record.data.operateDate=d;}
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					},
					startEdit:function(record, columnHeader ){
			
						this.editRecord=record;
					},
					edit : function(editor, e) {
					 
						e.record.save({
									success : function(mspEnterprise, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											mspEnterprise.set('id', data.extra);
										}
										mspEnterprise.commit();
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
							var record = new Fes.model.MspEnterpriseModel(
									records[records.length - 1].data);

							this.showWindow(record);
						} else {
							Ext.Msg.alert('提示：', '请先选择需要编辑的记录！');
						}

					},
	
saveRecode:function(obj){
		var record = new Fes.model.MspEnterpriseModel(obj);
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
		me.store = Ext.create('Fes.store.MspEnterpriseStore');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.MspEnterpriseModel({
			
		});

		if (records.length > 0){
			// record =	records[records.length-1];
			record= new Fes.model.MspEnterpriseModel({
			
						uuid:records[records.length-1].data.uuid,
				 	
						updateTime:records[records.length-1].data.updateTime,
				 	
						createTime:records[records.length-1].data.createTime,
				 	
						version:records[records.length-1].data.version,
				 	
						objectType:records[records.length-1].data.objectType,
				 	
						enterpriseName:records[records.length-1].data.enterpriseName,
				 	
						regionCode:records[records.length-1].data.regionCode,
				 	
						licenseCode:records[records.length-1].data.licenseCode,
				 	
						companyType:records[records.length-1].data.companyType,
				 	
						orgnizationCode:records[records.length-1].data.orgnizationCode,
				 	
						legalRepresentativeName:records[records.length-1].data.legalRepresentativeName,
				 	
						businessHeadName:records[records.length-1].data.businessHeadName,
				 	
						transactorName:records[records.length-1].data.transactorName,
				 	
						legalIdentity:records[records.length-1].data.legalIdentity,
				 	
						chinaOperators:records[records.length-1].data.chinaOperators,
				 	
						chinaRegisterSum:records[records.length-1].data.chinaRegisterSum,
				 	
						foreignOperators:records[records.length-1].data.foreignOperators,
				 	
						foreignRegisterSum:records[records.length-1].data.foreignRegisterSum,
				 	
						openAccountBank:records[records.length-1].data.openAccountBank,
				 	
						bankAccount:records[records.length-1].data.bankAccount,
				 	
						orgCode:records[records.length-1].data.orgCode,
				 	
						addressId:records[records.length-1].data.addressId,
				 	
						telephone:records[records.length-1].data.telephone,
				 	
						fax:records[records.length-1].data.fax,
				 	
						mobilePhone:records[records.length-1].data.mobilePhone,
				 	
						postcode:records[records.length-1].data.postcode,
				 	
						email:records[records.length-1].data.email,
				 	
						enterpriseNetAddress:records[records.length-1].data.enterpriseNetAddress,
				 	
						superiorLicense:records[records.length-1].data.superiorLicense,
				 	
						employeesNum:records[records.length-1].data.employeesNum,
				 	
						managersNum:records[records.length-1].data.managersNum,
				 	
						practionersNum:records[records.length-1].data.practionersNum,
				 	
						anyOthersNum:records[records.length-1].data.anyOthersNum,
				 	
						flagOfLicense:records[records.length-1].data.flagOfLicense,
				 	
						periodOfValidityStart:records[records.length-1].data.periodOfValidityStart,
				 	
						periodOfValidityEnd:records[records.length-1].data.periodOfValidityEnd,
				 	
						issueDate:records[records.length-1].data.issueDate,
				 	
						operateDate:records[records.length-1].data.operateDate,
				 	
						operator:records[records.length-1].data.operator,
				 	
						oldEnterprisebaseinfoid:records[records.length-1].data.oldEnterprisebaseinfoid,
				 	
						userId:records[records.length-1].data.userId,
				 	
						enterpriseCategory:records[records.length-1].data.enterpriseCategory,
				 	
						islock:records[records.length-1].data.islock,
				 	
						isSignLock:records[records.length-1].data.isSignLock,
				 	
						miaxisNum:records[records.length-1].data.miaxisNum,
				 	
						safeluckNum:records[records.length-1].data.safeluckNum,
				 	
						wellcomNum:records[records.length-1].data.wellcomNum,
				 	
						fingerModifyFit:records[records.length-1].data.fingerModifyFit,
				 	
						fingerModifyFlag:records[records.length-1].data.fingerModifyFlag,
				 	
						yuweiCorpId:records[records.length-1].data.yuweiCorpId,
				 	
						enterpriseShortenName:records[records.length-1].data.enterpriseShortenName,
				 	
 
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个企业表?',
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
		if(!_mspEnterpriseWindow){
			_mspEnterpriseWindow= Ext.create('Fes.view.MspEnterpriseWindow', { 
			    closeAction:'hide',
				buttons : [
				            {
				                text: 'Save5',
				                handler: function(){
				                	  
				            		  
				            			//alert(_mspEnterpriseWindow.down('form').getValues());
				            			me.saveRecode(_mspEnterpriseWindow.down('form').getValues());
				            		 
				                }
				            },
				            {
				                text: 'Cancel',
				                scope: this,
				                handler: function(){
				                	_mspEnterpriseWindow.hide();
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
							_mspEnterpriseWindow.down('form').loadRecord(rec);
		}
		_mspEnterpriseWindow.show();
	},
	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : 'ID',
								labelWidth : 40,
								flex : .6,
								id : 'mspEnterpriseId'
							},{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											id : Ext.getCmp('mspEnterpriseId').getValue()
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