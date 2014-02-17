package com.sunshineroad.driverschool.schooluser.service;

import java.util.List;
 
import com.sunshineroad.driverschool.schooluser.entity.SchoolUser;
import com.sunshineroad.driverschool.schooluser.entityvo.SchoolUserVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface SchoolUserService extends IBaseService<SchoolUser, Integer>{
	public List<SchoolUserVo> list(SchoolUser entity) ;
}
