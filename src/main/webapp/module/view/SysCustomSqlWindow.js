Ext.define('Fes.view.SysCustomSqlWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.syscustomsqlwindow',
	title: '[报表]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.SysCustomSqlForm')
    	});
		this.callParent(arguments);
	}
});
