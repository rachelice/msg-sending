
Ext.define('Fes.view.SchoolUserList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.schoolUserlist',
	title : '角色列表',
 
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载人员列表'
	},
createRoleCombox:function(){
 
},
	columns : [	
	{xtype : 'rownumberer'}, 
					{text : '照片路径',width : 120,sortable : true,dataIndex : 'picPath',field : {xtype : 'textfield',required : true}},
					{text : '邮件',width : 120,sortable : true,dataIndex : 'userEmail',field : {xtype : 'textfield',required : true}},
					{text : '生日',width : 120,sortable : true,dataIndex : 'userBirthday',field : {xtype : 'textfield',required : true}},
					{text : '上一次登陆时间',width : 120,sortable : true,dataIndex : 'lastLoginTime',field : {xtype : 'textfield',required : true}},
					{text : '用户密码',width : 120,sortable : true,dataIndex : 'password',field : {xtype : 'textfield',required : true}},
					{text : '1：正常；0：仅不能登录，不影响任何业务筛选',width : 120,sortable : true,dataIndex : 'enabled',field : {xtype : 'textfield',required : true}},
					{text : 'credentialsNonExpired',width : 120,sortable : true,dataIndex : 'credentialsNonExpired',field : {xtype : 'textfield',required : true}},
					{text : 'accountNonLocked',width : 120,sortable : true,dataIndex : 'accountNonLocked',field : {xtype : 'textfield',required : true}},
					{text : 'accountNonExpired',width : 120,sortable : true,dataIndex : 'accountNonExpired',field : {xtype : 'textfield',required : true}},
					{text : 'clientId',width : 120,sortable : true,dataIndex : 'clientId',field : {xtype : 'textfield',required : true}},
					{text : '驾校id',width : 120,sortable : true,dataIndex : 'drivingschoolId',field : {xtype : 'textfield',required : true}},
					{text : '证件类型',width : 120,sortable : true,dataIndex : 'identityType',field : {xtype : 'textfield',required : true}},
					{text : '证件号',width : 120,sortable : true,dataIndex : 'identityNum',field : {xtype : 'textfield',required : true}},
					{text : '性别',width : 120,sortable : true,dataIndex : 'sex',field : {xtype : 'textfield',required : true}},
					{text : '名族',width : 120,sortable : true,dataIndex : 'race',field : {xtype : 'textfield',required : true}},
					{text : '驾校数据',width : 120,sortable : true,dataIndex : 'coachData',field : {xtype : 'textfield',required : true}},
					{text : '机构',width : 120,sortable : true,dataIndex : 'organizationId',field : {xtype : 'textfield',required : true}},
					{text : '指纹特征码1',width : 120,sortable : true,dataIndex : 'fingerFeaturesOne',field : {xtype : 'textfield',required : true}},
					{text : '指纹特征码2',width : 120,sortable : true,dataIndex : 'fingerFeaturesTwo',field : {xtype : 'textfield',required : true}},
					{text : 'uuid',width : 120,sortable : true,dataIndex : 'uuid',field : {xtype : 'textfield',required : true}},
					{text : '更新时间',width : 120,sortable : true,dataIndex : 'updateTime',field : {xtype : 'textfield',required : true}},
					{text : '创建时间',width : 120,sortable : true,dataIndex : 'createTime',field : {xtype : 'textfield',required : true}},
					{text : '版本',width : 120,sortable : true,dataIndex : 'version',field : {xtype : 'textfield',required : true}},
					{text : 'objectType',width : 120,sortable : true,dataIndex : 'objectType',field : {xtype : 'textfield',required : true}},
					{text : '用户名',width : 120,sortable : true,dataIndex : 'userName',field : {xtype : 'textfield',required : true}},
					{text : '登录名',width : 120,sortable : true,dataIndex : 'loginName',field : {xtype : 'textfield',required : true}},
					{text : '联系电话',width : 120,sortable : true,dataIndex : 'userTel',field : {xtype : 'textfield',required : true}},
					{text : '手机联系方式',width : 120,sortable : true,dataIndex : 'userMobileTel',field : {xtype : 'textfield',required : true}},
	 	 		
	 	 		{text : 'id',width : 120,sortable : true,dataIndex : 'id',hidden:true}
	 	 		
	],
	initComponent : function() {
	 
		this.createStore();
		 
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
				id:'schoolUserListRowEditor',
				listeners : {
					beforeedit:function( editor,  e,  eOpts ){
					},
					startEdit:function(record, columnHeader ){
			
						this.editRecord=record;
					},
					edit : function(editor, e) {
					 
						e.record.save({
									success : function(schoolUser, options) {
										var data = Ext.decode(options.response.responseText);
										if (data.extra) {
											schoolUser.set('id', data.extra);
										}
										schoolUser.commit();
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

	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.SchoolUserStore');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.SchoolUserModel({
			
		});

		if (records.length > 0){
			// record =	records[records.length-1];
			record= new Fes.model.SchoolUserModel({
			
						picPath:records[records.length-1].data.picPath,
				 	
						userEmail:records[records.length-1].data.userEmail,
				 	
						userBirthday:records[records.length-1].data.userBirthday,
				 	
						lastLoginTime:records[records.length-1].data.lastLoginTime,
				 	
						password:records[records.length-1].data.password,
				 	
						enabled:records[records.length-1].data.enabled,
				 	
						credentialsNonExpired:records[records.length-1].data.credentialsNonExpired,
				 	
						accountNonLocked:records[records.length-1].data.accountNonLocked,
				 	
						accountNonExpired:records[records.length-1].data.accountNonExpired,
				 	
						clientId:records[records.length-1].data.clientId,
				 	
						drivingschoolId:records[records.length-1].data.drivingschoolId,
				 	
						identityType:records[records.length-1].data.identityType,
				 	
						identityNum:records[records.length-1].data.identityNum,
				 	
						sex:records[records.length-1].data.sex,
				 	
						race:records[records.length-1].data.race,
				 	
						coachData:records[records.length-1].data.coachData,
				 	
						organizationId:records[records.length-1].data.organizationId,
				 	
						fingerFeaturesOne:records[records.length-1].data.fingerFeaturesOne,
				 	
						fingerFeaturesTwo:records[records.length-1].data.fingerFeaturesTwo,
				 	
						uuid:records[records.length-1].data.uuid,
				 	
						updateTime:records[records.length-1].data.updateTime,
				 	
						createTime:records[records.length-1].data.createTime,
				 	
						version:records[records.length-1].data.version,
				 	
						objectType:records[records.length-1].data.objectType,
				 	
						userName:records[records.length-1].data.userName,
				 	
						loginName:records[records.length-1].data.loginName,
				 	
						userTel:records[records.length-1].data.userTel,
				 	
						userMobileTel:records[records.length-1].data.userMobileTel,
				 	
 
								});
		}
		
	
		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个uu?',
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

	createToolbar : function() {
		var me = this;
		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : 'ID',
								labelWidth : 40,
								flex : .6,
								id : 'schoolUserId'
							},{
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											id : Ext.getCmp('schoolUserId').getValue()
										}
									});
								}
							}, '-', Ext.create('Ext.Button', {
										text : '添加',
										iconCls : 'icon-add',
										handler : me.addRecord,
										scope : me
									}),  '-', {
								xtype : 'button',
								text : '删除',
								iconCls : 'icon-del',
								handler : me.deleteRecord,
								scope : me
							}]
				});
	}
});