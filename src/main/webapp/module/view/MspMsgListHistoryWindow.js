Ext.define('Fes.view.MspMsgListHistoryWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.mspmsglisthistorywindow',
	title: '[短信清单历史记录]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.MspMsgListHistoryForm')
    	});
		this.callParent(arguments);
	}
});
