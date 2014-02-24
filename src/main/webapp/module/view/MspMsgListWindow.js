Ext.define('Fes.view.MspMsgListWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.mspmsglistwindow',
	title: '[短信清单]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.MspMsgListForm')
    	});
		this.callParent(arguments);
	}
});
