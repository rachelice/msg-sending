
Ext.define("Fes.store.DeptStore",{
	extend:'Ext.data.Store',
	model:'Fes.model.DeptModel',	 
	pageSize : 20,
	baseParam:{},
	getBaseParam:function(){return this.baseParam;},
	setBaseParam:function(p){return this.baseParam=p;},
	listeners : {
	    load:function(s,records,success,e){
	       // alert(Ext.JSON.encode(records));
	
	},
	beforeload:function(store,operation,success,e){
	   // alert(Ext.JSON.encode(operation));
	//	operation=Ext.merge(operation,this.baseParam);
	
	    }
	}
});