Ext.define("Fes.model.${entityName}Model",{
	extend:'Ext.data.Model',
	fields:[
		<#list columns as po>
			<#if po.fieldType =='date' >
				{name:'${po.fieldName}',type:'auto'}	,	//${po.filedComment}
			 <#else>
				{name:'${po.fieldName}',type:'string'}	,	//${po.filedComment}
			</#if>
		</#list>
		{name:'id',type:'int'}
	],
	
	   proxy:{
        type : 'rest',
        appendId:false,
        url:'${entityName?uncap_first}',
        actionMethods:{
        	create : 'POST',
            read   : 'GET',
            update : 'PUT',
            destroy: 'DELETE' 
        },
        api:{
        	create:'${entityName?uncap_first}/create',
        	read:'${entityName?uncap_first}/list',
        	update:'${entityName?uncap_first}/update',
        	destroy:'${entityName?uncap_first}/delete'  
        },
        reader:{
            type : 'json',
            root : 'root',
            totalProperty : 'total'// 数据的总数
        },
        writer:{
            type:'json'
        }
    }
});