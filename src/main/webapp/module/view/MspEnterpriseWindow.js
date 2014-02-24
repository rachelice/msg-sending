Ext.define('Fes.view.MspEnterpriseWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.mspenterprisewindow',
	title: '[企业表]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.MspEnterpriseForm')
    	});
		this.callParent(arguments);
	}
});
