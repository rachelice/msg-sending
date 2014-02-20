
#import <Foundation/Foundation.h>
//*/* 表名 MSP_STUDENT /*/*//
@interface MspStudent :NSObject
 		////类型 java.lang.String  说明 驾校许可证号 字段名 LICENSE_CODE 
 	
		@property (nonatomic, strong) NSString ////licenseCode;
 	
 	
 

 		////类型 java.lang.String  说明 驾校名称 字段名 ENTERPRISE_NAME 
 	
		@property (nonatomic, strong) NSString ////enterpriseName;
 	
 	
 

 		////类型 java.lang.String  说明 班期名称 字段名 SEMESTER_NAME 
 	
		@property (nonatomic, strong) NSString ////semesterName;
 	
 	
 

 		////类型 java.lang.String  说明 电话 字段名 USER_TEL 
 	
		@property (nonatomic, strong) NSString ////userTel;
 	
 	
 

 		////类型 java.lang.Long  说明 ID 字段名 ID 
		@property (nonatomic, strong) NSNumber ////id;
 	
 	
 	
 

 		////类型 java.lang.Long  说明 驾校id 字段名 ENTERPRISE_ID 
		@property (nonatomic, strong) NSNumber ////enterpriseId;
 	
 	
 	
 

 		////类型 java.lang.String  说明 学员姓名 字段名 LEARNER_NAME 
 	
		@property (nonatomic, strong) NSString ////learnerName;
 	
 	
 

 		////类型 java.lang.String  说明 身份证号 字段名 IDENTITY_NUMBER 
 	
		@property (nonatomic, strong) NSString ////identityNumber;
 	
 	
 

 		////类型 java.lang.String  说明 性别 字段名 GENDER 
 	
		@property (nonatomic, strong) NSString ////gender;
 	
 	
 

 		////类型 java.lang.Long  说明 班期id 字段名 SEMESTER_ID 
		@property (nonatomic, strong) NSNumber ////semesterId;
 	
 	
 	
 

 		////类型 java.lang.String  说明 手机号码 字段名 MOBILE_NUMBER 
 	
		@property (nonatomic, strong) NSString ////mobileNumber;
 	
 	
 

 		////类型 java.math.BigDecimal  说明 科目一已完成学时 字段名 SUBJECT_ONE_TH_FINISHTIME 
 	
 	
 	
 

 		////类型 java.math.BigDecimal  说明 科目二理论已完成学时 字段名 SUBJECT_TWO_TH_FINISHTIME 
 	
 	
 	
 

 		////类型 java.math.BigDecimal  说明 科目二实操已完成学时 字段名 SUBJECT_TWO_OP_FINISHTIME 
 	
 	
 	
 

 		////类型 java.math.BigDecimal  说明 科目三理论已完成学时 字段名 SUBJECT_THREE_TH_FINISHTIME 
 	
 	
 	
 

 		////类型 java.math.BigDecimal  说明 科目三实操已完成学时 字段名 SUBJECT_THREE_OP_FINISHTIME 
 	
 	
 	
 

 		////类型 java.util.Date  说明 更新时间 字段名 UPDATE_TIME 
 	
 	
		@property (nonatomic, strong) NSDate ////updateTime;
 	
 

 		////类型 java.util.Date  说明 创建时间 字段名 CREATE_TIME 
 	
 	
		@property (nonatomic, strong) NSDate ////createTime;
 	
 

 		////类型 java.lang.String  说明 备注 字段名 REMARK 
 	
		@property (nonatomic, strong) NSString ////remark;
 	
 	
 

@end
