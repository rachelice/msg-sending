Ext.define('Fes.view.MspMsgTaskHistoryWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.mspmsgtaskhistorywindow',
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
    	 
    	  items:  Ext.create('Fes.view.MspMsgTaskHistoryForm')
    	});
		this.callParent(arguments);
	}
});
