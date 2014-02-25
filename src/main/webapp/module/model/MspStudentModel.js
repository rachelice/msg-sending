Ext.define("Fes.model.MspStudentModel",{
	extend:'Ext.data.Model',
	fields:[
				{name:'licenseCode',type:'string'}	,	//驾校许可证号
			
			
				{name:'enterpriseName',type:'string'}	,	//驾校名称
			
			
				{name:'semesterName',type:'string'}	,	//班期名称
			
			
				{name:'userTel',type:'string'}	,	//电话
			
			
				{name:'enterpriseId',type:'string'}	,	//驾校id
			
			
				{name:'learnerName',type:'string'}	,	//学员姓名
			
			
				{name:'identityNumber',type:'string'}	,	//身份证号
			
			
				{name:'gender',type:'string'}	,	//性别
			
			
				{name:'semesterId',type:'string'}	,	//班期id
			
			
				{name:'mobileNumber',type:'string'}	,	//手机号码
			
			
				{name:'subjectOneThFinishtime',type:'string'}	,	//科目一已完成学时
			
			
				{name:'subjectTwoThFinishtime',type:'string'}	,	//科目二理论已完成学时
			
			
				{name:'subjectTwoOpFinishtime',type:'string'}	,	//科目二实操已完成学时
			
			
				{name:'subjectThreeThFinishtime',type:'string'}	,	//科目三理论已完成学时
			
			
				{name:'subjectThreeOpFinishtime',type:'string'}	,	//科目三实操已完成学时
			
			
				{name:'updateTime',type:'auto'}	,	//更新时间
			
				{name:'createTime',type:'auto'}	,	//创建时间
			
				{name:'remark',type:'string'}	,	//备注
			
			
		{name:'id',type:'int'}
		 
	],
	
	   proxy:{
		appendId:false,
        type : 'rest',
        url:'mspStudent',
        actionMethods:{
        	  create : 'POST',
              read   : 'GET',
              update : 'PUT',
              destroy: 'DELETE' 
        	
        },
        api:{
        	create:'mspStudent/create',
        	read:'mspStudent/list',
        	update:'mspStudent/update',
        	destroy:'mspStudent/delete' 
        	 
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