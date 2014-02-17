


#import \"${entityName}.h\"

@implementation ${entityName}
<#assign notFirst = false>
////@synthesize <#list originalColumns as po><#if notFirst>,</#if>${po.fieldName}<#assign notFirst = true></#list>; 
@end


 
 