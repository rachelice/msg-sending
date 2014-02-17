
Ext.Loader.setConfig({
			enabled : true
		});

Ext.Loader.setPath({
			'Ext.ux' : extLibPath + '/examples/ux',
			//'SimpleTasks' : extLibPath + '/examples/simple-tasks/app',  
			'SimpleReports' : ctx + '/absolute/simple-reports/app',
			
			'Ext.app' : extLibPath + '/examples/app',
			'Fes' : 'module'
		});

Ext.require(['Fes.MsgBox', 'Ext.data.*',  'Ext.util.*']);

Ext.Ajax.on('requestexception', function(conn, response, options) {
	
			var repsonset_Text=response.status;
			   
			if(repsonset_Text=='403')repsonset_Text="您没有权限访问此资源！请联系管理员。";
			var msg = '访问系统资源时发生异常<br/>' + '异常状态:' + response.status + '('
					+ response.statusText + ')<br/>' + '异常信息:'
					+ repsonset_Text;
			Ext.Msg.show({
						title : '系统异常',
						msg : msg,
						width : 400,
						icon : Ext.MessageBox.ERROR,
						buttonText : {
							ok : '&nbsp;&nbsp;提交错误报告&nbsp;&nbsp;'
						},
						buttons : Ext.MessageBox.OKCANCEL
					});
		});
Ext.get('loading-msg').update('加载系统组件...');
 var application=Ext.create('Fes.Desktop');