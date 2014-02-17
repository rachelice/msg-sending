Ext.define('Fes.view.Navigation', {
	   	    alias: 'widget.navigation',
			extend : 'Ext.panel.Panel',
			region : 'west',
			title : '系统菜单',
			width : 245,
			iconCls : "icon-tree",
			collapsible:true,
			animCollapse:true,
			 collapseFirst:true,
			 collapseDirection:true,
			 headerPostion:'left',
			//layout : 'fit',
			 
			layoutConfig : {
				animate : true
			},
			id : 'navigation',
			split : true,
			initComponent : function(){
				this.callParent();
			}
		});
 
