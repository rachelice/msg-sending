Ext.define('Fes.view.MspStudentWindow',{
	extend: 'Ext.window.Window',
	alias: 'widget.mspstudentwindow',
	title: '[学员表]',
    width: 1000,
    height: 350,
    plain: true,
    headerPosition: 'top',
    
     
    constrain: true,
    buttonAlign: 'center',
    resizable: false,
     
    
    initComponent : function() {
    	 
    	Ext.apply(this,{ 
    	 
    	  items:  Ext.create('Fes.view.MspStudentForm')
    	});
		this.callParent(arguments);
	}
});
