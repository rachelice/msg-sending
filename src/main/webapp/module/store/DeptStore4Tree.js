Ext.define("Fes.store.DeptStore4Tree",{
	extend:'Ext.data.TreeStore',
	defaultRootId:'root',
	 autoLoad:true,
	// model:'Fes.model.DeptTreeNode',
	  root : {
	       id : 0,
	       leaf:false,
	       
	       text :'总行',
	       expanded:true
	   },
	nodeParam : 'id' ,
    listeners : {
        load:function(s,node,records,success,e){
        	 
        	// Ext.Msg.alert('12',Ext.JSON.encode(records[0].data));
        			if(success){
        				for(var i=0;i<records.length;i++){
        				//	alert(records[i].data.deptName);
        				//	records[i].data.text=records[i].data.deptName;
        				}
        			}

        }
    },
	proxy:{
		type:'ajax',
	 
		url:'depts/root',
		reader:'json'	
	}	
});