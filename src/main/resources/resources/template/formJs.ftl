 
Ext.define('Fes.view.${entityName}Form', {
	extend: 'Ext.form.Panel',
	xtype: '${entityPackage}form',
	alias: 'widget.${entityPackage}form',
	
    frame: true,
    bodyPadding: 10,
    border: 0,
    id: '${entityPackage}form-id',
    fieldDefaults: {
        labelAlign: 'right',
        anchor: '99%',
        labelWidth: 110
    },
    defaults:{layout:'anchor',
    		  defaults:{anchor:'100%'}
    },
    layout: 'column',
    items: [
<#list columns as po>
//${po.fieldType}
		<#if po.fieldType =="date" >	 
	      	  {xtype: 'datefield',format:'Y-m-d',allowBlank: false,columnWidth:1/4,fieldLabel: '${po.filedComment}',name: '${po.fieldName}'}, 
			<#elseif po.fieldType =="number">
	      	  {xtype: 'numberfield',allowBlank: false,columnWidth:1/4,fieldLabel: '${po.filedComment}',name: '${po.fieldName}'},
	      	 <#else>
	      	  {xtype: 'textfield',allowBlank: false,columnWidth:1/4,fieldLabel: '${po.filedComment}',name: '${po.fieldName}'},
	      	 
	    </#if>
</#list>
					
					{xtype:'hidden',name:'id'}
						        	
						          
						            
             ]

}); 