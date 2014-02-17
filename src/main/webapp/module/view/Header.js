Ext.define('Fes.view.Header', {
	extend : 'Ext.panel.Panel',
	 
	 
	collapsible:true,  
	//xtype: 'box',
    region: 'north',
    height: 70,
   // html: '<div style= "">CMDS - 部门综合管理系统 <div>',//Comprehensive management department System
	region : 'north',
	split : true,
	
	dockedItems: [{
	    xtype: 'toolbar',
	    dock: 'bottom',
	    height:42,
	    style : 'background:#157fCC',  
	   // frame:true,
	    
	    items: [
{
	 
	 xtype:'label',
	 html:'<div style= "font-size:20px;color:#FFFFFF;font-family:黑体;font-weight:bolder; ">DE Msg-Sending <div>',   
     
	 
	flex : .9
},
 
{
	id : 'logon_userid',
	 
	hidden : true
}, '->',{
	iconCls : 'icon-user',
	 xtype:'label',
	 cls: 'classDiv1',    
     itemId: 'label1', 
	id : 'username',
	flex : .7
}, '-', {
	id : 'currentdate',
	 xtype:'label',
//	text : Ext.Date.format(new Date(), 'Y年m月d日')
	html : '<div>'+CurrentDate(true, true)+'</div>'
}, {
	// text : Ext.Date.format(new Date(), 'Y年m月d日')
	iconCls : 'icon-clock',
	 xtype:'label',
	 cls: 'classDiv1', 
	id : 'currenttime',
	width : 100
	// text : CurrentDate(true, true)
}	,  '-',
/*
{
	// style="font-weight:bold"
	text : '&nbsp&nbsp<font color="red">签到</font>&nbsp&nbsp',
	handler : function() {
		var me = this;
		var UserName = Ext.getCmp('username').getText(UserName);
		var loginName = Ext.getCmp('logon_userid')
				.getText(loginName);
		me.store = Ext.create('Fes.store.UsersignedStore');
		var record = new Fes.model.UsersignedModel({
					user_id : loginName,
					flag : 'I',
					scope : '1'
				});
		record.save({
			success : function(usersign, options) {
				var data = Ext
						.decode(options.response.responseText);
				if (data.failure) {
					Ext.Msg.show({
								title : '员工签到',
								msg : data.text,
								buttons : Ext.Msg.OK,
								icon : 'x-message-box-info'
							});
				} else {
					Ext.Msg.show({
								title : '员工签到',
								msg : "&nbsp;&nbsp;【&nbsp;"
										+ UserName + "&nbsp;】签到完成！",
								buttons : Ext.Msg.OK,
								icon : 'x-message-box-ok'
							});
				}
			}
		});

	}
}, '-',*/ {
	text : '菜单',
	iconCls : 'icon-logout',
	menu : new Ext.menu.Menu({
		items : [{
					text : '关于系统',
					iconCls : 'icon-info',
					handler : function() {
						new Ext.Window({
									closeAction : 'close',
									resizable : false,
									bodyStyle : 'padding: 7',
									modal : true,
									title : '关于本系统',
									html : '运维综合管理系统v1.0',
									width : 300,
									height : 200
								}).show();
					}
				}, {
					text : '退出系统',
					iconCls : 'icon-del',
					handler : function() {
						Ext.Msg.confirm('操作提示', '您确定要退出本系统?',
								function(btn) {
									if ('yes' == btn) {
										var mk = new Ext.LoadMask(
												document.body, {
													msg : '正在退出中，请稍候...'
													// removeMask:
													// true //完成后移除
												});
										mk.show();
										Ext.Ajax.request({
											url : 'j_spring_security_logout',
											success : function() {
												// location =
												// Ext.appPath +
												// '/logon.jsp';
												location = Ext.appPath;
												mk.hide(); // 关闭
											},
											failure : function() {
												Ext.Msg.show({
													title : '错误提示',
													msg : '退出系统失败!',
													icon : Ext.Msg.ERROR,
													buttons : Ext.Msg.OK
												});
												mk.hide(); // 关闭
											}
										});
									}
								});
					}
				}]
	})
}
	    ]
	}],
 
	bodyStyle : 'background-color:#157fCC; padding-left:20px;padding-top:0px;'
			+ 'font-size:22px;color:#FFFFFF;font-family:黑体;font-weight:bolder; ',
	init : function() {
		console.log('Header.Start...');
	},
	initComponent : function() {
		// Ext.getCmp('currentdate').setText(RunGLNL());
		this.createStore();
		this.store.load();
		var userStore = this.store;
		this.store.on("load", function(userStore) {
					var UserName = userStore.getAt(0).get('username');
					var loginName = userStore.getAt(0).get('loginName');
					Ext.getCmp('username').setText('当前登录：'+UserName);
					Ext.getCmp('logon_userid').setText(loginName);

				});
		this.callParent();

	},
	createStore : function() {
		var me = this;
		me.store = Ext.create('Fes.store.LoginUserStore');
	}
});
// Start a simple clock task that updates a div once per second
var updateClock = function() {
	Ext.getCmp('currenttime').setText(Ext.Date.format(new Date(), 'g:i:s A'));
}
// Configuration object for the task
var task = {
	run : updateClock, // the function to run
	interval : 1000
	// every second
}
// creates a new manager
var runner = new Ext.util.TaskRunner();
runner.start(task); // start runing the task every one second
