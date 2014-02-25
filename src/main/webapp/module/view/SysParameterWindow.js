Ext.define('Fes.view.SysParameterWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.sysparameterwindow',
	title: '[参数]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.SysParameterForm')
    	});
		this.callParent(arguments);
	}
});
