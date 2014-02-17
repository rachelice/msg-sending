Ext.define("Fes.store.ParameterStore4Tree",{
	extend:'Ext.data.TreeStore',
	 
	nodeParam : 'id',	
	baseParam:{},
	getBaseParam:function(){return this.baseParam;},
	setBaseParam:function(p){return this.baseParam=p;},
	proxy: {
        type: 'rest',
     	url: 'sysParameter/getTreeNodeChildren',
     	reader:{
           type : 'json',
            root:'root',
           totalProperty : 'total'// 数据的总数
       },
        
       writer:{
           type:'json'
           
       }
    },
    listeners : {
		load:function(s,records,success,e){

			
		},
		beforeload:function(store,operation,success,e){
			 
			
		}
    },
    autoLoad : true,
    remoteSort : true
});