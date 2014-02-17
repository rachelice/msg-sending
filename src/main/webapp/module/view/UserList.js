console.log('UserList...');
// Ext.require(['Fes.view.DeptComboTree']);
Ext.require(['Fes.util.RoleCombox']);
Ext.require(['Fes.util.NxbranchCombox']);

userlistinit = false;
Ext.define('Fes.view.UserList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.userlist',
	title : '角色列表',

	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载人员列表'
	},
	createRoleCombox : function() {

	},
	columns : [{
				xtype : 'rownumberer'
			}, {
				text : '姓名',
				width : 120,
				sortable : true,
				dataIndex : 'username',
				field : {
					xtype : 'textfield',
					required : true
				}
			}, {
				text : '登录名',
				width : 120,
				sortable : true,
				dataIndex : 'loginName',
				field : {
					xtype : 'textfield',
					required : true
				}
			}, {
				text : '密码',
				width : 240,
				sortable : true,
				dataIndex : 'password',
				field : {
					xtype : 'textfield',
					required : true
				}
			},
			/*
			 * {text : '机构',width : 260,sortable : true,dataIndex :
			 * 'deptName',field : {xtype:'deptComboTree', fieldLabel: '机构',
			 * labelWidth: 40, rootText : '总行', rootId:'0', expanded:true,
			 * storeUrl : 'depts/deptTreeJSON', id:'userlist'+'DeptComboTree',
			 * selectMode:'all', treeHeight:600, //width : 300,
			 * rootVisible:true,
			 * 
			 * listeners : { "select" :function(){
			 * //alert(Ext.getCmp('cmbJS').getValue());
			 * //Ext.getCmp('cmbJS').getValue(); } } } } ,
			 */
			{
				text : '机构',
				width : 300,
				sortable : false,
				dataIndex : 'deptName',
				field : {
					xtype : 'nxbranchCombox',
					fieldLabel : '机构',
					labelWidth : 40,
					id : 'brccode'
				}
			},

			{
				text : '角色',
				width : 180,
				sortable : false,
				dataIndex : 'roleName',
				field : {
					xtype : 'roleCombox',
					valueField : 'id',
					displayField : 'name',
					id : 'userlist' + 'RoleCombox',
					allText : '全选',// 默认字符是All
					addAllSelector : true
				}
			}, {
				text : 'email',
				width : 150,
				sortable : true,
				dataIndex : 'email',
				field : {
					xtype : 'textfield',
					required : true
				}
			}],
	// store : [Ext.create('Fes.hr.user.Store')],
	listeners : {
		hide : function(panel, o) {

		}

	},
	initComponent : function() {

		this.createStore();

		if (!userlistinit) {

		}
		userlistinit = true;
		this.rowEditor = Ext.create('Ext.grid.plugin.RowEditing', {
			id : 'userListRowEditor',
			listeners : {
				beforeedit : function(editor, e, eOpts) {

					if (Ext.getCmp('cmbJS')) {

						// Ext.remove(Ext.getCmp('cmbJS'));
					}
				},
				startEdit : function(record, columnHeader) {
					// Ext.Msg.alert('11',Ext.JSON.encode(record));
					this.editRecord = record;
				},
				edit : function(editor, e) {
					// password md5 encode
					if (e.originalValues.password != e.record.data.password) {
						e.record.data.password = CryptoJS
								.MD5(e.record.data.password).toString();
					}

					if (e.originalValues.roleName != e.record.data.roleName) {
						e.record.data.roleId = Ext.getCmp('userlist'
								+ 'RoleCombox').getValue();
						e.record.data.roleName = Ext.getCmp('userlist'
								+ 'RoleCombox').getRawValue();

					}
					/*
					 * if(e.originalValues.deptName!=e.record.data.deptName){
					 * 
					 * 
					 * //Ext.Msg.alert('11',Ext.JSON.encode(Ext.getCmp('userlist'+'DeptComboTree').getValue()));
					 * e.record.data.deptId=Ext.getCmp('userlist'+'DeptComboTree').getValue();
					 * e.record.data.deptName=Ext.getCmp('userlist'+'DeptComboTree').getTreeValue().data.text; }
					 */
					if (Ext.util.Format.trim(e.originalValues.deptName) != Ext.util.Format
							.trim(e.record.data.deptName)) {

						// Ext.Msg.alert('11',Ext.JSON.encode(Ext.getCmp('userlist'+'DeptComboTree').getValue()));
						e.record.data.deptId = Ext.getCmp('brccode').getValue();
						e.record.data.deptName = Ext.getCmp('brccode')
								.getRawValue();

					}
					// alert( e.record.data.deptName);

					// alert(e.record.data.roleId+e.record.data.roleName);
					/*
					 * var callstore=this.store; var date =
					 * callstore.getProxy().getReader().rawData;
					 */
					e.record.save({
								success : function(user, options) {
									var me = this;
									
									var data = Ext
											.decode(options.response.responseText);
									if (data.extra) {
										user.set('id', data.extra);
									};
									if (data.failure) {
										Ext.Msg.show({
											title : '添加新员工',
											msg : data.text,
											buttons : Ext.Msg.OK,
											icon : 'x-message-box-warning'										
										});
										this.store.remove(e.record);
									}else{
										user.set('id', data.extra);
										user.commit();
									};
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
		me.store = Ext.create('Fes.store.UserStore');
	},

	addRecord : function() {
		var records = this.getSelectionModel().getSelection();
		var record = new Fes.model.UserModel({
					name : '新建角色'
				});
		console.log(records.length);
		if (records.length > 0) {
			// record = records[records.length-1];
			record = new Fes.model.UserModel({
						name : '新建角色',
						password : records[records.length - 1].data.password,
						roleId : records[records.length - 1].data.roleId,
						deptId : records[records.length - 1].data.deptId,
						roleName : records[records.length - 1].data.roleName,
						deptName : records[records.length - 1].data.deptName
					});
		}

		this.getStore().add(record);
		this.rowEditor.startEdit(record, 1);
	},

	deleteRecord : function() {
		var me = this;
		var records = this.getSelectionModel().getSelection();
		if (records.length > 0) {
			Fes.MsgBox.confirm('确定删除这' + records.length + '个用户?',
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
		} else {
			/*
			 * Ext.MessageBox.show({ title : "提示", msg : "至少选择 一条记录!" // icon:
			 * Ext.MessageBox.INFO });
			 */
			Ext.MessageBox.alert("提示", "至少选择 一条记录!");
		}

	},

	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
					items : [{
								xtype : 'textfield',
								fieldLabel : '名称',
								labelWidth : 40,
								flex : .6,
								id : 'user_name'
							}, '-', {
								xtype : 'textfield',
								fieldLabel : '登录名',
								labelWidth : 60,
								id : 'login_name',
								flex : .6
							}, '-', {
								xtype : 'button',
								text : '查询',
								iconCls : 'icon-search',
								handler : function() {
									me.getStore().load({
										params : {
											loginName : Ext
													.getCmp('login_name')
													.getValue(),
											userName : Ext.getCmp('user_name')
													.getValue()
										}
									});
								}
							}, '-', Ext.create('Ext.Button', {
										text : '添加',
										iconCls : 'icon-add',
										handler : me.addRecord,
										scope : me
									}), Ext.create('Fes.util.RoleCombox', {

										valueField : 'id',
										displayField : 'name',
										id : 'box2',

										allText : '全选',// 默认字符是All

										addAllSelector : true
									}), '-', {
								xtype : 'button',
								text : '删除',
								iconCls : 'icon-del',
								handler : me.deleteRecord,
								scope : me
							}]
				});
	}
});