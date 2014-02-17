console.log('RealErrorlogList...');
Ext.define('Fes.view.RealErrorlogList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.realerrorloglist',
	title : '异常信息列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
//	multiSelect : true,
//	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载异常信息列表'
	},
	columns : [{
				xtype : 'rownumberer'
			}, {
				text : '终端系统',
				width : 150,
				sortable : true,
				dataIndex : 'terminal',
				field : {
					xtype : 'textfield'
				}
			}, {
				text : '发生时间',
				width : 150,
				sortable : true,
				dataIndex : 'occurdate',
				renderer : Ext.util.Format.dateRenderer('Y-m-d H:i:s')
			}, {
				text : '异常信息描述',
				flex : 1,
				sortable : true,
				dataIndex : 'description',
				field : {
					xtype : 'textarea'
				}
			}],
			
	listeners : {		
		hide:function(panel,o){
			
		},
		itemdblclick:function( view,  record,   item,   index,   e,   eOpts ){
			
			var info='异常终端：'+record.data.terminal+'<br>'+'<br>'+'异常时间：'+Ext.util.Format.date(record.data.occurdate,'Y-m-d H:i:s');
			info+='<br>异常信息：<lable   style="width:10;overflow-x:visible;overflow-y:visible;"><br>'+'&nbsp&nbsp&nbsp&nbsp'+record.data.description+'</label>';
			var paneldata=this.getStore();

			 Ext.MessageBox.show({
		           title: '异常信息详细情况',
		           msg: info,
		           width:400,
		           closable:false,
		           icon: 'x-message-box-warning',	            
		           buttons: Ext.MessageBox.OK,
		          
		           fn: function(){
		        	   console.log('record1='+Ext.encode(record.data));
		        	   var newRecord=Ext.create('Fes.model.RealErrorlogModelUpdate',{'id':record.data.id});
		        	   newRecord.save({
							success : function(user, options) {
								paneldata.load();
							}
						});
		           }
			  });
		},
		beforeclose: function() { 
			clearInterval(this.intervalid);
		}
	},
	initComponent : function() {	 
		this.createStore();		 
		this.bbar = {
			xtype : 'pagingtoolbar',
			store : this.store,
			displayInfo : true
		};
		this.refresh();
		this.callParent();
	},
	showWin:function(){this.win.show();},
	hideWin:function(){this.win.hide();},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.RealErrorlogStore');
	},
	refresh : function (){
		var datastore=this.getStore();
		var reloadStore=function(){
			datastore.load();
		};
		me=this;
		me.intervalid=setInterval(reloadStore,15000);			
	}
});