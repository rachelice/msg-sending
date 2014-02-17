package com.sunshineroad.driverschool.schooluser.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.schooluser.service.SchoolUserService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.schooluser.dao.SchoolUserDao;
import com.sunshineroad.driverschool.schooluser.entity.SchoolUser;
import com.sunshineroad.driverschool.schooluser.entityvo.SchoolUserVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("schoolUserService")
@Transactional
public class SchoolUserServiceImpl extends BaseServiceImpl<SchoolUser, Integer>  implements SchoolUserService {
	@Autowired
	private SchoolUserDao  schoolUserDao;

	public List<SchoolUserVo> list(SchoolUser entity) {
		HQLParameter p = new HQLParameter(SchoolUser.class);	   
		return ListUtils.transform(schoolUserDao.findPageByHql(" from SchoolUser "   ),
				SchoolUserVo.class);
	}
}


