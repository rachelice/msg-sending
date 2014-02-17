
#import <Foundation/Foundation.h>
//*/* 表名 sys_parameter /*/*//
@interface SysParameter :NSObject
 		////类型 java.lang.Long  说明 id 字段名 ID 
		@property (nonatomic, strong) NSNumber ////id;
 	
 	
 	
 

 		////类型 java.lang.String  说明 参数名称 字段名 PAR_NAME 
 	
		@property (nonatomic, strong) NSString ////parName;
 	
 	
 

 		////类型 java.lang.String  说明 参数代码 字段名 PAR_CODE 
 	
		@property (nonatomic, strong) NSString ////parCode;
 	
 	
 

 		////类型 java.lang.Long  说明 上级参数 字段名 PAR_UP_ID 
		@property (nonatomic, strong) NSNumber ////parUpId;
 	
 	
 	
 

 		////类型 java.lang.String  说明 图标路径 字段名 ICO_URL 
 	
		@property (nonatomic, strong) NSString ////icoUrl;
 	
 	
 

 		////类型 java.lang.Integer  说明 是否有子类 字段名 IS_DIR 
 	
 	
 	
 

 		////类型 java.lang.String  说明 参数类型 字段名 PAR_TYPE 
 	
		@property (nonatomic, strong) NSString ////parType;
 	
 	
 

 		////类型 java.lang.Integer  说明 层级 字段名 PAR_LEV 
 	
 	
 	
 

 		////类型 java.lang.Integer  说明 是否默认展开 字段名 IS_EXP 
 	
 	
 	
 

 		////类型 java.lang.Integer  说明 排序序号 字段名 SORT_INDEX 
 	
 	
 	
 

 		////类型 java.lang.Integer  说明 默认选中 字段名 IS_DEF 
 	
 	
 	
 

@end
