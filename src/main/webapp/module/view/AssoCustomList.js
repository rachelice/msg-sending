console.log('AssoCustomList...');
Ext.require(['Fes.view.UpdateResultList']);
Ext.define('Fes.view.AssoCustomList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.assocustomlist',
	title : '客户信息列表',
	iconCls : 'icon-grid-list',
	rowLines : true,
	columnLines : true,
	simpleSelect : true,
	viewConfig : {
		loadingText : '正在加载客户信息列表'
	},
	columns : [{
				xtype : 'rownumberer'
			},{
				text : '客户号码',
				flex : 1,
				sortable : true,
				dataIndex : 'customid',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '客户姓名',
				flex : 1,
				sortable : true,
				dataIndex : 'customname',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '证件号码',
				flex : 1,
				sortable : true,
				dataIndex : 'idno',
				field : {
					xtype : 'textarea'
				}
			}, {
				text : '证件类型',
				flex : 1,
				sortable : true,
				dataIndex : 'idname',
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
			doRefresh:function(){
		        return false;
		    }
		};

		this.callParent();
	},	
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.AssoCustomStore');
	},	
	searchRecord : function() {
		var acctno = Ext.getCmp('acctno').getValue();
		if(!Ext.isEmpty( Ext.util.Format.trim(acctno))){
			Ext.getCmp('searchButton').setDisabled(1);
			this.store.load({
				params : {
					acctno : Ext.getCmp('acctno').getValue(),
					update : 'search_acctno',
					page: 1,
					start: 0
				}
			});
			var callstore=this.store;
			this.store.on("load", function(callstore){			
				var date =  callstore.getProxy().getReader().rawData ;
				Ext.getCmp('searchButton').setDisabled(0);
				if(date.result){
					Ext.getCmp('updateButton').setDisabled(0);
					if(callstore.getCount()==0)
						{
							Ext.Msg.show({  
					    		title: '客户号码关联',  
					    		msg: '账号无关联客户，是否继续执行客户号码关联？',
					    		buttons: Ext.Msg.YESNO,
					    		icon: 'x-message-box-question',
					    		
					    		fn: function(id){
					    			if(id=='yes'){
					    				showWindow();
					    			}else{
					    				Ext.getCmp('updateButton').setDisabled(1);
					    			}
					    		}
					    	});
						}
					/*if(date.tatal!=0){
			            Ext.getCmp('subsys').setValue(callstore.getAt(0).get('subsys'));
			            Ext.getCmp('oldcustomid').setValue(callstore.getAt(0).get('customid'));						
					}*/
				}else{
					Ext.getCmp('updateButton').setDisabled(1);
					Ext.Msg.show({  
					    title: '客户号码关联',  
					    msg: date.text,
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
			items : ['->', {
						xtype : 'textfield',
						fieldLabel : '账号',
						blankText : '请输入账号',
						labelWidth : 40,
						allowBlank : false,
						width : 400,
						id : 'acctno'
					}, '-', {
						xtype : 'button',
						text : '查询',
						iconCls : 'icon-search',
						id:'searchButton',
						handler : me.searchRecord,
						scope : me
					},'-',{
						xtype : 'button',
						text : '关联',
						id : 'updateButton',
						disabled : true,
						iconCls : 'icon-refresh',
						handler : function() {  
		                    showWindow();      
		                }
					},'-'/*, {
						xtype : 'textfield',
						text: 'SUBSYS',
						flex : 1,
						hidden:true,
						id : 'subsys'
					}, {
						xtype : 'textfield',
						text: 'oldcustomid',
						flex : 1,
						hidden:true,
						id : 'oldcustomid'
					}*/]
		});
	}
});

ModifyWin = Ext.extend(Ext.util.Observable,{
	extend :  Ext.util.Observable, 
	alertWin : null,  
	alertPanel : null,  
	field : null,

	constructor:function() {  
		this.alertPanel = new Fes.view.UpdateResultList; 
		this.alertWin = Ext.create('Ext.window.Window', {  
			modal:true,                   
			title:pageVar.alertPanelTitle,         
			layout: 'fit',  
			width: 600,  
			height: 400,  
			items: this.alertPanel ,
			constrain:true,
			shrinkWrap:3,  
			closeAction:'destroy',
			listeners:{
				destroy : function(){
					Ext.getCmp('updateButton').setDisabled(1);
				}
			}
	});          
	},  

	show: function() {
		this.alertWin.show();  
	}
});

var modifyWin = null;   

var pageVar={};
pageVar.alertPanel='Fes.view.UpdateResultList';
pageVar.alertPanelTitle='客户号码关联';



var showWindow = function( btn ) {  

  if(modifyWin!=null) {
	  Ext.util.Observable.releaseCapture(modifyWin);
  }  
  modifyWin = new ModifyWin(); 
  modifyWin.show();
};