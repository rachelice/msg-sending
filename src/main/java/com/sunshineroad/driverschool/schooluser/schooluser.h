
#import <Foundation/Foundation.h>
//*/* 表名 cip_user /*/*//
@interface SchoolUser :NSObject
 		////类型 java.lang.String  说明 照片路径 字段名 PIC_PATH 
 	
		@property (nonatomic, strong) NSString ////picPath;
 	
 	
 

 		////类型 java.lang.String  说明 邮件 字段名 USER_EMAIL 
 	
		@property (nonatomic, strong) NSString ////userEmail;
 	
 	
 

 		////类型 java.util.Date  说明 生日 字段名 USER_BIRTHDAY 
 	
 	
		@property (nonatomic, strong) NSDate ////userBirthday;
 	
 

 		////类型 java.util.Date  说明 上一次登陆时间 字段名 LAST_LOGIN_TIME 
 	
 	
		@property (nonatomic, strong) NSDate ////lastLoginTime;
 	
 

 		////类型 java.lang.String  说明 用户密码 字段名 PASSWORD 
 	
		@property (nonatomic, strong) NSString ////password;
 	
 	
 

 		////类型 java.lang.Long  说明 1：正常；0：仅不能登录，不影响任何业务筛选 字段名 ENABLED 
		@property (nonatomic, strong) NSNumber ////enabled;
 	
 	
 	
 

 		////类型 java.lang.Long  说明 credentialsNonExpired 字段名 CREDENTIALS_NON_EXPIRED 
		@property (nonatomic, strong) NSNumber ////credentialsNonExpired;
 	
 	
 	
 

 		////类型 java.lang.Long  说明 accountNonLocked 字段名 ACCOUNT_NON_LOCKED 
		@property (nonatomic, strong) NSNumber ////accountNonLocked;
 	
 	
 	
 

 		////类型 java.lang.Long  说明 accountNonExpired 字段名 ACCOUNT_NON_EXPIRED 
		@property (nonatomic, strong) NSNumber ////accountNonExpired;
 	
 	
 	
 

 		////类型 java.lang.Long  说明 clientId 字段名 CLIENT_ID 
		@property (nonatomic, strong) NSNumber ////clientId;
 	
 	
 	
 

 		////类型 java.lang.Long  说明 驾校id 字段名 DRIVINGSCHOOL_ID 
		@property (nonatomic, strong) NSNumber ////drivingschoolId;
 	
 	
 	
 

 		////类型 java.lang.String  说明 证件类型 字段名 IDENTITY_TYPE 
 	
		@property (nonatomic, strong) NSString ////identityType;
 	
 	
 

 		////类型 java.lang.String  说明 证件号 字段名 IDENTITY_NUM 
 	
		@property (nonatomic, strong) NSString ////identityNum;
 	
 	
 

 		////类型 java.lang.String  说明 性别 字段名 SEX 
 	
		@property (nonatomic, strong) NSString ////sex;
 	
 	
 

 		////类型 java.lang.String  说明 名族 字段名 RACE 
 	
		@property (nonatomic, strong) NSString ////race;
 	
 	
 

 		////类型 java.lang.String  说明 驾校数据 字段名 COACH_DATA 
 	
		@property (nonatomic, strong) NSString ////coachData;
 	
 	
 

 		////类型 java.lang.Long  说明 机构 字段名 ORGANIZATION_ID 
		@property (nonatomic, strong) NSNumber ////organizationId;
 	
 	
 	
 

 		////类型 java.lang.String  说明 指纹特征码1 字段名 FINGER_FEATURES_ONE 
 	
		@property (nonatomic, strong) NSString ////fingerFeaturesOne;
 	
 	
 

 		////类型 java.lang.String  说明 指纹特征码2 字段名 FINGER_FEATURES_TWO 
 	
		@property (nonatomic, strong) NSString ////fingerFeaturesTwo;
 	
 	
 

 		////类型 java.lang.Long  说明 学员id，学员唯一标示 字段名 ID 
		@property (nonatomic, strong) NSNumber ////id;
 	
 	
 	
 

 		////类型 java.lang.String  说明 uuid 字段名 UUID 
 	
		@property (nonatomic, strong) NSString ////uuid;
 	
 	
 

 		////类型 java.util.Date  说明 更新时间 字段名 UPDATE_TIME 
 	
 	
		@property (nonatomic, strong) NSDate ////updateTime;
 	
 

 		////类型 java.util.Date  说明 创建时间 字段名 CREATE_TIME 
 	
 	
		@property (nonatomic, strong) NSDate ////createTime;
 	
 

 		////类型 java.lang.Long  说明 版本 字段名 VERSION 
		@property (nonatomic, strong) NSNumber ////version;
 	
 	
 	
 

 		////类型 java.lang.String  说明 objectType 字段名 OBJECT_TYPE 
 	
		@property (nonatomic, strong) NSString ////objectType;
 	
 	
 

 		////类型 java.lang.String  说明 用户名 字段名 USER_NAME 
 	
		@property (nonatomic, strong) NSString ////userName;
 	
 	
 

 		////类型 java.lang.String  说明 登录名 字段名 LOGIN_NAME 
 	
		@property (nonatomic, strong) NSString ////loginName;
 	
 	
 

 		////类型 java.lang.String  说明 联系电话 字段名 USER_TEL 
 	
		@property (nonatomic, strong) NSString ////userTel;
 	
 	
 

 		////类型 java.lang.String  说明 手机联系方式 字段名 USER_MOBILE_TEL 
 	
		@property (nonatomic, strong) NSString ////userMobileTel;
 	
 	
 

@end
