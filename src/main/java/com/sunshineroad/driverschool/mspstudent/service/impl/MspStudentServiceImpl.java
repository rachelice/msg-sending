package com.sunshineroad.driverschool.mspstudent.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.mspstudent.service.MspStudentService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.mspstudent.dao.MspStudentDao;
import com.sunshineroad.driverschool.mspstudent.entity.MspStudent;
import com.sunshineroad.driverschool.mspstudent.entityvo.MspStudentVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("mspStudentService")
@Transactional
public class MspStudentServiceImpl extends BaseServiceImpl<MspStudent, Integer>  implements MspStudentService {
	@Autowired
	private MspStudentDao  mspStudentDao;

	public List<MspStudentVo> list(MspStudent entity) {
		HQLParameter p = new HQLParameter(MspStudent.class);	   
		return ListUtils.transform(mspStudentDao.findPageByHql(" from MspStudent "   ),
				MspStudentVo.class);
	}
	
		@Override
	public void update(MspStudent model)  {
		this.mspStudentDao.update(model);	
	}
	
	@Override
	public MspStudent save(MspStudent model)   {
		this.mspStudentDao.save(model);	
		return model;
	}

	@Override
	public void delete(MspStudent model)  {
		this.mspStudentDao.delete(model);	
	}
}


