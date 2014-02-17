package com.sunshineroad.driverschool.sysparameter.service;

import java.util.List;

import com.sunshineroad.driverschool.sysparameter.entity.SysParameter;
import com.sunshineroad.driverschool.sysparameter.entityvo.SysParameterVo;
import com.sunshineroad.framework.support.service.IBaseService;
import com.sunshineroad.framework.util.TreeNode;

public interface SysParameterService extends IBaseService<SysParameter, Integer>{
	public List<SysParameterVo> list(SysParameterVo sysParameterVo) ;

	public List<TreeNode> getChildrenById(Long id);
	

	public String  getParameterNameById(Long id);
}
