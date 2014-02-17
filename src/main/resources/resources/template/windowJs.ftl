Ext.define('Fes.view.${entityName}Window',{
	extend: 'Ext.window.Window',
	alias: 'widget.${entityPackage}window',
	title: '[${ftl_description}]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.${entityName}Form')
    	});
		this.callParent(arguments);
	}
});
