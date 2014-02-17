Ext.define('SimpleReports.model.List', {
    extend: 'Ext.data.Model',
     
    fields: [
        { name: 'id', type: 'int' },
      //  { name: 'name',mapping:'parName' },
        
         {name:'parName',type:'string',defaultValue:'未命名'}	,	//参数名称

        {name:'parCode',type:'string'}	,	//参数代码

        {name:'parUpId',type:'string'}	,	//上级参数

        {name:'icoUrl',type:'string'}	,	//图标路径

        {mapping: 'isDir',name:'leaf',type:'boolean',defaultValue:false, convert: function (value, record) {console.log(value);return value&&!(value=='1');}}	,	//是否有子类

        {name:'parType',type:'string'}	,	//参数类型

        {name:'parLev',type:'string'}	,	//层级

        {name:'expanded',mapping:'isExp',defaultValue:false,type:'boolean' }	,	//是否默认展开

        {name:'sortIndex',type:'int'}	,	//排序序号

        {name:'isDef',type:'string',defaultValue:false,convert: function (value, record) {return value&&value==='0';}}	 	//默认选中
        
        // if we are using local storage, we need to persist the index field so the ordering of tree nodes will be preserved
        //{name: 'index', type: 'int', defaultValue: null, persist: !!SimpleReportsSettings.useLocalStorage}
    ] 
/*
    proxy: SimpleReportsSettings.useLocalStorage ? {
        type: 'localstorage',
        id: 'SimpleReports-List'
    } : {
        type: 'ajax',
        api: {
            create: 'php/list/create.php',
            read: 'php/list/read.php',
            update: 'php/list/update.php',
            destroy: 'php/list/delete.php'
        },

        reader: {
            type: 'json',
            messageProperty: 'message'
        }
    }*/
});