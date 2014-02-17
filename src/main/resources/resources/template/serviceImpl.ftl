package ${bussiPackage}.${entityPackage}.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   ${bussiPackage}.${entityPackage}.service.${entityName}Service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${bussiPackage}.${entityPackage}.dao.${entityName}Dao;
import ${bussiPackage}.${entityPackage}.entity.${entityName};
import ${bussiPackage}.${entityPackage}.entityvo.${entityName}Vo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("${entityName?uncap_first}Service")
@Transactional
public class ${entityName}ServiceImpl extends BaseServiceImpl<${entityName}, Integer>  implements ${entityName}Service {
	@Autowired
	private ${entityName}Dao  ${entityName?uncap_first}Dao;

	public List<${entityName}Vo> list(${entityName} entity) {
		HQLParameter p = new HQLParameter(${entityName}.class);	   
		return ListUtils.transform(${entityName?uncap_first}Dao.findPageByHql(" from ${entityName} "   ),
				${entityName}Vo.class);
	}
	
		@Override
	public void update(${entityName} model)  {
		this.${entityName?uncap_first}Dao.update(model);	
	}
	
	@Override
	public ${entityName} save(${entityName} model)   {
		this.${entityName?uncap_first}Dao.save(model);	
		return model;
	}

	@Override
	public void delete(${entityName} model)  {
		this.${entityName?uncap_first}Dao.delete(model);	
	}
}


	