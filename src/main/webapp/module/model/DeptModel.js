
Ext.define("Fes.model.DeptModel",{
	extend:'Ext.data.Model',
	fields:[
		{name:'deptName',type:'string'},
		{name:'id',type:'string'},
		{name:'deptCode',type:'string'},
		{name:'parentId',type:'int'},
		{name:'parentDeptName',type:'string'},
		{name:'orderIndex',type:'int'},
		{name:'manager',type:'string'}
	],
    proxy:{
        /* api:{
         update:'dept3.jsp',
         remove:'dept3.jsp'
         },*/
        type : 'rest',
        url:'depts',
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