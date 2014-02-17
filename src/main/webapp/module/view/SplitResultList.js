console.log('SplitResultList...');
Ext
.define(
		'Fes.view.SplitResultList',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.splitresultlist',
			title : '拆分记录信息列表',
			iconCls : 'icon-grid-list',
			rowLines : true,
			columnLines : true,
			multiSelect : true,
			simpleSelect : true,
			header : false,
			viewConfig : {
				loadingText : '拆分记录信息列表'
			},
			columns : [
			           {
			        	   xtype : 'rownumberer'
			           },
			           {
			        	   text : '拆分标志',
			        	   flex : 1,
			        	   sortable : true,
			        	   dataIndex : 'splitflag',
			        	   renderer : function(v, m) {
			        		   if (v == '1') {
			        			   return '1 - 按子系统';
			        		   }
			        		   if (v == '2') {
			        			   return '2 - 按科目';
			        		   }
			        		   if (v == '3') {
			        			   return '3 - 按帐户';
			        		   }
			        	   },
			        	   field : {
			        		   store : Ext
			        		   .create(
			        				   'Ext.data.Store',
			        				   {
			        					   fields : [ 'value',
			        					              'text' ],
			        					              data : eval("[{'value':'1', 'text':'1 - 按子系统'},"
			        					            		  + "{'value':'2', 'text':'2 - 按科目'},"
			        					            		  + "{'value':'3', 'text':'3 - 按帐户'}]")
			        				   }),
			        				   queryMode : 'local',
			        				   displayField : 'text',
			        				   valueField : 'value',
			        				   xtype : 'combobox',
			        				   triggerAction : 'all',
			        				   editable : false,
			        				   blankText : '请选择...',
			        				   emptyText : "请选择...",
			        	   }
			           },
			           {
			        	   text : '子系统',
			        	   flex : 1,
			        	   sortable : true,
			        	   dataIndex : 'subsys',
			        	   renderer : function(v, m) {
			        		   if (v == '1') {
			        			   return 'DSS - 活期存款';
			        		   }
			        		   if (v == '2') {
			        			   return 'DST - 定期存款';
			        		   }
			        		   if (v == '3') {
			        			   return 'SHS - 股金';
			        		   }
			        		   if (v == '4') {
			        			   return 'LNS - 贷款';
			        		   }
			        		   if (v == '5') {
			        			   return 'GLS - 内部账';
			        		   }
			        	   },
			        	   field : {
			        		   store : Ext
			        		   .create(
			        				   'Ext.data.Store',
			        				   {
			        					   fields : [ 'value',
			        					              'text' ],
			        					              data : eval("[{'value':'1', 'text':'DSS - 活期存款'},"
			        					            		  + "{'value':'2', 'text':'DST - 定期存款'},"
			        					            		  + "{'value':'3', 'text':'SHS - 股金'},"
			        					            		  + "{'value':'4', 'text':'LNS - 贷款'}"
			        					            		  + ",{'value':'5', 'text':'GLS - 内部账'}]")
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
			        	   text : '科目',
			        	   flex : 1,
			        	   sortable : true,
			        	   dataIndex : 'subctrlcode',
			        	   field : {
			        		   xtype : 'textarea'
			        	   }
			           }, {
			        	   text : '账号',
			        	   flex : 1,
			        	   sortable : true,
			        	   dataIndex : 'acctno',
			        	   field : {
			        		   xtype : 'textarea'
			        	   }
			           } ],
			           initComponent : function() {
			        	   this.createStore();

			        	   this.rowEditor = Ext
			        	   .create(
			        			   'Ext.grid.plugin.CellEditing',
			        			   {
			        				   id : 'splitListRowEditor',
			        				   clicksToEdit : 1,
			        				   listeners : {
			        					   beforeedit : function(editor,
			        							   e, eOpts) {
			        						   if ((e.record.data.splitflag == 2)
			        								   && (e.field == 'acctno')) {
			        							   e.data.cancel = true;
			        						   }
			        						   if ((e.record.data.splitflag == 3)
			        								   && (e.field == 'subctrlcode')) {
			        							   e.data.cancel = true;
			        						   }
			        					   },
			        					   startEdit : function(record,
			        							   columnHeader) {
			        						   this.editRecord = record;
			        					   },
			        					   edit : function(editor, e) {
			        						   if (e.field == 'splitflag') {
			        							   if (Ext
			        									   .isEmpty(e.record.data.splitflag)) {
			        								   var celledit = this;
			        								   Ext.Msg
			        								   .show({
			        									   title : '提示',
			        									   msg : '拆分标志  不能为空！',
			        									   buttons : Ext.Msg.OK,
			        									   icon : 'x-message-box-warning',
			        									   fn : function() {
			        										   celledit
			        										   .startEdit(
			        												   e.record,
			        												   1);
			        									   }
			        								   });
			        							   } else {
			        								   if (e.record.data.splitflag == 2) {
			        									   e.record.data.acctno = '';
			        									   e.record
			        									   .commit();
			        								   }
			        								   if (e.record.data.splitflag == 3) {
			        									   e.record.data.subctrlcode = '';
			        									   e.record
			        									   .commit();
			        								   }
			        								   this
			        								   .startEdit(
			        										   e.record,
			        										   2);
			        							   }
			        							   return;
			        						   }
			        						   if (e.field == 'subsys') {
			        							   if (Ext
			        									   .isEmpty(e.record.data.subsys)) {
			        								   var celledit = this;
			        								   Ext.Msg
			        								   .show({
			        									   title : '提示',
			        									   msg : '子系统  不能为空！',
			        									   buttons : Ext.Msg.OK,
			        									   icon : 'x-message-box-warning',
			        									   fn : function() {
			        										   celledit
			        										   .startEdit(
			        												   e.record,
			        												   2);
			        									   }
			        								   });
			        							   } else {
			        								   if (e.record.data.splitflag == 2) {
			        									   this
			        									   .startEdit(
			        											   e.record,
			        											   3);
			        								   } else if (e.record.data.splitflag == 3) {
			        									   this
			        									   .startEdit(
			        											   e.record,
			        											   4);
			        								   } else {
			        									   e.record
			        									   .commit();
			        								   }
			        							   }
			        							   return;
			        						   }

			        						   if (e.field == 'subctrlcode') {
			        							   if ((e.record.data.splitflag == 2)
			        									   && Ext
			        									   .isEmpty(e.record.data.subctrlcode)) {
			        								   var celledit = this;
			        								   Ext.Msg
			        								   .show({
			        									   title : '提示',
			        									   msg : '科目  不能为空！',
			        									   buttons : Ext.Msg.OK,
			        									   icon : 'x-message-box-warning',
			        									   fn : function() {
			        										   celledit
			        										   .startEdit(
			        												   e.record,
			        												   3);
			        									   }
			        								   });
			        							   }else if(e.record.data.subctrlcode.length > 10){
			        									   var celledit = this;
				        								   Ext.Msg
				        								   .show({
				        									   title : '提示',
				        									   msg : '科目   至多输入10位！',
				        									   buttons : Ext.Msg.OK,
				        									   icon : 'x-message-box-warning',
				        									   fn : function() {
				        										   celledit
				        										   .startEdit(
				        												   e.record,
				        												   3);
				        									   }
				        								   });
			        							   } else {
			        								   e.record.commit();
			        							   }
			        							   return;
			        						   }

			        						   if (e.field == 'acctno') {
			        							   var r = /^\d+$/;
			        							   if ((e.record.data.splitflag == 3)
			        									   && Ext
			        									   .isEmpty(e.record.data.acctno)) {
			        								   var celledit = this;
			        								   Ext.Msg
			        								   .show({
			        									   title : '提示',
			        									   msg : '账号  不能为空！',
			        									   buttons : Ext.Msg.OK,
			        									   icon : 'x-message-box-warning',
			        									   fn : function() {
			        										   celledit
			        										   .startEdit(
			        												   e.record,
			        												   4);
			        									   }
			        								   });
			        							   }else if(e.record.data.acctno.length > 32){
		        									   var celledit = this;
			        								   Ext.Msg
			        								   .show({
			        									   title : '提示',
			        									   msg : '账号   至多输入32位！',
			        									   buttons : Ext.Msg.OK,
			        									   icon : 'x-message-box-warning',
			        									   fn : function() {
			        										   celledit
			        										   .startEdit(
			        												   e.record,
			        												   4);
			        									   }
			        								   });
			        							   }else if(!r.test(e.record.data.acctno)){
		        									   var celledit = this;
			        								   Ext.Msg
			        								   .show({
			        									   title : '提示',
			        									   msg : '账号   只能输入数字！',
			        									   buttons : Ext.Msg.OK,
			        									   icon : 'x-message-box-warning',
			        									   fn : function() {
			        										   celledit
			        										   .startEdit(
			        												   e.record,
			        												   4);
			        									   }
			        								   });
			        							   } else {
			        								   e.record.commit();
			        							   }
			        							   return;
			        						   }

			        					   }
			        				   }
			        			   });
			        	   this.plugins = [ this.rowEditor ];
			        	   this.tbar = this.createToolbar();
			        	   this.callParent();
			           },
			           createStore : function() {
			        	   var me = this;
			        	   me.store = Ext.create('Fes.store.BranchsMSStore');
			           },
			           getSplitStore : function() {
			        	   return this.getStore();
			           },
			           deleteRecord : function() {
			        	   var me = this;
			        	   var records = this.getSelectionModel().getSelection();
			        	   if (records.length > 0) {
			        		   Fes.MsgBox.confirm('确定删除这' + records.length
			        				   + '条记录?', function(btn) {
			        			   Ext.each(records, function(record) {
			        				   me.getStore().remove(record);
			        			   });
			        		   });
			        	   } else {
			        		   /*
			        		    * Ext.MessageBox.show({ title : "提示", msg : "至少选择
			        		    * 一条记录!" // icon: Ext.MessageBox.INFO });
			        		    */
			        		   Ext.MessageBox.alert("提示", "至少选择 一条记录!");
			        	   }

			           },
			           addRecord : function() {
			        	   var count = this.getStore().getCount();
			        	   if (count == 0) {
			        		   prodate = Ext.getCmp('SPLIT_PRODATE').isValid();
			        		   probrc = Ext.getCmp('SPLIT_PROBRC').isValid();
			        		   promode = Ext.getCmp('SPLIT_PROMODE').isValid();
			        		   oppbrc = Ext.getCmp('SPLIT_OPPBRC').isValid();
			        		   modidate = Ext.getCmp('SPLIT_MODIDATE').isValid();
			        		   if (!prodate || !probrc
			        				   || !promode || !oppbrc || !modidate ) {
			        			   Ext.Msg.show({
			        				   title : '提示',
			        				   msg : '以上均为必填项，请根据提示正确填写！',
			        				   buttons : Ext.Msg.OK,
			        				   icon : 'x-message-box-warning'
			        			   });
			        			   return;
			        		   }
			        	   }

			        	   var record = new Fes.model.BranchsMSModel();
			        	   this.getStore().add(record);
			        	   this.rowEditor.startEdit(record, 1);
			           },
			           createToolbar : function() {
			        	   var me = this;
			        	   var pageVar = {};
			        	   pageVar.SRC_LOC_Y = 5; // Panel中item项的起始点的x
			        	   pageVar.SRC_LOC_X = 5; // Panel中item项的起始点的y
			        	   pageVar.EACH_DIST_Y = 30; // 上下两个Item之间的距离
			        	   pageVar.vWidth = 200; // 标签的整体宽度
			        	   pageVar.vFieldW = 130; // 标签空白内容的宽度
			        	   pageVar.LABEL_WIDTH = 55; // item项的标签的默认宽度
			        	   pageVar.PROMODEStore = eval("[{'value':'1', 'text':'撤并'},{'value':'2', 'text':'拆分'}]");
			        	   pageVar.PROFLAGStore = eval("[{'value':'0', 'text':'0 - 未处理'},{'value':'1', 'text':'1 - 已处理'}]");
			        	   var PROMODEStore = Ext.create('Ext.data.Store', {
			        		   fields : [ 'value', 'text' ],
			        		   data : pageVar.PROMODEStore
			        	   });

			        	   var PROFLAGStore = Ext.create('Ext.data.Store', {
			        		   fields : [ 'value', 'text' ],
			        		   data : pageVar.PROFLAGStore
			        	   });
			        	   var count = -1;
			        	   return Ext
			        	   .create(
			        			   'Ext.toolbar.Toolbar',
			        			   {
			        				   layout : 'absolute',
			        				   items : [
			        				            {
			        				            	xtype : 'datefield',
			        				            	format : 'Y-m-d',
			        				            	fieldLabel : '处理日期',
			        				            	allowBlank : false,
			        				            	editable : false,
			        				            	id : 'SPLIT_PRODATE',
			        				            	fieldWidth : pageVar.vFieldW,
			        				            	width : pageVar.vWidth,
			        				            	labelWidth : pageVar.LABEL_WIDTH,
			        				            	labelAlign : 'right',
			        				            	x : pageVar.SRC_LOC_X,
			        				            	y : pageVar.SRC_LOC_Y
			        				            	+ pageVar.EACH_DIST_Y
			        				            	* (++count)
			        				            },
			        				            {
			        				            	xtype : 'textfield',
			        				            	fieldLabel : '处理机构',
			        				            	allowBlank : false,
			        				            	maxLength : 9,
			        				            	maxLengthText : '至多输入9位数',
			        				            	regex : /^\d+$/,
			        				            	regexText : '只能输入数字',
			        				            	id : 'SPLIT_PROBRC',
			        				            	fieldWidth : pageVar.vFieldW,
			        				            	labelWidth : pageVar.LABEL_WIDTH,
			        				            	width : pageVar.vWidth,
			        				            	labelAlign : 'right',
			        				            	x : pageVar.SRC_LOC_X
			        				            	+ pageVar.vWidth
			        				            	+ 10,
			        				            	y : pageVar.SRC_LOC_Y
			        				            	+ pageVar.EACH_DIST_Y
			        				            	* (count) // 此行放置了两个item，所以count无需增加
			        				            },
			        				            {
			        				            	store : PROMODEStore,
			        				            	queryMode : 'local',
			        				            	displayField : 'text',
			        				            	valueField : 'value',
			        				            	xtype : 'combobox',
			        				            	fieldLabel : '撤并方式',
			        				            	emptyText : "请选择...",
			        				            	editable : false,
			        				            	allowBlank : false,
			        				            	id : 'SPLIT_PROMODE',
			        				            	labelAlign : 'right',
			        				            	fieldWidth : pageVar.vFieldW,
			        				            	labelWidth : pageVar.LABEL_WIDTH,
			        				            	width : pageVar.vWidth,
			        				            	x : pageVar.SRC_LOC_X,
			        				            	y : pageVar.SRC_LOC_Y
			        				            	+ pageVar.EACH_DIST_Y
			        				            	* (++count),
			        				            	listeners : {
			        				            		"select" : function(
			        				            				c, r, e) {
			        				            			if (r[0].data.value == 2) {
			        				            				Ext
			        				            				.getCmp(
			        				            				'splitresult_addButton')
			        				            				.setDisabled(
			        				            						0);
			        				            				Ext
			        				            				.getCmp(
			        				            				'splitresult_delButton')
			        				            				.setDisabled(
			        				            						0);
			        				            			} else {
			        				            				var count = me
			        				            				.getStore()
			        				            				.getCount();
			        				            				if (count != 0) {
			        				            					Ext.Msg
			        				            					.show({
			        				            						title : '客户号码关联',
			        				            						msg : '确定将撤并方式改为 “撤并” ，并且删除这'
			        				            							+ count
			        				            							+ '条拆分记录?',
			        				            							buttons : Ext.Msg.YESNO,
			        				            							closable : false,
			        				            							icon : 'x-message-box-question',
			        				            							fn : function(
			        				            									id) {
			        				            								if (id == 'yes') {
			        				            									me
			        				            									.getStore()
			        				            									.removeAll();
			        				            								} else {
			        				            									Ext
			        				            									.getCmp(
			        				            									'SPLIT_PROMODE')
			        				            									.setValue(
			        				            									'2');
			        				            									Ext
			        				            									.getCmp(
			        				            									'splitresult_addButton')
			        				            									.setDisabled(
			        				            											0);
			        				            									Ext
			        				            									.getCmp(
			        				            									'splitresult_delButton')
			        				            									.setDisabled(
			        				            											0);
			        				            								}
			        				            							}
			        				            					});
			        				            				}
			        				            				Ext
			        				            				.getCmp(
			        				            				'splitresult_addButton')
			        				            				.setDisabled(
			        				            						1);
			        				            				Ext
			        				            				.getCmp(
			        				            				'splitresult_delButton')
			        				            				.setDisabled(
			        				            						1);
			        				            			}
			        				            		}
			        				            	}
			        				            },
			        				            {
			        				            	xtype : 'textfield',
			        				            	fieldLabel : '拆并顺序',
			        				            	emptyText : "1",
			        				            	readOnly : true,
			        				            	id : 'SPLIT_SEQ',
			        				            	fieldWidth : pageVar.vFieldW,
			        				            	width : pageVar.vWidth,
			        				            	labelWidth : pageVar.LABEL_WIDTH,
			        				            	labelAlign : 'right',
			        				            	x : pageVar.SRC_LOC_X
			        				            	+ pageVar.vWidth
			        				            	+ 10,
			        				            	y : pageVar.SRC_LOC_Y
			        				            	+ pageVar.EACH_DIST_Y
			        				            	* (count)
			        				            },
			        				            {
			        				            	xtype : 'textfield',
			        				            	fieldLabel : '并入机构',
			        				            	allowBlank : false,
			        				            	maxLength : 9,
			        				            	maxLengthText : '至多输入9位数',
			        				            	regex : /^\d+$/,
			        				            	regexText : '只能输入数字',
			        				            	id : 'SPLIT_OPPBRC',
			        				            	labelAlign : 'right',
			        				            	fieldWidth : pageVar.vFieldW,
			        				            	labelWidth : pageVar.LABEL_WIDTH,
			        				            	width : pageVar.vWidth,
			        				            	x : pageVar.SRC_LOC_X,
			        				            	y : pageVar.SRC_LOC_Y
			        				            	+ pageVar.EACH_DIST_Y
			        				            	* (++count) //此行放置了两个item，所以count无需增加  

			        				            },
			        				            {
			        				            	xtype : 'datefield',
			        				            	format : 'Y-m-d',
			        				            	fieldLabel : '维护日期',
			        				            	allowBlank : false,
			        				            	editable : false,
			        				            	id : 'SPLIT_MODIDATE',
			        				            	fieldWidth : pageVar.vFieldW,
			        				            	width : pageVar.vWidth,
			        				            	labelWidth : pageVar.LABEL_WIDTH,
			        				            	labelAlign : 'right',
			        				            	x : pageVar.SRC_LOC_X
			        				            	+ pageVar.vWidth
			        				            	+ 10,
			        				            	y : pageVar.SRC_LOC_Y
			        				            	+ pageVar.EACH_DIST_Y
			        				            	* (count)
			        				            },
			        				            {
			        				            	xtype : 'textfield',
			        				            	fieldLabel : '操作人员',
			        				            	readOnly : true,
			        				            	emptyText : "zzzz",
			        				            	id : 'SPLIT_TELLER',
			        				            	labelAlign : 'right',
			        				            	fieldWidth : pageVar.vFieldW,
			        				            	labelWidth : pageVar.LABEL_WIDTH,
			        				            	width : pageVar.vWidth,
			        				            	x : pageVar.SRC_LOC_X,
			        				            	y : pageVar.SRC_LOC_Y
			        				            	+ pageVar.EACH_DIST_Y
			        				            	* (++count) //此行放置了两个item，所以count无需增加  

			        				            },
			        				            {
			        				            	store : PROFLAGStore,
			        				            	queryMode : 'local',
			        				            	displayField : 'text',
			        				            	valueField : 'value',
			        				            	xtype : 'combobox',
			        				            	fieldLabel : '处理标志',
			        				            	emptyText : "0 - 未处理",
			        				            	readOnly : true,
			        				            	id : 'SPLIT_PROFLAG',
			        				            	fieldWidth : pageVar.vFieldW,
			        				            	width : pageVar.vWidth,
			        				            	labelWidth : pageVar.LABEL_WIDTH,
			        				            	labelAlign : 'right',
			        				            	x : pageVar.SRC_LOC_X
			        				            	+ pageVar.vWidth
			        				            	+ 10,
			        				            	y : pageVar.SRC_LOC_Y
			        				            	+ pageVar.EACH_DIST_Y
			        				            	* (count)
			        				            },
			        				            {
			        				            	xtype : 'button',
			        				            	text : '添加',
			        				            	id : 'splitresult_addButton',
			        				            	disabled : true,
			        				            	iconCls : 'icon-add',
			        				            	handler : me.addRecord,
			        				            	scope : me,
			        				            	labelAlign : 'right',
			        				            	x : pageVar.SRC_LOC_X
			        				            	+ pageVar.vWidth
			        				            	+ 100,
			        				            	y : pageVar.SRC_LOC_Y
			        				            	+ pageVar.EACH_DIST_Y
			        				            	* (++count)
			        				            },
			        				            {
			        				            	xtype : 'button',
			        				            	text : '删除',
			        				            	id : 'splitresult_delButton',
			        				            	disabled : true,
			        				            	iconCls : 'icon-del',
			        				            	handler : me.deleteRecord,
			        				            	scope : me,
			        				            	x : pageVar.SRC_LOC_X
			        				            	+ pageVar.vWidth
			        				            	+ 160,
			        				            	y : pageVar.SRC_LOC_Y
			        				            	+ pageVar.EACH_DIST_Y
			        				            	* (count)
			        				            } ]
			        			   });
			           }
		});