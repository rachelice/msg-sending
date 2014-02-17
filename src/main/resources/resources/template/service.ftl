package ${bussiPackage}.${entityPackage}.service;

import java.util.List;
 
import ${bussiPackage}.${entityPackage}.entity.${entityName};
import ${bussiPackage}.${entityPackage}.entityvo.${entityName}Vo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface ${entityName}Service extends IBaseService<${entityName}, Integer>{
	public List<${entityName}Vo> list(${entityName} entity) ;
}
