console.log('UpdateResultList...');
Ext.define('Fes.view.UpdateResultList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.updateresultlist',
	title : '更新记录信息列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	multiSelect : true,
	simpleSelect : true,
	header:false,
	viewConfig : {
		loadingText : '正在加载更新记录信息列表'
	},
	columns : [{
				xtype : 'rownumberer'
			},{
				text : '英文表名',
				flex : 1,
				sortable : true,
				dataIndex : 'tablename_en',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '中文表名',
				flex : 1,
				sortable : true,
				dataIndex : 'tablename_zh',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '更新记录行数',
				flex : 1,
				sortable : true,
				dataIndex : 'count',
				field : {
					xtype : 'textarea'
				}
			}],
	initComponent : function() {	 
		this.createStore();	
		this.tbar = this.createToolbar();
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true,
			id:'pagebar'
		};
		this.callParent();
	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.AssoCustomStore');
	},
	updateRecord : function() {
		var newcustomid=Ext.getCmp('newcustomid').getValue();
		if(!Ext.isEmpty( Ext.util.Format.trim(newcustomid))){
			Ext.getCmp('result_updateButton').setDisabled(1);
			this.store.load({
				params : {
					newcustomid : Ext.getCmp('newcustomid').getValue(),
					acctno: Ext.getCmp('acctno').getValue(),
					update : 'search_customid',
					page: 1,
					start: 0
				}
			});
			var callstore=this.store;
			this.store.on("load", function(callstore){
				var data_s =  callstore.getProxy().getReader().rawData ;
				Ext.getCmp('result_updateButton').setDisabled(0);
				if(data_s.result){
					if(data_s.tatal!=0){
						if(callstore.getAt(0).get('tablename_en')){
   							Ext.Msg.show({  
   								title: '客户号码关联',  
   								msg: "<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;关联完成！", 
   								buttons: Ext.Msg.OK,
   								icon: 'x-message-box-ok'
   							});
						}else{
   							var info='&nbsp;新客户号码：'+callstore.getAt(0).get('customid')+'<br>'
   								+'----------------------------------------------------<br>'
   								+'&nbsp;&nbsp;&nbsp;&nbsp;客户姓名：'+callstore.getAt(0).get('customname')+'<br>'
   								+'&nbsp;&nbsp;&nbsp;&nbsp;证件号码：'+callstore.getAt(0).get('idno')+'<br>'
   								+'&nbsp;&nbsp;&nbsp;&nbsp;证件类型：'+callstore.getAt(0).get('idname')+'<br>'+'<br>'
   								+'&nbsp;确认要关联新客户号码？'+'<br>'+'<br>';
   							
   							Ext.MessageBox.show({
   								title: '客户号码关联',
   								msg: info,
   								width:400,
   								closable:false,
   								icon: 'x-message-box-question',	            
   								buttons: Ext.Msg.YESNO,
				          
   								fn: function(id){
   									if(id=='yes'){
   										callstore.load({
   											params : {
// 												userid : Ext.getCmp('logon_userid').getText(),
   												newcustomid : Ext.getCmp('newcustomid').getValue(),
   												acctno: Ext.getCmp('acctno').getValue(),
   												update : 'update',
   												page: 1,
   												start: 0
   											}
   										});
   									}else{
   										callstore.removeAll();
   										Ext.getCmp('pagebar').doRefresh();
   									}
   								}         
   							});
   							callstore.removeAll();
   							Ext.getCmp('pagebar').doRefresh();
						}
					}
				}else{
					Ext.Msg.show({  
					    title: '客户号码关联',  
					    msg: data_s.text,  
					    buttons: Ext.Msg.OK,
					    icon: 'x-message-box-warning'
					}); 
				}
	        });
		}

	},
	createToolbar : function() {
		var me = this;

		return Ext.create('Ext.toolbar.Toolbar', {
			items : [{
						xtype : 'textfield',
						fieldLabel : '新客户号',
						blankText : '请输入新客户号',
						labelWidth : 65,
						allowBlank : false,
						flex : 1,
						id : 'newcustomid'
					}, '-',{
						xtype : 'button',
						text : '关联',
						id : 'result_updateButton',
						disabled : false,
						iconCls : 'icon-refresh',
						handler : me.updateRecord,
						scope : me
					}, '-']
		});
	}
});