
#import <Foundation/Foundation.h>
//*/* 表名 ${tableName} /*/*//
@interface ${entityName} :NSObject
 	<#list originalColumns as po>
 		////类型 ${po.fieldType}  说明 ${po.filedComment} 字段名 ${po.fieldDbName} 
 	<#if po.fieldType =='java.lang.Long'>
		@property (nonatomic, strong) NSNumber ////${po.fieldName};
 	</#if>
 	
 	<#if  po.fieldType =='java.lang.String'>
		@property (nonatomic, strong) NSString ////${po.fieldName};
 	</#if>
 	
 	<#if  po.fieldType =='java.util.Date'>
		@property (nonatomic, strong) NSDate ////${po.fieldName};
 	</#if>
 	
 

	</#list>
@end
 