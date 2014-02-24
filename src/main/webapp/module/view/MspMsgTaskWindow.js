Ext.define('Fes.view.MspMsgTaskWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.mspmsgtaskwindow',
	title: '[短信任务]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.MspMsgTaskForm')
    	});
		this.callParent(arguments);
	}
});
