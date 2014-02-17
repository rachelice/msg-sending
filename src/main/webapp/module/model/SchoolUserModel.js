Ext.define("Fes.model.SchoolUserModel",{
	extend:'Ext.data.Model',
	fields:[
			
			{name:'picPath',type:'string'}	,	//照片路径
			
			{name:'userEmail',type:'string'}	,	//邮件
			
			{name:'userBirthday',type:'string'}	,	//生日
			
			{name:'lastLoginTime',type:'string'}	,	//上一次登陆时间
			
			{name:'password',type:'string'}	,	//用户密码
			
			{name:'enabled',type:'string'}	,	//1：正常；0：仅不能登录，不影响任何业务筛选
			
			{name:'credentialsNonExpired',type:'string'}	,	//credentialsNonExpired
			
			{name:'accountNonLocked',type:'string'}	,	//accountNonLocked
			
			{name:'accountNonExpired',type:'string'}	,	//accountNonExpired
			
			{name:'clientId',type:'string'}	,	//clientId
			
			{name:'drivingschoolId',type:'string'}	,	//驾校id
			
			{name:'identityType',type:'string'}	,	//证件类型
			
			{name:'identityNum',type:'string'}	,	//证件号
			
			{name:'sex',type:'string'}	,	//性别
			
			{name:'race',type:'string'}	,	//名族
			
			{name:'coachData',type:'string'}	,	//驾校数据
			
			{name:'organizationId',type:'string'}	,	//机构
			
			{name:'fingerFeaturesOne',type:'string'}	,	//指纹特征码1
			
			{name:'fingerFeaturesTwo',type:'string'}	,	//指纹特征码2
			
			{name:'uuid',type:'string'}	,	//uuid
			
			{name:'updateTime',type:'string'}	,	//更新时间
			
			{name:'createTime',type:'string'}	,	//创建时间
			
			{name:'version',type:'string'}	,	//版本
			
			{name:'objectType',type:'string'}	,	//objectType
			
			{name:'userName',type:'string'}	,	//用户名
			
			{name:'loginName',type:'string'}	,	//登录名
			
			{name:'userTel',type:'string'}	,	//联系电话
			
			{name:'userMobileTel',type:'string'}	,	//手机联系方式
		{name:'id',type:'int'}
		 
	],
    proxy:{
   
        type : 'rest',
        url:'schoolUsers',
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